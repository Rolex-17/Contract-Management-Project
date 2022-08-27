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

import contract.models.Proposal;

@Service
public class ProposalService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	public void saveProp(Proposal p) {
		temp.update("insert into proposal(propid,supid,supname,pdate,reqid,quotation) "
				+ "values(:propid,:supid,:supname,:pdate,:reqid,:quotation)", getSqlParameterByModel(p));
	}
	
	public List<Proposal> allpropsals(){
		return temp.query("SELECT * from proposal", getSqlParameterByModel(null), new ProposalMapper());
	}
	
	public List<Proposal> suppropsals(String supid){
		Proposal p=new Proposal();
		p.setSupid(supid);
		return temp.query("SELECT * from proposal where supid=:supid", getSqlParameterByModel(p), new ProposalMapper());
	}
	
	public Proposal findProposal(int id) {
		Proposal p=new Proposal();
		p.setPropid(id);
		return temp.queryForObject("SELECT * from proposal where propid=:propid", getSqlParameterByModel(p), new ProposalMapper());
	}
	
	public long countProposal() {
		return temp.queryForObject("SELECT count(*) from proposal", getSqlParameterByModel(null), Long.class);
	}
	
	public long generateId() {
		return countProposal()+1;
	}
	
	public void updateStatus(int propid,String status) {
		Proposal p=new Proposal();
		p.setPropid(propid);
		p.setStatus(status);
		temp.update("update proposal SET status=:status WHERE propid=:propid", getSqlParameterByModel(p));
	}
	
	private SqlParameterSource getSqlParameterByModel(Proposal a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("propid", a.getPropid());
            ps.addValue("pdate", a.getPdate());
            ps.addValue("quotation", a.getQuotation());
            ps.addValue("reqid", a.getReqid());
            ps.addValue("status", a.getStatus());
            ps.addValue("supid", a.getSupid());
            ps.addValue("supname", a.getSupname());
        }
        return ps;
    }
	
	private class ProposalMapper implements RowMapper<Proposal>{

		@Override
		public Proposal mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Proposal p=new Proposal();
			p.setPdate(rs.getString("pdate"));
			p.setPropid(rs.getInt("propid"));
			p.setQuotation(rs.getInt("quotation"));
			p.setReqid(rs.getString("reqid"));
			p.setStatus(rs.getString("status"));
			p.setSupid(rs.getString("supid"));
			p.setSupname(rs.getString("supname"));
			return p;
		}
		
	}
}
