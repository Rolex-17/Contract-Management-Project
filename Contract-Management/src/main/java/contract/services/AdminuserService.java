package contract.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import contract.models.AdminUser;

@Service
public class AdminuserService {

@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveAdmin(AdminUser admin) {
		final String sql="insert into admin(userid,pwd,name) values(:userid,:pwd,:name)";
		temp.update(sql, getSqlParameterByModel(admin));
	}
	
	public long countUser() {
		return temp.queryForObject("SELECT count(*) from admin", getSqlParameterByModel(null), Long.class);
	}
	
	public AdminUser Validate(String userid,String pwd) {
		AdminUser a=new AdminUser();
		a.setUserid(userid);
		a.setPwd(pwd);
		try {
		return temp.queryForObject("SELECT * from admin WHERE userid=:userid and pwd=:pwd", 
				getSqlParameterByModel(a), new AdminMapper());
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	private SqlParameterSource getSqlParameterByModel(AdminUser a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("userid", a.getUserid());
            ps.addValue("pwd", a.getPwd());
            ps.addValue("name", a.getName());
        }
        return ps;
    }
	
	private class AdminMapper implements RowMapper<AdminUser>{

		@Override
		public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new AdminUser(rs.getString("userid"), rs.getString("pwd"),rs.getString("name"));
		}
		
	}
}
