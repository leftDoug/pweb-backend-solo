package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.EstudianteDto;

public interface EstudianteService {
	
	void createEstudiante(EstudianteDto estudiante) throws SQLException;
	
	List<EstudianteDto> listEstudiantes() throws SQLException;
	
	EstudianteDto getEstudianteById(int id) throws SQLException;
	
	void updateEstudiante(EstudianteDto estudiante) throws SQLException;
	
	void deleteEstudiante(int id) throws SQLException;

}
