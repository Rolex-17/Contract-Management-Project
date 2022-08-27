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

import contract.models.Amenities;

@Service
public class AmenityService {

	@Autowired NamedParameterJdbcTemplate temp;
	
	//add aminity
	public void saveAmenity(Amenities c) {
		temp.update("insert into amenity(id,atype,aminity,cid) "
				+ "values(:id,:atype,:aminity,:cid)", getSqlParameterByModel(c));
	}
	//list aminity by contractid
	public List<Amenities> contractamenities(int cid){
		Amenities p=new Amenities();
		p.setCid(cid);
		return temp.query("SELECT * from amenity where cid=:cid", getSqlParameterByModel(p), new AmenitiesMapper());
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Amenities a) {
        MapSqlParameterSource ps = new MapSqlParameterSource();
        if (a != null) {
            ps.addValue("id", a.getId());
            ps.addValue("atype", a.getAtype());
            ps.addValue("aminity", a.getAminity());
            ps.addValue("cid", a.getCid());
        }
        return ps;
    }
	
	private class AmenitiesMapper implements RowMapper<Amenities>{

		@Override
		public Amenities mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Amenities req=new Amenities();
			req.setId(rs.getInt("id"));
			req.setAtype(rs.getString("atype"));
			req.setAminity(rs.getString("aminity"));
			req.setCid(rs.getInt("cid"));
			return req;
		}
		
	}
}
