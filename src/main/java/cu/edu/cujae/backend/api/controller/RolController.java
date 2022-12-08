package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.RolDto;
import cu.edu.cujae.backend.core.service.RolService;

@RestController
@RequestMapping ("/api/v1/roles")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping ("/")
	public ResponseEntity<List<RolDto>> list() throws SQLException {
		List<RolDto> roles = rolService.listRoles();
		return ResponseEntity.ok(roles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RolDto> getById(@PathVariable int id) throws SQLException {
		RolDto rol = rolService.getRolById(id);
		return ResponseEntity.ok(rol);
	}

}
