package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Animal;
import fa.intern.mock.bean.Animal_Type;
import fa.intern.mock.bean.Cage;

@Repository
public class AnimalDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class AnimalRowMapper implements RowMapper<Animal> {
		public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
			Animal animal = new Animal();
			animal.setIdAnimal(rs.getInt("ID_Animal"));
			animal.setAnimalName(rs.getString("Animal_Name"));
			animal.setAnimalStatus(rs.getString("Animal_Status"));
			animal.setDetail(rs.getString("Details"));
			animal.setFood(rs.getString("Food"));
			Cage cage = new Cage();
			cage.setIdCage(rs.getInt("ID_Cage"));
			// cage.setLimit(rs.getInt("Limit"));
			animal.setCages(cage);
			Animal_Type animalType = new Animal_Type();
			animalType.setIdAnimalType(rs.getInt("ID_Animal_Type"));
			animalType.setAnimalType(rs.getString("Animal_Type"));
			animal.setTypes(animalType);
			return animal;
		}
	}

	@SuppressWarnings("deprecation")
	public List<Animal> getAnimalByIDCage(int idCage) {
		Object[] params = new Object[] { idCage };
		String sql = "SELECT a.ID_Animal, a.Animal_Status, a.Animal_Name, a.Details, a.Food,\r\n"
				+ "c.ID_Cage, c.Limit,\r\n"
				+ "t.ID_Animal_Type, t.Animal_Type\r\n"
				+ "FROM animal as a \r\n"
				+ "inner join animal_type as t\r\n"
				+ "on a.ID_Animal_Type = t.ID_Animal_Type\r\n"
				+ "inner join cage as c \r\n"
				+ "on c.ID_Cage = a.ID_Cage WHERE c.ID_Cage = ?";
		return jdbcTemplate.query(sql, params, new AnimalRowMapper());
	}

	public boolean deleteAnimal(int idAnimal) {
		String sql = "delete from Animal where ID_Animal = ?";
		Object[] params = new Object[] { idAnimal };
		if (jdbcTemplate.update(sql, params) != 0) {
			return true;
		}
		return false;
	}

	public List<Animal> showAnimalInfo(int idAnimal) {
		Object[] params = new Object[] { idAnimal };
		String sql = "SELECT * FROM animal join animal_type on animal.ID_Animal_Type = animal_type.ID_Animal_Type "
				+ "WHERE ID_Animal = ?";
		return jdbcTemplate.query(sql, params, new AnimalRowMapper());
	}

	public List<Animal> searchAnimal(String idCage, String option, String search) {
		String sql = null;

		if (option.equals("ID động vật")) {
			sql = "SELECT * FROM animal JOIN animal_type on animal.ID_Animal_Type = animal_type.ID_Animal_Type "
					+ "WHERE ID_Animal LIKE " + "'%" + search + "%'";
		} else if (option.equals("Tên động vật")) {
			sql = "SELECT * FROM animal JOIN animal_type on animal.ID_Animal_Type = animal_type.ID_Animal_Type "
					+ "WHERE Animal_Name LIKE " + "'%" + search + "%'";
		} else if (option.equals("Loài động vật")) {
			sql = "SELECT a.ID_Cage, a.ID_Animal, a.Animal_Name, a.Animal_Status, a.Details, a.Food, t.ID_Animal_Type, t.Animal_Type\r\n"
					+ "FROM animal a\r\n"
					+ "JOIN animal_type t ON a.ID_Animal_Type = t.ID_Animal_Type\r\n"
					+ "WHERE t.Animal_Type LIKE " + "'%" + search + "%'";
		}
		sql += idCage == null ? "" : " AND ID_Cage=" + idCage;

		return jdbcTemplate.query(sql, new AnimalRowMapper());
	}

	public void editAnimal(int idAnimal, String animalName, String animalStatus, String detail, String food,
			int animalType) {
		String sql = "UPDATE Animal SET Animal_Name = ?, Animal_Status = ?, Details = ?, Food = ?, ID_Animal_Type = ?"
				+ " WHERE ID_Animal = ?";
		Object[] params = new Object[] { animalName, animalStatus, detail, food, animalType, idAnimal };
		jdbcTemplate.update(sql, params);
	}

	public void addAnimal(int idCage, String animalName, String status, String detail, String food, int type)
			throws Exception {
		String sql = "INSERT INTO Animal(ID_Cage, Animal_Name, Animal_Status, Details, Food, ID_Animal_Type)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] { idCage, animalName, status, detail, food, type };
		int rs = jdbcTemplate.update(sql, params);
		if (rs != 1) {
			throw new Exception();
		}

	}

}
