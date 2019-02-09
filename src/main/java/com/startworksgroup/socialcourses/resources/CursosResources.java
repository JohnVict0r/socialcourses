package com.startworksgroup.socialcourses.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
