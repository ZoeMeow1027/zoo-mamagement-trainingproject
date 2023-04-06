package fa.intern.mock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.bean.Supplier;
import fa.intern.mock.bean.SupplierType;


@Repository
public class SupplierDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<SupplierType> getAllSupplierType(){    
	    return jdbcTemplate.query("select * from Supplier_Type",new RowMapper<SupplierType>(){    
	        public SupplierType mapRow(ResultSet rs, int row) throws SQLException {    
	        	SupplierType e=new SupplierType();    
	            e.setId(rs.getInt(1)); 
	            e.setSupplierType(rs.getString(2));
	            return e;    
	        }    
	    });    
	}
	
	public SupplierType getSupplierTypeByName(String name){    
	    return jdbcTemplate.query("select * from Supplier_Type WHERE Supplier_Type = '" + name + "'",new RowMapper<SupplierType>(){    
	        public SupplierType mapRow(ResultSet rs, int row) throws SQLException {    
	        	SupplierType e=new SupplierType();    
	            e.setId(rs.getInt(1)); 
	            e.setSupplierType(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);    
	}
	
	public Contracts getContractsByID(int id){    
	    return jdbcTemplate.query("select * from Contracts WHERE ID_Contract = " + id,new RowMapper<Contracts>(){    
	        public Contracts mapRow(ResultSet rs, int row) throws SQLException {    
	        	Contracts e=new Contracts();    
	            e.setId(rs.getInt(1)); 
	            e.setDetails(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);    
	} 
	
	public SupplierType getSupplierTypeByID(int id){    
	    return jdbcTemplate.query("select * from Supplier_Type WHERE ID_Supplier_Type = " + id,new RowMapper<SupplierType>(){    
	        public SupplierType mapRow(ResultSet rs, int row) throws SQLException {    
	        	SupplierType e=new SupplierType();    
	            e.setId(rs.getInt(1)); 
	            e.setSupplierType(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);    
	} 
	
	public List<Supplier> getAllSupplier(){    
	    return jdbcTemplate.query("select * from Supplier",new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e=new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    });    
	} 
	
	public List<Supplier> getSupplierByOption(String op, String value) {    
	    return jdbcTemplate.query("select * from supplier where " + op + " = '" + value + "'",new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e=new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    });    
	} 
	
	public List<Supplier> getSupplierByOptionID(String op, int id) {    
	    return jdbcTemplate.query("select * from supplier where " + op + " = " + id + "",new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e=new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    });    
	} 
	
	public Supplier getSupplierByID(int id){    
	    return jdbcTemplate.query("SELECT * FROM supplier WHERE ID_Supplier = " + id,new RowMapper<Supplier>(){    
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {    
	        	Supplier e = new Supplier();    
	            e.setId(rs.getInt(1)); 
	            e.setIdContract(rs.getInt(2));
	            e.setIdSupplierType(rs.getInt(3));
	            e.setName(rs.getString(4));
	            e.setContracts(getContractsByID(rs.getInt(2)));
	            e.setSupplierType(getSupplierTypeByID(rs.getInt(3)));
	            return e;    
	        }    
	    }).get(0);    
		}
	
	public void deleteSupplier(int id){    
		Supplier s = getSupplierByID(id);
	    String sql="delete from supplier where ID_Supplier="+id+"";    
	    jdbcTemplate.update(sql);    	    
	    String sql1="delete from contracts where ID_Contract="+s.getIdContract()+"";    
	    jdbcTemplate.update(sql1);   
	} 
	
	public void updateSupplier(Supplier p, Contracts c){   
		String sql="update contracts set Details='"+c.getDetails()+"' where ID_Contract="+c.getId()+"";       
	    jdbcTemplate.update(sql);
	    String sql1="update supplier set ID_Supplier_Type="+p.getIdSupplierType()+", Supplier_Name='"+p.getName()+"' where ID_Supplier="+p.getId()+"";    
	    jdbcTemplate.update(sql1);    
	} 
	
	public Contracts saveContracts(Contracts p){    
	    String sql="insert into contracts(Details) values('"+p.getDetails()+"')";    
	    jdbcTemplate.update(sql);    
	    return jdbcTemplate.query("SELECT * FROM contracts ORDER BY ID_Contract DESC LIMIT 1",new RowMapper<Contracts>(){    
	        public Contracts mapRow(ResultSet rs, int row) throws SQLException {    
	        	Contracts e=new Contracts();    
	            e.setId(rs.getInt(1)); 
	            e.setDetails(rs.getString(2));
	            return e;    
	        }    
	    }).get(0);
	} 
	
	public int saveSupplier(Supplier p, Contracts c){   
		Contracts contracts = saveContracts(c);
	    String sql="insert into supplier(ID_Contract,ID_Supplier_Type,Supplier_Name) values("+contracts.getId()+","+p.getIdSupplierType()+",'"+p.getName()+"')";    
	    return jdbcTemplate.update(sql);    
	}   
}
