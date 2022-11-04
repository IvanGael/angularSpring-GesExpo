package com.project.GesExpo.repository;

import com.project.GesExpo.dto.ExpositionDto;
import com.project.GesExpo.models.Exposition;
import com.project.GesExpo.models.Oeuvre;
import com.project.GesExpo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpositionRepository extends JpaRepository<Exposition, Long> {

    List<Exposition> findByOeuvre(Oeuvre oeuvre);

    List<Exposition> findBySession(Session session);
}