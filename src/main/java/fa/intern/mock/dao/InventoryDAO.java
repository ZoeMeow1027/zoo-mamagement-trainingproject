package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Inventory;
import fa.intern.mock.bean.ProductType;

@Repository
public class InventoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProductType getProductTypeByID(int id) {
		return jdbcTemplate
				.query("SELECT * FROM Product_Type WHERE ID_Product_Type = " + id, new RowMapper<ProductType>() {
					public ProductType mapRow(ResultSet rs, int row) throws SQLException {
						ProductType e = new ProductType();
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						return e;
					}
				}).get(0);
	}

	public List<Inventory> getAllInventory() {
		return jdbcTemplate.query("select * from Inventory", new RowMapper<Inventory>() {
			public Inventory mapRow(ResultSet rs, int row) throws SQLException {
				Inventory e = new Inventory();
				e.setId(rs.getInt(1));
				e.setAddress(rs.getString(2));
				e.setName(rs.getString(3));
				e.setIdType(rs.getInt(4));
				e.setProductType(getProductTypeByID(rs.getInt(1)));
				return e;
			}
		});
	}

	public List<Inventory> getInventoryByOption(String op, String value) {
		return jdbcTemplate.query("select * from Inventory where " + op + " = '" + value + "'",
				new RowMapper<Inventory>() {
					public Inventory mapRow(ResultSet rs, int row) throws SQLException {
						Inventory e = new Inventory();
						e.setId(rs.getInt(1));
						e.setAddress(rs.getString(2));
						e.setName(rs.getString(3));
						e.setIdType(rs.getInt(4));
						e.setProductType(getProductTypeByID(rs.getInt(1)));
						return e;
					}
				});
	}

	public int deleteInventory(int id) {
		String sql = "delete from Inventory where ID_Inventory=" + id + "";
		return jdbcTemplate.update(sql);
	}

	public int updateInventory(Inventory p) {
		String sql = "update Inventory set ID_Inventory='" + p.getId() + "', Inventory_Address=" + p.getAddress()
				+ "', Inventory_Name=" + p.getName() + "', ID_Inventory_Type=" + p.getIdType() + "' where ID_Inventory="
				+ p.getId() + "";
		return jdbcTemplate.update(sql);
	}

}
