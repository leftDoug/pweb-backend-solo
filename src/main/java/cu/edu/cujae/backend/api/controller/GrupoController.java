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

import cu.edu.cujae.backend.core.dto.GrupoDto;
import cu.edu.cujae.backend.core.service.GrupoService;

@RestController
@RequestMapping ("/api/v1/grupos")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@GetMapping ("/")
	public ResponseEntity<List<GrupoDto>> getGrupos() throws SQLException {
		List<GrupoDto> grupos = grupoService.listGrupos();
		return ResponseEntity.ok(grupos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GrupoDto> getGrupoById(@PathVariable int id) throws SQLException {
		GrupoDto grupo = grupoService.getGrupoById(id);
		return ResponseEntity.ok(grupo);
	}
	
	@PostMapping ("/")
	public ResponseEntity<String> create(@RequestBody GrupoDto grupo) throws SQLException {
		grupoService.createGrupo(grupo);
		return ResponseEntity.ok("Grupo creado");
	}
	
	@PutMapping ("/")
	public ResponseEntity<String> update(@RequestBody GrupoDto grupo) throws SQLException {
		grupoService.updateGrupo(grupo);
		return ResponseEntity.ok("Grupo actualizado");
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) throws SQLException {
		grupoService.deleteGrupo(id);
		return ResponseEntity.ok("Grupo borrado");
	}

}
