package com.startworksgroup.socialcourses.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startworksgroup.socialcourses.domain.Curso;

@RestController
@RequestMapping("/cursos")
public class CursosResources {

	@GetMapping("")
	public List<Curso> listar() {
		
		Curso c1 = new Curso("Engenharia de Computação");
		Curso c2 = new Curso("Ciências da Computação");
		Curso c3 = new Curso("Engenharia Biomédica");
		
		Curso[] cursos = {c1,c2,c3}; 
		return Arrays.asList(cursos);
	}
}
