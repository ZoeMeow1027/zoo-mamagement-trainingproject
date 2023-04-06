package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Bill;
import fa.intern.mock.bean.Supplier;

@Repository
public class BillDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Supplier getSupplierByID(int id) {
		return jdbcTemplate.query("SELECT * FROM Supplier WHERE ID_Supplier = " + id, new RowMapper<Supplier>() {
			public Supplier mapRow(ResultSet rs, int row) throws SQLException {
				Supplier e = new Supplier();
				e.setId(rs.getInt(1));
				e.setIdContract(rs.getInt(2));
				e.setIdSupplierType(rs.getInt(3));
				e.setName(rs.getString(4));
				return e;
			}
		}).get(0);
	}

	public List<Bill> getAllBill() {
		return jdbcTemplate.query("select * from Bill", new RowMapper<Bill>() {
			public Bill mapRow(ResultSet rs, int row) throws SQLException {
				Bill e = new Bill();
				e.setId(rs.getInt(1));
				e.setBillType(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setIdSupplier(rs.getInt(4));
				e.setSupplier(getSupplierByID(rs.getInt(4)));
				return e;
			}
		});
	}

	public int deleteBill(int id) {
		String sql = "delete from Bill where ID_Bill=" + id + "";
		return jdbcTemplate.update(sql);
	}

	public int updateBill(Bill p) {
		String sql = "update Bill set ID_Bill='" + p.getId() + "', Bill_Type=" + p.getBillType() + "', Bill_Name="
				+ p.getName() + "', ID_Supplier=" + p.getIdSupplier() + "' where ID_Bill=" + p.getId() + "";
		return jdbcTemplate.update(sql);
	}
}
