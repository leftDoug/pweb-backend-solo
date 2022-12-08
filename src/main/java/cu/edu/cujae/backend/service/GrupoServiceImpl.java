package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.GrupoDto;
import cu.edu.cujae.backend.core.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public GrupoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createGrupo(GrupoDto grupo) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call grupo_create(?, ?)}");

		ps.setInt(1, grupo.getIdanno());
		ps.setInt(2, grupo.getGrupo());
		ps.executeUpdate();

	}

	@Override
	public List<GrupoDto> listGrupos() throws SQLException {
		// TODO Auto-generated method stub

		List<GrupoDto> grupos = new ArrayList<GrupoDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM grupo");

		while(rs.next()) {
			grupos.add(new GrupoDto(rs.getInt("idgrupo"), rs.getInt("idanno"), rs.getInt("grupo")));
		}

		return grupos;
	}

	@Override
	public GrupoDto getGrupoById(int id) throws SQLException {
		// TODO Auto-generated method stub

		GrupoDto grupo = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM grupo WHERE idgrupo = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			grupo = new GrupoDto(rs.getInt("idgrupo"), rs.getInt("idanno"), rs.getInt("grupo"));
		}

		return grupo;

	}

	@Override
	public void updateGrupo(GrupoDto grupo) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call grupo_update(?, ?, ?)}");

		ps.setInt(1, grupo.getIdgrupo());
		ps.setInt(2, grupo.getIdanno());
		ps.setInt(3, grupo.getGrupo());
		ps.executeUpdate();

	}

	@Override
	public void deleteGrupo(int id) throws SQLException {
		// TODO Auto-generated method stub

		CallableStatement cs = jdbctemplate.getDataSource().getConnection().prepareCall("{call grupo_delete(?)}");

		cs.setInt(1, id);
		cs.executeUpdate();

	}

}
