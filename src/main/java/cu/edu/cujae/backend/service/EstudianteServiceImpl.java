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

import cu.edu.cujae.backend.core.dto.EstudianteDto;
import cu.edu.cujae.backend.core.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public EstudianteServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createEstudiante(EstudianteDto estudiante) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call estudiante_create(?, ?, ?, ?, ?, ?)}");

		ps.setInt(1, estudiante.getIdestudiante());
		ps.setInt(2, estudiante.getNumero());
		ps.setString(3, estudiante.getNombre());
		ps.setString(4, estudiante.getApellido());
		ps.setInt(5, estudiante.getIdgrupo());
		ps.setInt(6, estudiante.getIdsexo());
		ps.executeUpdate();

	}

	@Override
	public List<EstudianteDto> listEstudiantes() throws SQLException {
		// TODO Auto-generated method stub

		List<EstudianteDto> estudiantes = new ArrayList<EstudianteDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM estudiante");

		while(rs.next()) {
			estudiantes.add(new EstudianteDto(rs.getInt("idestudinate"), rs.getInt("numero"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("idgrupo"), rs.getInt("idsexo")));
		}

		return estudiantes;
	}

	@Override
	public EstudianteDto getEstudianteById(int id) throws SQLException {
		// TODO Auto-generated method stub

		EstudianteDto estudiante = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM estudiante WHERE idestudiante = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			estudiante = new EstudianteDto(rs.getInt("idestudiante"), rs.getInt("numero"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("idgrupo"), rs.getInt("idsexo"));
		}

		return estudiante;

	}

	@Override
	public void updateEstudiante(EstudianteDto estudiante) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call estudiante_update(?, ?, ?, ?, ?, ?)}");

		ps.setInt(1, estudiante.getIdestudiante());
		ps.setInt(2, estudiante.getNumero());
		ps.setString(3, estudiante.getNombre());
		ps.setString(4, estudiante.getApellido());
		ps.setInt(5, estudiante.getIdgrupo());
		ps.setInt(6, estudiante.getIdsexo());
		ps.executeUpdate();

	}

	@Override
	public void deleteEstudiante(int id) throws SQLException {
		// TODO Auto-generated method stub

		CallableStatement cs = jdbctemplate.getDataSource().getConnection().prepareCall("{call estudiante_delete(?)}");

		cs.setInt(1, id);
		cs.executeUpdate();

	}

}
