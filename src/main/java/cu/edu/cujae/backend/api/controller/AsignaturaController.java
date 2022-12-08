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

import cu.edu.cujae.backend.core.dto.AsignaturaDto;
import cu.edu.cujae.backend.core.service.AsignaturaService;

@RestController
@RequestMapping ("/api/v1/asignaturas")
public class AsignaturaController {

	@Autowired
	private AsignaturaService asignaturaService;

	@GetMapping ("/")
	public ResponseEntity<List<AsignaturaDto>> getAsignaturas() throws SQLException {
		List<AsignaturaDto> asignaturas = asignaturaService.listAsignaturas();
		return ResponseEntity.ok(asignaturas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AsignaturaDto> getAsignaturaById(@PathVariable int id) throws SQLException {
		AsignaturaDto asignatura = asignaturaService.getAsignaturaById(id);
		return ResponseEntity.ok(asignatura);
	}

	@PostMapping ("/")
	public ResponseEntity<String> create(@RequestBody AsignaturaDto asignatura) throws SQLException {
		asignaturaService.createAsignatura(asignatura);
		return ResponseEntity.ok("Asignatura creada");
	}

	@PutMapping ("/")
	public ResponseEntity<String> update(@RequestBody AsignaturaDto asignatura) throws SQLException {
		asignaturaService.updateAsignatura(asignatura);
		return ResponseEntity.ok("Asignatura actualizada");
	}

	@DeleteMapping ("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		asignaturaService.deleteAsignatura(45);
		return ResponseEntity.ok("Asignatura borrada");
	}

}
