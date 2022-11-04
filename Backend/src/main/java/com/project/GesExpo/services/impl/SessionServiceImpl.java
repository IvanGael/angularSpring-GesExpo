package com.project.GesExpo.services.impl;

import com.project.GesExpo.dto.SessionDto;
import com.project.GesExpo.exceptions.ResourceNotFoundException;
import com.project.GesExpo.models.Session;
import com.project.GesExpo.repository.SessionRepository;
import com.project.GesExpo.services.def.SessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Map SessionDto to Session
    private Session dtoToSession(SessionDto sessionDto){
        return this.modelMapper.map(sessionDto, Session.class);
    }

    //Map Session to SessionDto
    private SessionDto sessionToDto(Session session){
        return this.modelMapper.map(session, SessionDto.class);
    }

    @Override
    public SessionDto createSession(SessionDto sessionDto) {
        Session session = this.dtoToSession(sessionDto);
        Session savedSession = this.sessionRepository.save(session);
        return this.sessionToDto(savedSession);
    }

    @Override
    public SessionDto updateSession(SessionDto sessionDto, Long sessionId) {
        Session session = this.sessionRepository.findById(sessionId)
                .orElseThrow(()-> new ResourceNotFoundException("Session"," id ",sessionId));
        session.setTitre(sessionDto.getTitre());
        session.setDateDebut(sessionDto.getDateDebut());
        session.setDateFin(sessionDto.getDateFin());
        session.setLocalisation(sessionDto.getLocalisation());
        Session updatedSession = this.sessionRepository.save(session);
        return this.sessionToDto(updatedSession);
    }

    @Override
    public SessionDto getSessionById(Long sessionId) {
        Session session = this.sessionRepository.findById(sessionId)
                .orElseThrow(()-> new ResourceNotFoundException("Session"," id ",sessionId));
        return this.sessionToDto(session);
    }

    @Override
    public List<SessionDto> getAllSessions() {
        List<Session> sessions = this.sessionRepository.findAll();
        return sessions.stream().map(this::sessionToDto).toList();
    }

    @Override
    public void deleteSession(Long sessionId) {
        Session session = this.sessionRepository.findById(sessionId)
                .orElseThrow(()-> new ResourceNotFoundException("Session"," id ",sessionId));
        this.sessionRepository.delete(session);
    }
}
