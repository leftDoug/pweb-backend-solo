package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.EvaluacionDto;
import cu.edu.cujae.backend.core.service.EvaluacionService;

@RestController
@RequestMapping ("/api/v1/evaluaciones")
public class EvaluacionController {

	@Autowired
	private EvaluacionService evaluacionService;
	
	@GetMapping ("/")
	public ResponseEntity<List<EvaluacionDto>> getEvaluaciones() throws SQLException {
		List<EvaluacionDto> evaluaciones = evaluacionService.listEvaluaciones();
		return ResponseEntity.ok(evaluaciones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EvaluacionDto> getEvaluacionById(@PathVariable int id) throws SQLException {
		EvaluacionDto evaluacion = evaluacionService.getEvaluacionById(id);
		return ResponseEntity.ok(evaluacion);
	}

}
