package contract.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import contract.models.Supplier;

@Service
public class SupplierService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveSupplier(Supplier sup) {
		final String sql="insert into supplier(supid,name,address,phone,pwd) "
				+ "values(:supid,:name,:address,:phone,:pwd)";
		temp.update(sql, getSqlParameterByModel(sup));
	}
	
	public List<Supplier> allsuppliers(){
		return temp.query("SELECT * from supplier", getSqlParameterByModel(null), new SupplierMapper());
	}
	
	public Supplier findSupplierById(String supid) {
		Supplier s=new Supplier();
		s.setSupid(supid);		
		return temp.queryForObject("SELECT * FROM supplier WHERE supid=:supid", 
				getSqlParameterByModel(s),new SupplierMapper());
	}
	
	public long countSuppliers() {
		return temp.queryForObject("SELECT count(*) from supplier", getSqlParameterByModel(null), Long.class);
	}
	
	public String generateId() {
		return "supplier"+(countSuppliers()+1);
	}
	
	public Supplier Validate(String userid,String pwd) {
		Supplier sup=new Supplier();
		sup.setPwd(pwd);
		sup.setSupid(userid);
		try {
		return temp.queryForObject("SELECT * from supplier WHERE supid=:supid and pwd=:pwd", 
				getSqlParameterByModel(sup), new SupplierMapper());
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	private SqlParameterSource getSqlParameterByModel(Supplier a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("supid", a.getSupid());
            ps.addValue("pwd", a.getPwd());
            ps.addValue("name", a.getName());
            ps.addValue("phone", a.getPhone());
            ps.addValue("address", a.getAddress());
        }
        return ps;
    }
	
	private class SupplierMapper implements RowMapper<Supplier>{

		@Override
		public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Supplier sup=new Supplier();
			sup.setAddress(rs.getString("address"));
			sup.setSupid(rs.getString("supid"));
			sup.setName(rs.getString("name"));
			sup.setPhone(rs.getString("phone"));
			sup.setPwd(rs.getString("pwd"));
			return sup;
		}
		
	}
}
