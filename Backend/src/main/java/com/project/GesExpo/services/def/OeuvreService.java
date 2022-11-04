package com.project.GesExpo.services.def;

import com.project.GesExpo.dto.OeuvreDto;

import java.util.List;

public interface OeuvreService {

    OeuvreDto createOeuvre(OeuvreDto oeuvreDto);

    OeuvreDto updateOeuvre(OeuvreDto oeuvreDto, Long oeuvreId);

    OeuvreDto getOeuvreById(Long oeuvreId);

    List<OeuvreDto> getAllOeuvres();

    void deleteOeuvre(Long oeuvreId);
}
