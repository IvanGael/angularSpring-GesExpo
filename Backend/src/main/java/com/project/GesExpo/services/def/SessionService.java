package com.project.GesExpo.services.def;

import com.project.GesExpo.dto.SessionDto;

import java.util.List;

public interface SessionService {

    SessionDto createSession(SessionDto sessionDto);

    SessionDto updateSession(SessionDto sessionDto, Long sessionId);

    SessionDto getSessionById(Long sessionId);

    List<SessionDto> getAllSessions();

    void deleteSession(Long sessionId);
}
