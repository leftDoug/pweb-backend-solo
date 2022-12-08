package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.RolDto;

public interface RolService {
	
	List<RolDto> listRoles() throws SQLException;
	
	RolDto getRolById(int id) throws SQLException;

}
