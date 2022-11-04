package com.project.GesExpo.services.impl;

import com.project.GesExpo.dto.ExpositionDto;
import com.project.GesExpo.dto.OeuvreDto;
import com.project.GesExpo.exceptions.ResourceNotFoundException;
import com.project.GesExpo.models.Exposition;
import com.project.GesExpo.models.Oeuvre;
import com.project.GesExpo.repository.ExpositionRepository;
import com.project.GesExpo.repository.OeuvreRepository;
import com.project.GesExpo.services.def.OeuvreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OeuvreServiceImpl implements OeuvreService {

    @Autowired
    private OeuvreRepository oeuvreRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Map OeuvreDto to Oeuvre
    private Oeuvre dtoToOeuvre(OeuvreDto oeuvreDto){
        return this.modelMapper.map(oeuvreDto, Oeuvre.class);
    }

    //Map Oeuvre to OeuvreDto
    private OeuvreDto oeuvreToDto(Oeuvre oeuvre){
        return this.modelMapper.map(oeuvre, OeuvreDto.class);
    }


    @Override
    public OeuvreDto createOeuvre(OeuvreDto oeuvreDto) {
        Oeuvre oeuvre = this.dtoToOeuvre(oeuvreDto);
        Oeuvre savedOeuvre = this.oeuvreRepository.save(oeuvre);
        return this.oeuvreToDto(savedOeuvre);
    }

    @Override
    public OeuvreDto updateOeuvre(OeuvreDto oeuvreDto, Long oeuvreId) {
        Oeuvre oeuvre = this.oeuvreRepository.findById(oeuvreId)
                .orElseThrow(()-> new ResourceNotFoundException("Oeuvre"," id ",oeuvreId));
        oeuvre.setTitre(oeuvreDto.getTitre());
        oeuvre.setPrix(oeuvreDto.getPrix());
        oeuvre.setAnnee(oeuvreDto.getAnnee());
        oeuvre.setDateCreation(oeuvre.getDateCreation());
        oeuvre.setRating(oeuvreDto.getRating());
        oeuvre.setType(oeuvreDto.getType());
        oeuvre.setImage(oeuvreDto.getImage());
        Oeuvre updatedOeuvre = this.oeuvreRepository.save(oeuvre);
        return this.oeuvreToDto(updatedOeuvre);
    }

    @Override
    public OeuvreDto getOeuvreById(Long oeuvreId) {
        Oeuvre oeuvre = this.oeuvreRepository.findById(oeuvreId)
                .orElseThrow(()-> new ResourceNotFoundException("Oeuvre"," id ",oeuvreId));
        return this.oeuvreToDto(oeuvre);
    }

    @Override
    public List<OeuvreDto> getAllOeuvres() {
        List<Oeuvre> oeuvres = this.oeuvreRepository.findAll();
        return oeuvres.stream().map(this::oeuvreToDto).toList();
    }


    @Override
    public void deleteOeuvre(Long oeuvreId) {
        Oeuvre oeuvre = this.oeuvreRepository.findById(oeuvreId)
                .orElseThrow(()-> new ResourceNotFoundException("Oeuvre"," id ",oeuvreId));
        this.oeuvreRepository.delete(oeuvre);
    }
}
