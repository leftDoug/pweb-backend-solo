package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.SexoDto;

public interface SexoService {

	List<SexoDto> listSexos() throws SQLException;

	SexoDto getSexoById(int id) throws SQLException;

}
