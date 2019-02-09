package com.startworksgroup.socialcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startworksgroup.socialcourses.domain.Curso;

public interface CursosRepository extends JpaRepository<Curso, Long>{

}
