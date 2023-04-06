package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Customer;

@Repository
public class CustomerDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Customer> getAllCustomer() {
		String query = "SELECT * FROM Customer";
		return jdbcTemplate.query(query, new CustomerMapper());
	}

	public void insertCustomerByUsername(Customer c) {
		String query = "INSERT INTO Customer (Customer_Name, Address, Email, Phone, Username) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(query, c.getCustomer_Name(), c.getAddress(), c.getEmail(), c.getPhone(), c.getUsername());
	}

	public void insertCustomer(Customer c) {
		String query = "INSERT INTO Customer (Customer_Name, Address, Email, Phone) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, c.getCustomer_Name(), c.getAddress(), c.getEmail(), c.getPhone());
	}

	public Customer getIDCustomer(String email, String phone) {
		String query = "SELECT * FROM Customer WHERE Email = '" + email + "' and Phone = '" + phone + "'";
		return jdbcTemplate.query(query, new CustomerMapper()).get(0);
	}

	public Customer getCustomerByUsername(String username) throws SQLException, IndexOutOfBoundsException {
		String query = "SELECT * FROM Customer WHERE Username = '" + username + "'";
		return jdbcTemplate.query(query, new CustomerMapper()).get(0);
	}

	public void updateCustomerByUsername(Customer c) {
		String query = "UPDATE Customer SET Customer_Name = ?, Address = ?, Email = ?, Phone = ? WHERE Username = ?";
		jdbcTemplate.update(query, c.getCustomer_Name(), c.getAddress(), c.getEmail(), c.getPhone(), c.getUsername());
	}

	public class CustomerMapper implements RowMapper<Customer> {

		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer c = new Customer();
			c.setId_Customer(rs.getInt("ID_Customer"));
			c.setCustomer_Name(rs.getNString("Customer_Name"));
			c.setAddress(rs.getNString("Address"));
			c.setPhone(rs.getString("Phone"));
			c.setEmail(rs.getString("Email"));
			return c;
		}

	}
}
