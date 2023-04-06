package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import fa.intern.mock.bean.Cage;
import fa.intern.mock.bean.Staff;

@Repository
public class CageDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class CageRowMapper implements RowMapper<Cage> {
		public Cage mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cage cage = new Cage();
			cage.setIdCage(rs.getInt("ID_Cage"));
			cage.setNameCage(rs.getString("Name_Cage"));
			cage.setLimit(rs.getInt("Limit"));
			Staff staff = new Staff();
			staff.setIdStaff(rs.getInt("ID_Staff"));
			staff.setStaffName(rs.getString("Staff_Name"));
			cage.setStaffs(staff);
			return cage;
		}
	}

	public boolean deleteCage(int idCage) {
		String sql = "delete from Cage where ID_Cage = ?";
		Object[] params = new Object[] { idCage };
		if (jdbcTemplate.update(sql, params) != 0) {
			return true;
		}
		return false;
	}

	public List<Cage> searchCage(String option, String search) {
		String sql = null;

		if (option.equals("Mã chuồng")) {
			sql = "SELECT * FROM Cage JOIN staff on Cage.ID_Staff = Staff.ID_Staff "
					+ "WHERE ID_Cage LIKE " + "'%" + search + "%'";
		} else if (option.equals("Tên chuồng")) {
			sql = "SELECT * FROM Cage JOIN staff on Cage.ID_Staff = Staff.ID_Staff "
					+ "WHERE Name_Cage LIKE " + "'%" + search + "%'";
		} else if (option.equals("Người chăm sóc")) {
			sql = "SELECT c.ID_Cage, c.Name_Cage, c.Limit,s.ID_Staff, s.Staff_Name\r\n"
					+ "FROM Cage c\r\n"
					+ "JOIN Staff s ON c.ID_Staff = s.ID_Staff\r\n"
					+ "WHERE s.Staff_Name LIKE " + "'%" + search + "%'";
		}

		return jdbcTemplate.query(sql, new CageRowMapper());
	}

	public List<Cage> showAllCage() {
		String sql = "SELECT * FROM Cage JOIN Staff ON Cage.ID_Staff = Staff.ID_Staff";
		return jdbcTemplate.query(sql, new CageRowMapper());
	}

	@SuppressWarnings("deprecation")
	public List<Cage> showCageInfo(int idCage) {
		Object[] params = new Object[] { idCage };
		String sql = "SELECT * FROM Cage JOIN Staff on Cage.ID_Staff = Staff.ID_Staff WHERE ID_Cage = ?";
		return jdbcTemplate.query(sql, params, new CageRowMapper());
	}

	public void editCage(int idCage, String nameCage, int limit, int staffName) throws Exception {
		String sql = "UPDATE Cage SET Name_Cage = ?, `Limit` = ?, ID_Staff = ?"
				+ " WHERE ID_Cage = ?";
		Object[] params = new Object[] { nameCage, limit, staffName, idCage };
		int rs = jdbcTemplate.update(sql, params);
		if (rs != 1) {
			throw new Exception();
		}
	}

	public void addCage(String cageName, int limit, int staffName) throws Exception {
		String sql = "INSERT INTO Cage(Name_Cage, `Limit`, ID_Staff) "
				+ "VALUES (?, ?, ?)";
		Object[] params = new Object[] { cageName, limit, staffName };
		int rs = jdbcTemplate.update(sql, params);
		if (rs != 1) {
			throw new Exception();
		}
	}
}