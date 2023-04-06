package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.TicketType;

@Repository
public class TicketTypeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TicketType> getAllTicketType(String searchQuery) {
		String[] queryArray = {
				"SELECT * FROM Ticket_Type",
				"WHERE ID_Ticket_Type LIKE '%%%s%%'",
				"OR Ticket_Type LIKE '%%%s%%'",
				"OR Ticket_Description LIKE '%%%s%%'",
				"ORDER BY ID_Ticket_Type ASC",
				";"
		};
		String query = String.join(" ", queryArray);
		query = String.format(
				query,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery,
				searchQuery == null ? "" : searchQuery);
		return jdbcTemplate.query(query, new TicketTypeMapper());
	}

	public TicketType getTicketTypeById(String ticketTypeId) {
		try {
			String[] queryArray = {
					"SELECT * FROM Ticket_Type",
					"WHERE ID_Ticket_Type = %s",
					";"
			};
			String query = String.join(" ", queryArray);
			query = String.format(
					query,
					ticketTypeId);
			List<TicketType> data = jdbcTemplate.query(query, new TicketTypeMapper());
			if (data.size() == 1) {
				return data.get(0);
			} else {
				throw new Exception();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addTicketType(TicketType ticketType) {
		if (ticketType == null)
			return false;

		try {
			String[] queryArray = {
					"INSERT INTO Ticket_Type(Ticket_Type, Ticket_Description)",
					"VALUES (N'%s', N'%s')",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticketType.getTicket_Type(), ticketType.getTicket_Description());
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean editTicketType(TicketType ticketType) {
		if (ticketType == null)
			return false;

		try {
			String[] queryArray = {
					"UPDATE Ticket_Type",
					"SET Ticket_Type = N'%s', Ticket_Description = N'%s'",
					"WHERE ID_Ticket_Type = %d",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticketType.getTicket_Type(), ticketType.getTicket_Description(),
					ticketType.getId_Ticket_Type());
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteTicketById(String ticketTypeId) {
		if (ticketTypeId == null)
			return false;

		try {
			String[] queryArray = {
					"DELETE FROM Ticket_Type",
					"WHERE ID_Ticket_Type = %s",
					";"
			};

			String query = String.join(" ", queryArray);
			query = String.format(query, ticketTypeId);
			return jdbcTemplate.update(query) == 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public class TicketTypeMapper implements RowMapper<TicketType> {
		public TicketType mapRow(ResultSet rs, int rowNum) throws SQLException {
			TicketType tt = new TicketType();
			tt.setId_Ticket_Type(rs.getInt("ID_Ticket_Type"));
			tt.setTicket_Type(rs.getNString("Ticket_Type"));
			tt.setTicket_Description(rs.getNString("Ticket_Description"));
			return tt;
		}
	}
}
