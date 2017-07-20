package won.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import won.reservation.domain.Users;

@Repository
public class UsersDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Users> rowMapper = BeanPropertyRowMapper.newInstance(Users.class);
	
	public UsersDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("users")
				.usingGeneratedKeyColumns("id");
	}
	
	public Users select(String snsId, String snsType) {
		Map<String, Object> params = new HashMap<>();
		params.put("snsid", snsId);
		params.put("snstype", snsType);
		try {
			 return jdbc.queryForObject(UsersSqls.SELECT_BY_SNS_ID, params, rowMapper);
		}catch(Exception e) {
			
		}
		return null;
	}
	
	public int insert(Users user) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).intValue();
	}
}
