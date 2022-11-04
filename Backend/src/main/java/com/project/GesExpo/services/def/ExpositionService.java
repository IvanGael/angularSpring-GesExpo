package com.project.GesExpo.services.def;

import com.project.GesExpo.dto.ExpositionDto;

import java.util.List;

public interface ExpositionService {

    ExpositionDto createExposition(ExpositionDto expositionDto);

    ExpositionDto updateExposition(ExpositionDto expositionDto, Long expositionId);

    ExpositionDto getExpositionById(Long expositionId);

    List<ExpositionDto> getAllExpositions();

    List<ExpositionDto> getAllExpositionsByOeuvre(Long oeuvreId);

    List<ExpositionDto> getAllExpositionsBySession(Long sessionId);

    void deleteExposition(Long expositionId);
}
