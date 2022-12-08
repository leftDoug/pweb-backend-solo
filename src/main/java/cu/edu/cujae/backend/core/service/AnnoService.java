package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.AnnoDto;

public interface AnnoService {
	
	List<AnnoDto> listAnnos() throws SQLException;
	
	AnnoDto getAnnoById(int id) throws SQLException;

}
