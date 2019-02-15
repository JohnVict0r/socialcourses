package com.startworksgroup.socialcourses.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.startworksgroup.socialcourses.domain.Curso;
import com.startworksgroup.socialcourses.repository.CursosRepository;

@RestController
@RequestMapping("/cursos")
public class CursosResources {

	@Autowired
	private CursosRepository cursosRepository;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar() {
		List<Curso> result = cursosRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Curso curso) {
		curso = cursosRepository.save(curso);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(curso.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@RequestBody Curso curso, 
			@PathVariable("id") Long id
		) {
		curso.setId(id);
		cursosRepository.save(curso);	
		
		return ResponseEntity.noContent().build();
	}
	@GetMapping("{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Optional<Curso> curso = cursosRepository.findById(id);
		
		if(!curso.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(curso); 
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		try {
			cursosRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}
