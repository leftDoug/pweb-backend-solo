package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.NotaDto;

public interface NotaService {

	void create(NotaDto nota) throws SQLException;

	List<NotaDto> list() throws SQLException;

	NotaDto getById(int id) throws SQLException;

	void update(NotaDto nota) throws SQLException;

	void delete(int id) throws SQLException;

}
