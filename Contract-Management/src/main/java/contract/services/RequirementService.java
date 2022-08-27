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

import contract.models.Requirement;

@Service
public class RequirementService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveReq(Requirement req) {
		final String sql="insert into requirement(reqid,reqtype,description,deldate) "
				+ "values(:reqid,:reqtype,:description,:deldate)";
		temp.update(sql, getSqlParameterByModel(req));
	}
	
	public List<Requirement> allreq(){
		return temp.query("SELECT * from requirement", getSqlParameterByModel(null), new RequirementMapper());
	}
	
	public Requirement findReq(String id) {
		Requirement s=new Requirement();
		s.setReqid(id);
		return temp.queryForObject("SELECT * FROM supplier WHERE supid=:supid", 
				getSqlParameterByModel(s),new RequirementMapper());
	}
	
	public long countRequirement() {
		return temp.queryForObject("SELECT count(*) from requirement", getSqlParameterByModel(null), Long.class);
	}
	
	public String generateId() {
		return "req"+(countRequirement()+1);
	}
	
	private SqlParameterSource getSqlParameterByModel(Requirement a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("reqid", a.getReqid());
            ps.addValue("reqtype", a.getReqtype());
            ps.addValue("description", a.getDescription());
            ps.addValue("deldate", a.getDeldate());
        }
        return ps;
    }
	
	private class RequirementMapper implements RowMapper<Requirement>{

		@Override
		public Requirement mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Requirement req=new Requirement();
			req.setReqid(rs.getString("reqid"));
			req.setReqtype(rs.getString("reqtype"));
			req.setDescription(rs.getString("description"));
			req.setDeldate(rs.getString("deldate"));
			return req;
		}
		
	}
}
