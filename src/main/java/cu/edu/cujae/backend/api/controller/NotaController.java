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

import cu.edu.cujae.backend.core.dto.NotaDto;
import cu.edu.cujae.backend.core.service.NotaService;

@RestController
@RequestMapping ("/api/v1/notas")
public class NotaController {

	@Autowired
	private NotaService notaService;
	
	@GetMapping ("/")
	public ResponseEntity<List<NotaDto>> list() throws SQLException {
		List<NotaDto> notas = notaService.list();
		return ResponseEntity.ok(notas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NotaDto> getById(@PathVariable int id) throws SQLException {
		NotaDto nota = notaService.getById(id);
		return ResponseEntity.ok(nota);
	}
	
	@PostMapping ("/")
	public ResponseEntity<String> create(@RequestBody NotaDto nota) throws SQLException {
		notaService.create(nota);
		return ResponseEntity.ok("Nota creada");
	}
	
	@PutMapping ("/")
	public ResponseEntity<String> update(@RequestBody NotaDto nota) throws SQLException {
		notaService.update(nota);
		return ResponseEntity.ok("Nota actualizada");
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		notaService.delete(45);
		return ResponseEntity.ok("Nota borrada");
	}

}
