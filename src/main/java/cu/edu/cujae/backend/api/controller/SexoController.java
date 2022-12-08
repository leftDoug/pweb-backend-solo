package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.SexoDto;
import cu.edu.cujae.backend.core.service.SexoService;

@RestController
@RequestMapping ("/api/v1/sexos")
public class SexoController {

	@Autowired
	private SexoService sexoService;
	
	@GetMapping ("/")
	public ResponseEntity<List<SexoDto>> list() throws SQLException {
		List<SexoDto> sexos = sexoService.listSexos();
		return ResponseEntity.ok(sexos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SexoDto> getById(@PathVariable int id) throws SQLException {
		SexoDto sexo = sexoService.getSexoById(id);
		return ResponseEntity.ok(sexo);
	}

}
