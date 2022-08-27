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

import contract.models.Contract;

@Service
public class ContractService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	//save contract
	public void saveContract(Contract c) {
		temp.update("insert into contract(id,ctype,duration,supid,supname,delivery,terms) "
				+ "values(:id,:ctype,:duration,:supid,:supname,:delivery,:terms)", getSqlParameterByModel(c));
	}
	//list all contact
	public List<Contract> allcontracts(){
		return temp.query("SELECT * from contract", getSqlParameterByModel(null), new ContractMapper());
	}
	//list all suplier contract
	public List<Contract> supcontracts(String supid){
		Contract p=new Contract();
		p.setSupid(supid);
		return temp.query("SELECT * from contract where supid=:supid", getSqlParameterByModel(p), new ContractMapper());
	}
	//contract details
	public Contract findContract(int id) {
		Contract p=new Contract();
		p.setId(id);
		return temp.queryForObject("SELECT * from contract where id=:id", 
				getSqlParameterByModel(p), new ContractMapper());
	}
	//count contract
	public long countContract() {
		return temp.queryForObject("SELECT count(*) from contract", getSqlParameterByModel(null), Long.class);
	}
	//generate contract id
	public long generateId() {
		return countContract()+1;
	}
	
	//update status
	public void updateStatus(int id,String status) {
		Contract p=new Contract();
		p.setId(id);
		p.setStatus(status);
		temp.update("update contract SET status=:status WHERE id=:id", getSqlParameterByModel(p));
	}
	
	//update contract
	public void updateContract(Contract c) {
		temp.update("update contract SET terms=:terms,duration=:duration,status=:status WHERE id=:id", getSqlParameterByModel(c));
	}
	
	//update delivery progress
	public void updateDelivery(int id,String progress) {
		Contract p=new Contract();
		p.setId(id);
		p.setDelivery(progress);
		temp.update("update contract SET delivery=:delivery WHERE id=:id", getSqlParameterByModel(p));
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Contract a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("id", a.getId());
            ps.addValue("ctype", a.getCtype());
            ps.addValue("duration", a.getDuration());
            ps.addValue("supid", a.getSupid());
            ps.addValue("supname", a.getSupname());
            ps.addValue("status", a.getStatus());
            ps.addValue("terms", a.getTerms());
            ps.addValue("delivery", a.getDelivery());
        }
        return ps;
    }
	
	private class ContractMapper implements RowMapper<Contract>{

		@Override
		public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Contract req=new Contract();
			req.setId(rs.getInt("id"));
			req.setCtype(rs.getString("ctype"));
			req.setDuration(rs.getString("duration"));
			req.setSupid(rs.getString("supid"));
			req.setSupname(rs.getString("supname"));
			req.setStatus(rs.getString("status"));
			req.setTerms(rs.getString("terms"));
			req.setDelivery(rs.getString("delivery"));
			return req;
		}
		
	}
}
