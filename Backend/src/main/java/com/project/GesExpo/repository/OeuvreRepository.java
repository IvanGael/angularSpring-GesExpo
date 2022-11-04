package com.project.GesExpo.repository;

import com.project.GesExpo.models.Oeuvre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {
}