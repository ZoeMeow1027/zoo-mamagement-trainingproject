package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Animal_Type;

@Repository
public class AnimalTypeDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	 private class AnimalTypeRowMapper implements RowMapper<Animal_Type> {
	        public Animal_Type mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Animal_Type animalType = new Animal_Type();
	            animalType.setIdAnimalType(rs.getInt("ID_Animal_Type"));
	            animalType.setAnimalType(rs.getString("Animal_Type"));
	            return animalType;
	        }

	 }
	@SuppressWarnings("deprecation")
	public Animal_Type getAnimaTypelByIdAnimal(int idAnimalType) {
		Object[] params = new Object[]{idAnimalType};
 	    String sql = "SELECT * FROM Animal_Type WHERE ID_Animal_Type = ?";
 	    return jdbcTemplate.queryForObject(sql, params, new AnimalTypeRowMapper());
	}

	public List<Animal_Type> showTypes() {
		String sql = "SELECT * FROM Animal_Type";
	    return jdbcTemplate.query(sql, new AnimalTypeRowMapper());
	}
	

}
