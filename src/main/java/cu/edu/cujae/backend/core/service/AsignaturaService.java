package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.AsignaturaDto;

public interface AsignaturaService {

	void createAsignatura(AsignaturaDto asignatura) throws SQLException;

	List<AsignaturaDto> listAsignaturas() throws SQLException;

	AsignaturaDto getAsignaturaById(int id) throws SQLException;

	void updateAsignatura(AsignaturaDto asignatura) throws SQLException;

	void deleteAsignatura(int id) throws SQLException;

}
