package com.project.GesExpo.services.impl;

import com.project.GesExpo.dto.ExpositionDto;
import com.project.GesExpo.exceptions.ResourceNotFoundException;
import com.project.GesExpo.models.Exposition;
import com.project.GesExpo.models.Oeuvre;
import com.project.GesExpo.models.Session;
import com.project.GesExpo.repository.ExpositionRepository;
import com.project.GesExpo.repository.OeuvreRepository;
import com.project.GesExpo.repository.SessionRepository;
import com.project.GesExpo.services.def.ExpositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpositionServiceImpl implements ExpositionService {

    @Autowired
    private ExpositionRepository expositionRepository;

    @Autowired
    private OeuvreRepository oeuvreRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Map ExpositionDto to Exposition
    private Exposition dtoToExposition(ExpositionDto expositionDto){
        return this.modelMapper.map(expositionDto, Exposition.class);
    }

    //Map Exposition to ExpositionDto
    private ExpositionDto expositionToDto(Exposition exposition){
        return this.modelMapper.map(exposition, ExpositionDto.class);
    }

    @Override
    public ExpositionDto createExposition(ExpositionDto expositionDto) {
        Exposition exposition = this.dtoToExposition(expositionDto);
        Exposition savedExposition = this.expositionRepository.save(exposition);
        return this.expositionToDto(savedExposition);
    }

    @Override
    public ExpositionDto updateExposition(ExpositionDto expositionDto, Long expositionId) {
        Exposition exposition = this.expositionRepository.findById(expositionId)
                .orElseThrow(()-> new ResourceNotFoundException("Exposition"," id ",expositionId));
        exposition.setTitre(expositionDto.getTitre());
        exposition.setEtat(expositionDto.getEtat());
        exposition.setDateExpo(expositionDto.getDateExpo());
        exposition.setDuree(expositionDto.getDuree());
        Exposition updatedExposition = this.expositionRepository.save(exposition);
        return this.expositionToDto(updatedExposition);
    }

    @Override
    public ExpositionDto getExpositionById(Long expositionId) {
        Exposition exposition = this.expositionRepository.findById(expositionId)
                .orElseThrow(()-> new ResourceNotFoundException("Exposition"," id ",expositionId));
        return this.expositionToDto(exposition);
    }

    @Override
    public List<ExpositionDto> getAllExpositions() {
        List<Exposition> expositions = this.expositionRepository.findAll();
        return expositions.stream().map(this::expositionToDto).toList();
    }

    @Override
    public List<ExpositionDto> getAllExpositionsByOeuvre(Long oeuvreId) {
        Oeuvre oeuvre = this.oeuvreRepository.findById(oeuvreId)
                .orElseThrow(()-> new ResourceNotFoundException("Oeuvre"," id ",oeuvreId));
        List<Exposition> expositions = this.expositionRepository.findByOeuvre(oeuvre);
        return expositions.stream().map(this::expositionToDto).toList();
    }

    @Override
    public List<ExpositionDto> getAllExpositionsBySession(Long sessionId) {
        Session session = this.sessionRepository.findById(sessionId)
                .orElseThrow(()-> new ResourceNotFoundException("Session"," id ",sessionId));
        List<Exposition> expositions = this.expositionRepository.findBySession(session);
        return expositions.stream().map(this::expositionToDto).toList();
    }


    @Override
    public void deleteExposition(Long expositionId) {
        Exposition exposition = this.expositionRepository.findById(expositionId)
                .orElseThrow(()-> new ResourceNotFoundException("Exposition"," id ",expositionId));
        this.expositionRepository.delete(exposition);
    }
}
