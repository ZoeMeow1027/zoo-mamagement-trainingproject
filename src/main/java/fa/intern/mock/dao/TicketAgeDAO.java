package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.TicketAge;

@Repository
public class TicketAgeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TicketAge> getAllTicketAge(String searchQuery) {
        try {
            String[] queryArray = {
                    "SELECT * FROM Ticket_Age",
                    "WHERE ID_Ticket_Age LIKE N'%%%s%%' OR Age_Description LIKE N'%%%s%%'",
                    ";"
            };
            String query = String.join(" ", queryArray);
            query = String.format(
                    query,
                    searchQuery == null ? "" : searchQuery,
                    searchQuery == null ? "" : searchQuery);
            return jdbcTemplate.query(query, new TicketAgeMapper());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public TicketAge getTicketAgeById(String ticketAgeId) {
        try {
            String[] queryArray = {
                    "SELECT * FROM Ticket_Age",
                    "WHERE ID_Ticket_Age = %s",
                    ";"
            };
            String query = String.join(" ", queryArray);
            query = String.format(
                    query,
                    ticketAgeId);
            List<TicketAge> data = jdbcTemplate.query(query, new TicketAgeMapper());
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

    public boolean addTicketAge(TicketAge ticket) {
        if (ticket == null)
            return false;

        try {
            String[] queryArray = {
                    "INSERT INTO Ticket_Age(Age_Description)",
                    "VALUES (N'%s')",
                    ";"
            };

            String query = String.join(" ", queryArray);
            query = String.format(query, ticket.getAge_Description());
            return jdbcTemplate.update(query) == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editTicketAge(TicketAge ticket) {
        if (ticket == null)
            return false;

        try {
            String[] queryArray = {
                    "UPDATE Ticket_Age",
                    "SET Age_Description = N'%s'",
                    "WHERE ID_Ticket_Age = %d",
                    ";"
            };

            String query = String.join(" ", queryArray);
            query = String.format(query, ticket.getAge_Description(), ticket.getId_Ticket_Age());
            return jdbcTemplate.update(query) == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteTicketAgeById(String ticketAgeId) {
        if (ticketAgeId == null)
            return false;

        try {
            String[] queryArray = {
                    "DELETE FROM Ticket_Age",
                    "WHERE ID_Ticket_Age = %s",
                    ";"
            };

            String query = String.join(" ", queryArray);
            query = String.format(query, ticketAgeId);
            return jdbcTemplate.update(query) == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public class TicketAgeMapper implements RowMapper<TicketAge> {
        public TicketAge mapRow(ResultSet rs, int rowNum) throws SQLException {
            TicketAge t = new TicketAge();

            t.setId_Ticket_Age(rs.getInt("ID_Ticket_Age"));
            t.setAge_Description(rs.getString("Age_Description"));

            return t;
        }
    }
}
