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

import cu.edu.cujae.backend.core.dto.AsignaturaDto;
import cu.edu.cujae.backend.core.service.AsignaturaService;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public AsignaturaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createAsignatura(AsignaturaDto asignatura) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call asignatura_create(?, ?, ?)}");

		ps.setInt(1, asignatura.getIdanno());
		ps.setString(2, asignatura.getAsignatura());
		ps.executeUpdate();

	}

	@Override
	public List<AsignaturaDto> listAsignaturas() throws SQLException {
		// TODO Auto-generated method stub

		List<AsignaturaDto> asignaturas = new ArrayList<AsignaturaDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM asignatura");

		while(rs.next()) {
			asignaturas.add(new AsignaturaDto(rs.getInt("idasignatura"), rs.getInt("idanno"), rs.getString("asignatura"), rs.getInt("horas")));
		}

		return asignaturas;
	}

	@Override
	public AsignaturaDto getAsignaturaById(int id) throws SQLException {
		// TODO Auto-generated method stub

		AsignaturaDto asignatura = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM asignatura WHERE idasignatura = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			asignatura = new AsignaturaDto(rs.getInt("idasignatura"), rs.getInt("idanno"), rs.getString("asignatura"), rs.getInt("horas"));
		}

		return asignatura;

	}

	@Override
	public void updateAsignatura(AsignaturaDto asignatura) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call asignatura_update(?, ?, ?, ?)}");

		ps.setInt(1, asignatura.getIdasignatura());
		ps.setInt(2, asignatura.getIdanno());
		ps.setString(3, asignatura.getAsignatura());
		ps.setInt(4, asignatura.getHoras());
		ps.executeUpdate();

	}

	@Override
	public void deleteAsignatura(int id) throws SQLException {
		// TODO Auto-generated method stub

		CallableStatement cs = jdbctemplate.getDataSource().getConnection().prepareCall("{call asignatura_delete(?)}");

		cs.setInt(1, id);
		cs.executeUpdate();

	}

}
