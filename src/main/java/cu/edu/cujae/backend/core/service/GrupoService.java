package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.GrupoDto;

public interface GrupoService {

	void createGrupo(GrupoDto grupo) throws SQLException;

	List<GrupoDto> listGrupos() throws SQLException;

	GrupoDto getGrupoById(int id) throws SQLException;

	void updateGrupo(GrupoDto grupo) throws SQLException;

	void deleteGrupo(int id) throws SQLException;

}
