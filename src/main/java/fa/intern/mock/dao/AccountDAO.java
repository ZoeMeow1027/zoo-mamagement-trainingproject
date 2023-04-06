package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Account;

@Repository
public class AccountDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Account getAccount(String username) throws SQLException, IndexOutOfBoundsException{
		String query = "SELECT * FROM Account WHERE Username = '" + username + "'";
		return jdbcTemplate.query(query, new AccountMapper()).get(0);
	}

	public void createAccountThroughAddNewStaff(String string) {
		String sql = "insert into Account (Username, Pass, ID_Account_Type) VALUE ('" + string + "', '" + string
				+ "', 2)";
		jdbcTemplate.update(sql);
	}

	public void insertAccount(Account a) {
		String query = "INSERT INTO Account VALUES (?,?,?)";
		jdbcTemplate.update(query, a.getUsername(), a.getPassword(), a.getId_Account_Type());
	}

	public class AccountMapper implements RowMapper<Account> {
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account a = new Account();
			a.setUsername(rs.getString("Username"));
			a.setPassword(rs.getString("Pass"));
			a.setId_Account_Type(rs.getInt("ID_Account_Type"));

			return a;
		}
	}
}
