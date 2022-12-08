package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.AnnoDto;
import cu.edu.cujae.backend.core.service.AnnoService;

@RestController
@RequestMapping ("/api/v1/annos")
public class AnnoController {

	@Autowired
	private AnnoService annoService;

	@GetMapping ("/")
	public ResponseEntity<List<AnnoDto>> getAnnos() throws SQLException {
		List<AnnoDto> annos = annoService.listAnnos();
		return ResponseEntity.ok(annos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AnnoDto> getAnnoById(@PathVariable int id) throws SQLException {
		AnnoDto anno = annoService.getAnnoById(id);
		return ResponseEntity.ok(anno);
	}

}
