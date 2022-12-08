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

import cu.edu.cujae.backend.core.dto.EstudianteDto;
import cu.edu.cujae.backend.core.service.EstudianteService;

@RestController
@RequestMapping ("/api/v1/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@GetMapping ("/")
	public ResponseEntity<List<EstudianteDto>> getEstudiantes() throws SQLException {
		List<EstudianteDto> estudiantes = estudianteService.listEstudiantes();
		return ResponseEntity.ok(estudiantes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EstudianteDto> getEstudianteById(@PathVariable int id) throws SQLException {
		EstudianteDto estudiante = estudianteService.getEstudianteById(id);
		return ResponseEntity.ok(estudiante);
	}

	@PostMapping ("/")
	public ResponseEntity<String> create(@RequestBody EstudianteDto estudiante) throws SQLException {
		estudianteService.createEstudiante(estudiante);
		return ResponseEntity.ok("Estudiante creado");
	}

	@PutMapping ("/")
	public ResponseEntity<String> update(@RequestBody EstudianteDto estudiante) throws SQLException {
		estudianteService.updateEstudiante(estudiante);
		return ResponseEntity.ok("Estudiante actualizado");
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		estudianteService.deleteEstudiante(45);
		return ResponseEntity.ok("Estudiante borrado");
	}

}
