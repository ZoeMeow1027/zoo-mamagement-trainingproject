package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.StaffType;

@Repository
public class StaffDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private class StaffRowMapper implements RowMapper<Staff> {
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Staff staff = new Staff();
            staff.setIdStaff(rs.getInt("ID_Staff"));
            staff.setStaffName(rs.getString("Staff_Name"));
            return staff;
        }
    }

    public List<Staff> showStaff() {
        String sql = "SELECT * FROM Staff";
        return jdbcTemplate.query(sql, new StaffRowMapper());
    }

    public List<Staff> getStaffList() {
        String sql = "SELECT * FROM Staff";
        List<Staff> staffList = jdbcTemplate.query(sql, new RowMapper<Staff>() {

            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff staff = new Staff();

                staff.setIdStaff(rs.getInt("ID_Staff"));
                staff.setStaffName(rs.getString("Staff_Name"));
                staff.setSalary(rs.getInt("Salary"));
                staff.setIdContract(rs.getInt("ID_Contract"));
                staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
                staff.setUsername(rs.getString("Username"));

                System.out.println(staff.getIdStaff() + "-" + staff.getStaffName() + "-" + staff.getIdContract() + "-"
                        + staff.getIdStaffType() + "-" + staff.getSalary() + "-" + staff.getUsername());
                return staff;

            }
        });
        return staffList;
    }

    public List<StaffType> getStaffTypeList() {
        String sql = "SELECT * FROM Staff_Type";
        List<StaffType> staffTypeList = jdbcTemplate.query(sql, new RowMapper<StaffType>() {

            public StaffType mapRow(ResultSet rs, int rowNum) throws SQLException {
                StaffType staffType = new StaffType();

                staffType.setIdStaffType(rs.getInt("ID_Staff_Type"));
                staffType.setStaffType(rs.getString("Staff_Type"));
                staffType.setDetails(rs.getString("Details"));

                // System.out.println(staffType.getIdStaffType()+"-"+staffType.getStaffType()+"-"+staffType.getDetails());
                return staffType;

            }
        });
        return staffTypeList;
    }

    // public Staff getStaffById(int id) {
    // String sql = "SELECT * FROM staff WHERE ID_STAFF = "+id;
    // Staff staff = (Staff) jdbcTemplate.query(sql, new RowMapper<Staff>() {
    // public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
    // Staff staff = new Staff();
    //
    // staff.setIdStaff(rs.getInt("ID_Staff"));
    // staff.setStaffName(rs.getString("Staff_Name"));
    // staff.setSalary(rs.getInt("Salary"));
    // staff.setIdContract(rs.getInt("ID_Contract"));
    // staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
    // staff.setUsername(rs.getString("Username"));
    //
    // System.out.println("upddeate"+staff.getIdStaff()+"-"+staff.getStaffName()+"-"+staff.getIdContract()+"-"+staff.getIdStaffType()+"-"+staff.getSalary()+"-"+staff.getUsername());
    // return staff;
    // }
    // });
    // return staff;
    // }

    public List<Staff> getStaffById(int id) {
        String sql = "SELECT * FROM Staff WHERE ID_STAFF = " + id;
        List<Staff> staffList = jdbcTemplate.query(sql, new RowMapper<Staff>() {

            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff staff = new Staff();

                staff.setIdStaff(rs.getInt("ID_Staff"));
                staff.setStaffName(rs.getString("Staff_Name"));
                staff.setSalary(rs.getInt("Salary"));
                staff.setIdContract(rs.getInt("ID_Contract"));
                staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
                staff.setUsername(rs.getString("Username"));

                System.out.println(
                        "updateee: " + staff.getIdStaff() + "-" + staff.getStaffName() + "-" + staff.getIdContract()
                                + "-" + staff.getIdStaffType() + "-" + staff.getSalary() + "-" + staff.getUsername());
                return staff;

            }
        });
        return staffList;
    }

    public List<Staff> getStaffSearch(String searchString) {
        String sql = "SELECT * FROM Staff WHERE Staff_Name LIKE '%" + searchString + "%' or Username LIKE '%"
                + searchString + "%'";
        List<Staff> staffList = jdbcTemplate.query(sql, new RowMapper<Staff>() {

            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff staff = new Staff();

                staff.setIdStaff(rs.getInt("ID_Staff"));
                staff.setStaffName(rs.getString("Staff_Name"));
                staff.setSalary(rs.getInt("Salary"));
                staff.setIdContract(rs.getInt("ID_Contract"));
                staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
                staff.setUsername(rs.getString("Username"));

                System.out.println(
                        "updateee: " + staff.getIdStaff() + "-" + staff.getStaffName() + "-" + staff.getIdContract()
                                + "-" + staff.getIdStaffType() + "-" + staff.getSalary() + "-" + staff.getUsername());
                return staff;

            }
        });
        return staffList;
    }

    public void createStaff(Staff staff) {
        String sql = "INSERT INTO Staff (Staff_Name, Salary, ID_Contract, ID_Staff_Type, Username) VALUES ('"
                + staff.getStaffName() + "', " + staff.getSalary() + "," + staff.getIdContract() + " , "
                + staff.getIdStaffType() + ", '" + staff.getUsername() + "')";
        jdbcTemplate.update(sql);
    }

    public List<Staff> getStaffByIdStaffType(int id) {
        String sql = "SELECT * FROM Staff WHERE ID_Staff_Type = " + id;
        List<Staff> staffList = jdbcTemplate.query(sql, new RowMapper<Staff>() {

            public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
                Staff staff = new Staff();

                staff.setIdStaff(rs.getInt("ID_Staff"));
                staff.setStaffName(rs.getString("Staff_Name"));
                staff.setSalary(rs.getInt("Salary"));
                staff.setIdContract(rs.getInt("ID_Contract"));
                staff.setIdStaffType(rs.getInt("ID_Staff_Type"));
                staff.setUsername(rs.getString("Username"));

                System.out.println(
                        "updateee: " + staff.getIdStaff() + "-" + staff.getStaffName() + "-" + staff.getIdContract()
                                + "-" + staff.getIdStaffType() + "-" + staff.getSalary() + "-" + staff.getUsername());
                return staff;

            }
        });
        return staffList;
    }

    // ----------------------------update---------------------------
    public void updateStaff(Staff staff) {
        String sql = "UPDATE Staff SET Staff_Name = '" + staff.getStaffName() + "', Salary=" + staff.getSalary()
                + ", ID_Staff_Type = " + staff.getIdStaffType() + " WHERE ID_Staff = " + staff.getIdStaff();
        jdbcTemplate.update(sql);
    }

    public void deleteStaff(int id) {
        String sql = "DELETE FROM Staff WHERE ID_Staff = " + id;
        jdbcTemplate.update(sql);
    }
}
