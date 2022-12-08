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

import cu.edu.cujae.backend.core.dto.NotaDto;
import cu.edu.cujae.backend.core.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public NotaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(NotaDto nota) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call nota_create(?, ?, ?)}");

		ps.setInt(1, nota.getIdasignatura());
		ps.setInt(2, nota.getIdevaluacion());
		ps.setInt(3, nota.getIdestudiante());
		ps.executeUpdate();

	}

	@Override
	public List<NotaDto> list() throws SQLException {
		// TODO Auto-generated method stub

		List<NotaDto> notas = new ArrayList<NotaDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM nota");

		while(rs.next()) {
			notas.add(new NotaDto(rs.getInt("idnota"), rs.getInt("idasignatura"), rs.getInt("idevaluacion"), rs.getInt("idestudiante")));
		}

		return notas;
	}

	@Override
	public NotaDto getById(int id) throws SQLException {
		// TODO Auto-generated method stub

		NotaDto nota = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM nota WHERE idnota = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			nota = new NotaDto(rs.getInt("idnota"), rs.getInt("idasignatura"), rs.getInt("idevaluacion"), rs.getInt("idestudiante"));
		}

		return nota;

	}

	@Override
	public void update(NotaDto nota) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call nota_update(?, ?, ?, ?)}");

		ps.setInt(1, nota.getIdnota());
		ps.setInt(2, nota.getIdasignatura());
		ps.setInt(3, nota.getIdevaluacion());
		ps.setInt(4, nota.getIdestudiante());
		ps.executeUpdate();

	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

		CallableStatement cs = jdbctemplate.getDataSource().getConnection().prepareCall("{call nota_delete(?)}");

		cs.setInt(1, id);
		cs.executeUpdate();

	}

}
