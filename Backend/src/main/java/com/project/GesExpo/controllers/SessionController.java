package com.project.GesExpo.controllers;

import com.project.GesExpo.dto.OeuvreDto;
import com.project.GesExpo.dto.SessionDto;
import com.project.GesExpo.response.ApiResponse;
import com.project.GesExpo.services.def.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    //POST - CREATE SESSION
    @PostMapping("/create")
    public ResponseEntity<SessionDto> createSession(@Valid @RequestBody SessionDto sessionDto){
        SessionDto createdSessionDto = this.sessionService.createSession(sessionDto);
        return new ResponseEntity<>(createdSessionDto, HttpStatus.CREATED);
    }

    //PUT - UPDATE SESSION
    @PutMapping("/update/{sessionId}")
    public ResponseEntity<SessionDto> updateSession(@Valid @RequestBody SessionDto sessionDto, @PathVariable("sessionId") Long sessionId){
        SessionDto updatedSessionDto = this.sessionService.updateSession(sessionDto,sessionId);
        return ResponseEntity.ok(updatedSessionDto);
    }

    //DELETE - DELETE SESSION
    @DeleteMapping("/{sessionId}")
    public ResponseEntity<ApiResponse> deleteSession(@PathVariable("sessionId") Long sessionId){
        this.sessionService.deleteSession(sessionId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Session deleted successfully", true), HttpStatus.OK);
    }

    //GET - GET SINGLE SESSION
    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDto> getSingleSession(@PathVariable("sessionId") Long sessionId){
        return ResponseEntity.ok(this.sessionService.getSessionById(sessionId));
    }


    //GET - GET LIST SESSION
    @GetMapping("/all")
    public ResponseEntity<List<SessionDto>> getAllSessions(){
        return ResponseEntity.ok(this.sessionService.getAllSessions());
    }
}
