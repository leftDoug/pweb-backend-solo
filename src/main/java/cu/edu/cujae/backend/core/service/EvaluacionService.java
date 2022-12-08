package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.EvaluacionDto;

public interface EvaluacionService {
	
	List<EvaluacionDto> listEvaluaciones() throws SQLException;
	
	EvaluacionDto getEvaluacionById(int id) throws SQLException;

}
