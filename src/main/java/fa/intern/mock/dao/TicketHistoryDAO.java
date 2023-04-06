package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.Ticket;
import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.bean.TicketType;

@Repository
public class TicketHistoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertTicketHistory(TicketHistory th) {
		String query = "INSERT INTO Ticket_History (Purchase_Date, Amount, ID_Ticket, ID_Customer) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, th.getPurchase_Date(), th.getAmount(), th.getId_Ticket(), th.getId_Customer());
	}

	public List<TicketHistory> getAllTicketHistory(String searchQuery) {
		String[] queryArray = {
				"SELECT ID_Ticket_History, Purchase_Date, Amount, Ticket_Type, Age_Description, Customer_Name, Staff_Name FROM Ticket_History",
				"LEFT JOIN (",
				"SELECT ID_Ticket, Ticket_Type, Age_Description FROM Ticket",
				"LEFT JOIN Ticket_Type ON Ticket.ID_Ticket_Type = Ticket_Type.ID_Ticket_Type",
				"LEFT JOIN Ticket_Age ON Ticket.ID_Ticket_Age = Ticket_Age.ID_Ticket_Age",
				") AS c ON Ticket_History.ID_Ticket = c.ID_Ticket",
				"LEFT JOIN (SELECT ID_Customer, Customer_Name FROM Customer) AS d ON Ticket_History.ID_Customer = d.ID_Customer",
				"LEFT JOIN (SELECT ID_Staff, Staff_Name FROM Staff) AS e ON Ticket_History.ID_Staff = e.ID_Staff",
				"WHERE ID_Ticket_History LIKE '%%%s%%'",
				"OR Purchase_Date LIKE '%%%s%%'",
				"OR Amount LIKE '%%%s%%'",
				"OR Ticket_Type LIKE '%%%s%%'",
				"OR Age_Description LIKE '%%%s%%'",
				"OR Customer_Name LIKE '%%%s%%'",
				"OR Staff_Name LIKE '%%%s%%'",
				"ORDER BY Purchase_Date DESC, ID_Ticket_History ASC;"
		};
		String query = String.join(" ", queryArray);
		query = String.format(
				query,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery);
		return jdbcTemplate.query(query, new TicketHistoryMaapper());
	}

	public List<TicketHistory> getAllTicketHistoryByCustomer(String searchQuery, int idCustomer) {
		String[] queryArray = {
				"SELECT ID_Ticket_History, Purchase_Date, Amount, Ticket_Type, Age_Description, Customer_Name, Staff_Name FROM Ticket_History\r\n"
						+ "				LEFT JOIN (\r\n"
						+ "				SELECT ID_Ticket, Ticket_Type, Age_Description FROM Ticket\r\n"
						+ "				LEFT JOIN Ticket_Type ON Ticket.ID_Ticket_Type = Ticket_Type.ID_Ticket_Type\r\n"
						+ "				LEFT JOIN Ticket_Age ON Ticket.ID_Ticket_Age = Ticket_Age.ID_Ticket_Age) AS c ON Ticket_History.ID_Ticket = c.ID_Ticket\r\n"
						+ "				LEFT JOIN (SELECT ID_Customer, Customer_Name FROM Customer) AS d ON Ticket_History.ID_Customer = d.ID_Customer\r\n"
						+ "				LEFT JOIN (SELECT ID_Staff, Staff_Name FROM Staff) AS e ON Ticket_History.ID_Staff = e.ID_Staff\r\n"
						+ "				WHERE Ticket_History.ID_Customer = '" + idCustomer
						+ "' AND ID_Ticket_History LIKE '%%%s%%'\r\n"
						+ "				OR Purchase_Date LIKE '%%%s%%'\r\n"
						+ "				OR Amount LIKE '%%%s%%'\r\n"
						+ "				OR Ticket_Type LIKE '%%%s%%'\r\n"
						+ "				OR Age_Description LIKE '%%%s%%'\r\n"
						+ "				OR Customer_Name LIKE '%%%s%%'\r\n"
						+ "				OR Staff_Name LIKE '%%%s%%'\r\n"
						+ "				ORDER BY Purchase_Date DESC, ID_Ticket_History ASC;"
		};
		String query = String.join(" ", queryArray);
		query = String.format(
				query,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery);
		return jdbcTemplate.query(query, new TicketHistoryMaapper());
	}

	public List<TicketHistory> getAllTicketHistoryByCustomerPage(String searchQuery, int idCustomer, int pageid,
			int total) {
		String[] queryArray = {
				"SELECT ID_Ticket_History, Purchase_Date, Amount, Ticket_Type, Age_Description, Customer_Name, Staff_Name FROM Ticket_History\r\n"
						+ "				LEFT JOIN (\r\n"
						+ "				SELECT ID_Ticket, Ticket_Type, Age_Description FROM Ticket\r\n"
						+ "				LEFT JOIN Ticket_Type ON Ticket.ID_Ticket_Type = Ticket_Type.ID_Ticket_Type\r\n"
						+ "				LEFT JOIN Ticket_Age ON Ticket.ID_Ticket_Age = Ticket_Age.ID_Ticket_Age) AS c ON Ticket_History.ID_Ticket = c.ID_Ticket\r\n"
						+ "				LEFT JOIN (SELECT ID_Customer, Customer_Name FROM Customer) AS d ON Ticket_History.ID_Customer = d.ID_Customer\r\n"
						+ "				LEFT JOIN (SELECT ID_Staff, Staff_Name FROM Staff) AS e ON Ticket_History.ID_Staff = e.ID_Staff\r\n"
						+ "				WHERE Ticket_History.ID_Customer = '" + idCustomer
						+ "' AND ID_Ticket_History LIKE '%%%s%%'\r\n"
						+ "				OR Purchase_Date LIKE '%%%s%%'\r\n"
						+ "				OR Amount LIKE '%%%s%%'\r\n"
						+ "				OR Ticket_Type LIKE '%%%s%%'\r\n"
						+ "				OR Age_Description LIKE '%%%s%%'\r\n"
						+ "				OR Customer_Name LIKE '%%%s%%'\r\n"
						+ "				OR Staff_Name LIKE '%%%s%%'\r\n"
						+ "				ORDER BY Purchase_Date DESC, ID_Ticket_History ASC\r\n"
						+ "                LIMIT " + (pageid - 1) + "," + total + ";"
		};
		String query = String.join(" ", queryArray);
		query = String.format(
				query,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery);
		return jdbcTemplate.query(query, new TicketHistoryMaapper());
	}

	public class TicketHistoryMaapper implements RowMapper<TicketHistory> {
		public TicketHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
			TicketHistory tH = new TicketHistory();
			tH.setId_Ticket_History(rs.getInt("ID_Ticket_History"));
			tH.setPurchase_Date(
					Instant.ofEpochMilli(rs.getDate("Purchase_Date").getTime()).atOffset(ZoneOffset.UTC).toLocalDate());
			tH.setAmount(rs.getInt("Amount"));

			TicketAge tA = new TicketAge();
			tA.setAge_Description(rs.getString("Age_Description"));

			TicketType tT = new TicketType();
			tT.setTicket_Type(rs.getString("Ticket_Type"));

			Ticket t = new Ticket();
			t.setTicket_Type(tT);
			t.setTicket_Age(tA);

			tH.setTicket(t);

			Customer c = new Customer();
			c.setCustomer_Name(rs.getString("Customer_Name"));
			tH.setCustomer(c);

			Staff s = new Staff();
			s.setStaffName(rs.getString("Staff_Name"));
			tH.setStaff(s);

			return tH;
		}
	}
}