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

import com.startworksgroup.socialcourses.domain.Instituicao;
import com.startworksgroup.socialcourses.repository.InstituicoesRepository;

@RestController
@RequestMapping("/instituicoes")
public class InstituicoesResources {

	@Autowired
	private InstituicoesRepository instituicoesRepository;
	
	@GetMapping
	public ResponseEntity<List<Instituicao>> listar() {
		List<Instituicao> result = instituicoesRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Instituicao instituicao) {
		instituicao = instituicoesRepository.save(instituicao);	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(instituicao.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> atualizar(
			@RequestBody Instituicao instituicao, 
			@PathVariable("id") Long id
		) {
		instituicao.setId(id);
		instituicoesRepository.save(instituicao);
		
		return ResponseEntity.noContent().build();
	}
	@GetMapping("{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		
		Optional<Instituicao> instituicao = instituicoesRepository.findById(id);
		
		if(!instituicao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(instituicao);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		try {
			instituicoesRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
}
