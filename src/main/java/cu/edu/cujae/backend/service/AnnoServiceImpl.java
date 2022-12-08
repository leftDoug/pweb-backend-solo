package cu.edu.cujae.backend.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.AnnoDto;
import cu.edu.cujae.backend.core.service.AnnoService;

@Service
public class AnnoServiceImpl implements AnnoService{

	@Autowired
	private JdbcTemplate jdbctemplate;

	public AnnoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AnnoDto> listAnnos() throws SQLException {
		// TODO Auto-generated method stub

		List<AnnoDto> annos = new ArrayList<AnnoDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM anno");

		while(rs.next()) {
			annos.add(new AnnoDto(rs.getInt("idanno"),
					rs.getInt("anno")));
		}

		return annos;
	}

	@Override
	public AnnoDto getAnnoById(int id) throws SQLException {
		// TODO Auto-generated method stub

		AnnoDto anno = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM anno WHERE idanno = ?");

		ps.setInt(1, id); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			anno = new AnnoDto(rs.getInt("idanno"),rs.getInt("anno"));
		}

		return anno;

	}

}
