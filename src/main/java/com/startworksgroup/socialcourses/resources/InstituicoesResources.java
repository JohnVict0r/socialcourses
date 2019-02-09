package com.startworksgroup.socialcourses.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startworksgroup.socialcourses.domain.Instituicao;
import com.startworksgroup.socialcourses.repository.InstituicoesRepository;

@RestController
@RequestMapping("/instituicoes")
public class InstituicoesResources {

	@Autowired
	private InstituicoesRepository instituicoesRepository;
	
	@GetMapping
	public List<Instituicao> listar() {
		return instituicoesRepository.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Instituicao instituicao) {
		instituicoesRepository.save(instituicao);	
	}
}
