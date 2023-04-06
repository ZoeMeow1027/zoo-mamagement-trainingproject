package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Bill;
import fa.intern.mock.bean.BillDetail;
import fa.intern.mock.bean.Product;
import fa.intern.mock.bean.Supplier;

@Repository
public class BillDetailDAO {
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

	public Bill getBillByID(int id) {
		return jdbcTemplate.query("select * from Bill WHERE ID_Bill = " + id, new RowMapper<Bill>() {
			public Bill mapRow(ResultSet rs, int row) throws SQLException {
				Bill e = new Bill();
				e.setId(rs.getInt(1));
				e.setBillType(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setIdSupplier(rs.getInt(4));
				e.setSupplier(getSupplierByID(rs.getInt(4)));
				return e;
			}
		}).get(0);
	}

	public Product getProductcsByID(int id) {
		return jdbcTemplate.query("select * from Product where ID_Product = " + id + "", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product e = new Product();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAmount(rs.getInt(3));
				e.setIdSupplier(rs.getInt(4));
				e.setIdInventory(rs.getInt(5));
				e.setPrice(rs.getInt(6));
				e.setSupplier(getSupplierByID(rs.getInt(4)));
				return e;
			}
		}).get(0);
	}

	public List<BillDetail> getAllBillDetail() {
		return jdbcTemplate.query("select * from Bill_Detail", new RowMapper<BillDetail>() {
			public BillDetail mapRow(ResultSet rs, int row) throws SQLException {
				BillDetail e = new BillDetail();
				e.setId(rs.getInt(1));
				e.setIdBill(rs.getInt(2));
				e.setAmountTransfer(rs.getInt(3));
				e.setTransferDate(rs.getDate(4));
				e.setIdProduct(rs.getInt(5));
				e.setBill(getBillByID(rs.getInt(2)));
				e.setProduct(getProductcsByID(rs.getInt(5)));
				return e;
			}
		});
	}

	public List<BillDetail> getBillDetailByOption(String op, String value) {
		String query = "";
		if (op.equals("Bill_Name") || op.equals("Bill_Type"))
			query = "select * from Bill_Detail WHERE ID_Bill IN ( SELECT ID_Bill FROM Bill WHERE " + op + " = '" + value
					+ "')";
		else if (op.equals("Supplier_Name"))
			query = "select * from Bill_Detail WHERE ID_Bill IN ( SELECT ID_Bill FROM Bill WHERE ID_Supplier IN ( SELECT ID_Supplier FROM Supplier WHERE "
					+ op + " = '" + value + "'))";
		else if (op.equals("Product_Name"))
			query = "select * from Bill_Detail WHERE ID_Product IN ( SELECT ID_Product FROM Product WHERE " + op
					+ " = '" + value + "')";
		else
			query = "select * from Bill_Detail where " + op + " = '" + value + "'";

		return jdbcTemplate.query(query, new RowMapper<BillDetail>() {
			public BillDetail mapRow(ResultSet rs, int row) throws SQLException {
				BillDetail e = new BillDetail();
				e.setId(rs.getInt(1));
				e.setIdBill(rs.getInt(2));
				e.setAmountTransfer(rs.getInt(3));
				e.setTransferDate(rs.getDate(4));
				e.setIdProduct(rs.getInt(5));
				e.setBill(getBillByID(rs.getInt(2)));
				e.setProduct(getProductcsByID(rs.getInt(5)));
				return e;
			}
		});
	}

	public int deleteBillDetail(int id, int idBill) {
		String sql = "delete from Bill_Detail where ID_Bill_Detail=" + id + "";
		jdbcTemplate.update(sql);
		String sql1 = "delete from Bill where ID_Bill=" + idBill + "";
		return jdbcTemplate.update(sql1);
	}

	public int updateBillDetail(BillDetail p) {
		String sql = "update Bill_Detail set ID_Bill_Detail='" + p.getId() + "', ID_Bill=" + p.getIdBill()
				+ "', Amount_Transfer=" + p.getAmountTransfer() + "', Transfer_Date=" + p.getAmountTransfer()
				+ "' where ID_Bill_Detail=" + p.getId() + "";
		return jdbcTemplate.update(sql);
	}

	public Product saveProduct(Product p) {
		String sql = "insert into Product(Product_Name, Amount, ID_Supplier, ID_Inventory, Price) values('"
				+ p.getName() + "'," + p.getAmount() + "," + p.getIdSupplier() + "," + p.getIdInventory() + ","
				+ p.getPrice() + ")";
		jdbcTemplate.update(sql);
		return jdbcTemplate.query("SELECT * FROM Product ORDER BY ID_Product DESC LIMIT 1", new RowMapper<Product>() {
			public Product mapRow(ResultSet rs, int row) throws SQLException {
				Product e = new Product();
				e.setId(rs.getInt(1));
				return e;
			}
		}).get(0);
	}

	public Bill saveBill(Bill p) {
		String sql = "insert into Bill(Bill_Name, Bill_Type, ID_Supplier) values('" + p.getName() + "',"
				+ p.getBillType() + "," + p.getIdSupplier() + ")";
		jdbcTemplate.update(sql);
		return jdbcTemplate.query("SELECT * FROM Bill ORDER BY ID_Bill DESC LIMIT 1", new RowMapper<Bill>() {
			public Bill mapRow(ResultSet rs, int row) throws SQLException {
				Bill e = new Bill();
				e.setId(rs.getInt(1));
				return e;
			}
		}).get(0);
	}

	public int saveBillDetail(Product p, Bill b, BillDetail d) {
		Product product = saveProduct(p);
		Bill bill = saveBill(b);
		java.sql.Date sqlDate = new java.sql.Date(d.getTransferDate().getTime());
		String sql = "insert into Bill_Detail(ID_Bill,Amount_Transfer,Transfer_Date,ID_Product) values(" + bill.getId()
				+ "," + d.getAmountTransfer() + ",'" + sqlDate + "'," + product.getId() + ")";
		return jdbcTemplate.update(sql);
	}

	public int updateAmountProduct(Product p, Bill b, BillDetail d) {
		Bill bill = saveBill(b);
		java.sql.Date sqlDate = new java.sql.Date(d.getTransferDate().getTime());
		String sql = "";
		if (b.getBillType() == 0)
			sql = "update Product set Amount= (SELECT Amount FROM product WHERE ID_Product = " + p.getId() + ") + "
					+ p.getAmount() + " where ID_Product=" + p.getId() + "";
		else {
			sql = "update Product set Amount= (SELECT Amount FROM product WHERE ID_Product = " + p.getId() + ") - "
					+ p.getAmount() + " where ID_Product=" + p.getId() + "";
		}
		jdbcTemplate.update(sql);
		String sql1 = "insert into Bill_Detail(ID_Bill,Amount_Transfer,Transfer_Date,ID_Product) values(" + bill.getId()
				+ "," + d.getAmountTransfer() + ",'" + sqlDate + "'," + p.getId() + ")";
		return jdbcTemplate.update(sql1);
	}
}
