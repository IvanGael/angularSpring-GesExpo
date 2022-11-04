package com.project.GesExpo.controllers;

import com.project.GesExpo.dto.ExpositionDto;
import com.project.GesExpo.response.ApiResponse;
import com.project.GesExpo.services.def.ExpositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/exposition")
public class ExpositionController {

    @Autowired
    private ExpositionService expositionService;


    //POST - CREATE EXPOSITION
    @PostMapping("/create")
    public ResponseEntity<ExpositionDto> createExposition(@Valid @RequestBody ExpositionDto expositionDto){
        ExpositionDto createdExpositionDto = this.expositionService.createExposition(expositionDto);
        return new ResponseEntity<>(createdExpositionDto, HttpStatus.CREATED);
    }

    //PUT - UPDATE EXPOSITION
    @PutMapping("/update/{expositionId}")
    public ResponseEntity<ExpositionDto> updateExposition(@Valid @RequestBody ExpositionDto expositionDto,
                                                    @PathVariable("expositionId") Long expositionId){
        ExpositionDto updatedExpositionDto = this.expositionService.updateExposition(expositionDto,expositionId);
        return ResponseEntity.ok(updatedExpositionDto);
    }

    //DELETE - DELETE SESSION
    @DeleteMapping("/{expositionId}")
    public ResponseEntity<ApiResponse> deleteExposition(@PathVariable("expositionId") Long expositionId){
        this.expositionService.deleteExposition(expositionId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Exposition deleted successfully", true), HttpStatus.OK);
    }

    //GET - GET SINGLE EXPOSITION
    @GetMapping("/{expositionId}")
    public ResponseEntity<ExpositionDto> getSingleExposition(@PathVariable("expositionId") Long expositionId){
        return ResponseEntity.ok(this.expositionService.getExpositionById(expositionId));
    }


    //GET - GET LIST EXPOSITION
    @GetMapping("/all")
    public ResponseEntity<List<ExpositionDto>> getAllExpositions(){
        return ResponseEntity.ok(this.expositionService.getAllExpositions());
    }


    //GET - GET LIST EXPOSITION BY OEUVRE
    @GetMapping("/oeuvre/{oeuvreId}")
    public ResponseEntity<List<ExpositionDto>> getAllExpositionsByOeuvre(@PathVariable("oeuvreId") Long oeuvreId){
        return ResponseEntity.ok(this.expositionService.getAllExpositionsByOeuvre(oeuvreId));
    }

    //GET - GET LIST EXPOSITION BY SESSION
    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<ExpositionDto>> getAllExpositionsBySession(@PathVariable("sessionId") Long sessionId){
        return ResponseEntity.ok(this.expositionService.getAllExpositionsBySession(sessionId));
    }


}


