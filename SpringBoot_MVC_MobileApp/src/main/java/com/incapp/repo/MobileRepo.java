package com.incapp.repo;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.incapp.dao.Mobile;

@Repository
public class MobileRepo {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// addMobile with Image

	public String addMobile(Mobile m, InputStream image1) {

		try {
			String query = "insert into mobile values (?,?,?)";
			int x = jdbcTemplate.update(query, new Object[] { m.getName(), m.getPrice(), image1 });

			if (x == 0) {
				return "Failed";
			} else {
				return "Success";
			}
           
		} catch (Exception e) {
			return "Exception";
		}
	}

	// deleteMobileByName

	public String deleteMobile(String name) {

		try {
			String query = "delete from mobile where name=?";
			int x = jdbcTemplate.update(query, new Object[] {name});

			if (x == 0) {
				return "Failed";
			} else {
				return "Success";
			}

		} catch (Exception e) {
			return "Exception";
		}
	}

	// getMobile...

	public List<Mobile> getallMobile() {

		class DataMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Mobile m = new Mobile();

				m.setName(rs.getString("name"));
				m.setPrice(rs.getInt("price"));

				return m;
			}
		}

		try {
			String query = "select * from mobile";
			List<Mobile> data = jdbcTemplate.query(query, new DataMapper());
			return data;

		} catch (Exception e) {
			return null;
		}
	}

	// getImage

	public byte[] getImage1(String name) {

		class DataMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
return rs.getBytes("image1");
				
			}
		}

		try {

			final String query = "select image1 from mobile where name =?";
			
			byte[] image1 = (byte[]) jdbcTemplate.queryForObject(query , new DataMapper() , new Object[]  {name} );
			return image1;
                          
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	// get All Mobile Names...

	public List<String> getAllMobilesNames() {

		class DataMapper implements RowMapper {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				return rs.getString("name");
			}
		}

		try {
			final String query = "select * from mobile";
			List<String> names = jdbcTemplate.query(query, new DataMapper());

			return names;
		} catch (Exception e) {

			return null;
		}
	}
	
	public String updateMobile(Mobile m, String name) {

		String query = "update book set name=? , price=? where name =?";
		int x = jdbcTemplate.update(query, new Object[] { m.getName(), m.getPrice(), name });

		if (x == 0) {
			return "Failed";
		} else {
			return "Sucess";
		}

	}

}
