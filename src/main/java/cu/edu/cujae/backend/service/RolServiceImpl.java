package cu.edu.cujae.backend.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.RolDto;
import cu.edu.cujae.backend.core.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public RolServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RolDto> listRoles() throws SQLException {
		// TODO Auto-generated method stub

		List<RolDto> roles = new ArrayList<RolDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM rol");

		while(rs.next()) {
			roles.add(new RolDto(rs.getInt("idrol"), rs.getString("rol")));
		}

		return roles;
	}

	@Override
	public RolDto getRolById(int id) throws SQLException {
		// TODO Auto-generated method stub

		RolDto rol = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM rol WHERE idrol = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			rol = new RolDto(rs.getInt("idrol"), rs.getString("rol"));
		}

		return rol;

	}

}
