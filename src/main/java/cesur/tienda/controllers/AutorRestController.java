package cesur.tienda.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cesur.tienda.dtos.AutorDTO;
import cesur.tienda.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorRestController {
	@Autowired
	AutorService autorService;
	
	@PostMapping
	ResponseEntity<?> createAutor(@RequestBody AutorDTO autorDTO) {

		AutorDTO autor = autorService.createAutor(autorDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + autor.getId())
				.buildAndExpand(autor.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/{autorId}")
	ResponseEntity<?> getAutor(@PathVariable Long autorId) {

		return ResponseEntity.ok(autorService.getAutor(autorId));
	}
	@GetMapping()
	public ResponseEntity<?> getAllAutores(){		
		
		return ResponseEntity.ok(autorService.getAllLibros()) ;
	}

	
	

}
