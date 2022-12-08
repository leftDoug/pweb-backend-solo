package cu.edu.cujae.backend.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.SexoDto;
import cu.edu.cujae.backend.core.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public SexoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SexoDto> listSexos() throws SQLException {
		// TODO Auto-generated method stub

		List<SexoDto> sexos = new ArrayList<SexoDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM sexo");

		while(rs.next()) {
			sexos.add(new SexoDto(rs.getInt("idsexo"), rs.getString("sexo")));
		}

		return sexos;
	}

	@Override
	public SexoDto getSexoById(int id) throws SQLException {
		// TODO Auto-generated method stub

		SexoDto sexo = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM sexo WHERE idsexo = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			sexo = new SexoDto(rs.getInt("idsexo"), rs.getString("sexo"));
		}

		return sexo;

	}

}
