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
	
	@PutMapping("{id}")
	public void atualizar(@RequestBody Instituicao instituicao, @PathVariable("id") Long id) {
		instituicao.setId(id);
		instituicoesRepository.save(instituicao);	
	}
	@GetMapping("{id}")
	public Optional<Instituicao> buscar(@PathVariable("id") Long id) {
		return instituicoesRepository.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable("id") Long id) {
		instituicoesRepository.deleteById(id);
	}
}
