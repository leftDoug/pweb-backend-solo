package cu.edu.cujae.backend.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.EvaluacionDto;
import cu.edu.cujae.backend.core.service.EvaluacionService;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public EvaluacionServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<EvaluacionDto> listEvaluaciones() throws SQLException {
		// TODO Auto-generated method stub

		List<EvaluacionDto> evaluaciones = new ArrayList<EvaluacionDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM evaluacion");

		while(rs.next()) {
			evaluaciones.add(new EvaluacionDto(rs.getInt("idevaluacion"), rs.getString("evaluacion")));
		}

		return evaluaciones;
	}

	@Override
	public EvaluacionDto getEvaluacionById(int id) throws SQLException {
		// TODO Auto-generated method stub

		EvaluacionDto evaluacion = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM evaluacion WHERE idevaluacion = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			evaluacion = new EvaluacionDto(rs.getInt("idevaluacion"), rs.getString("evaluacion"));
		}

		return evaluacion;

	}

}
