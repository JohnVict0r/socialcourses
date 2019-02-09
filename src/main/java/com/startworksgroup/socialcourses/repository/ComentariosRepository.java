package com.startworksgroup.socialcourses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.startworksgroup.socialcourses.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
