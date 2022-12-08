package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.UsuarioDto;
import cu.edu.cujae.backend.core.service.UsuarioService;

@RestController
@RequestMapping ("/api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping ("/")
	public ResponseEntity<List<UsuarioDto>> getUsuarios() throws SQLException {
		List<UsuarioDto> usuarios = usuarioService.listUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable int id) throws SQLException {
		UsuarioDto usuario = usuarioService.getUsuarioById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping ("/")
	public ResponseEntity<String> create(@RequestBody UsuarioDto usuario) throws SQLException {
		usuarioService.createUsuario(usuario);
		return ResponseEntity.ok("Usuario creado");
	}
	
	@PutMapping ("/")
	public ResponseEntity<String> update(@RequestBody UsuarioDto usuario) throws SQLException {
		usuarioService.updateUsuario(usuario);
		return ResponseEntity.ok("Usuario actualizado");
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
		usuarioService.deleteUsuario(id);
		return ResponseEntity.ok("Usuario borrado");
	}

}
