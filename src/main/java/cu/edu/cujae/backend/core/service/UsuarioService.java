package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;

import cu.edu.cujae.backend.core.dto.UsuarioDto;

public interface UsuarioService {
	
	void createUsuario(UsuarioDto usuario) throws SQLException;
	
	List<UsuarioDto> listUsuarios() throws SQLException;
	
	UsuarioDto getUsuarioById(int userId) throws SQLException;
	
	void updateUsuario(UsuarioDto usuario) throws SQLException;
	
	void deleteUsuario(int id) throws SQLException;

}
