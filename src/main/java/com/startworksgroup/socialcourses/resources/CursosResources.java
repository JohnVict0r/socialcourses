package com.startworksgroup.socialcourses.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startworksgroup.socialcourses.domain.Curso;
import com.startworksgroup.socialcourses.repository.CursosRepository;

@RestController
@RequestMapping("/cursos")
public class CursosResources {

	@Autowired
	private CursosRepository cursosRepository;
	
	@GetMapping
	public List<Curso> listar() {
		return cursosRepository.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Curso curso) {
		cursosRepository.save(curso);	
	}
	
	@PutMapping("{id}")
	public void atualizar(@RequestBody Curso curso, @PathVariable("id") Long id) {
		curso.setId(id);
		cursosRepository.save(curso);	
	}
	@GetMapping("{id}")
	public Optional<Curso> buscar(@PathVariable("id") Long id) {
		return cursosRepository.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
		cursosRepository.deleteById(id);
	}
}
