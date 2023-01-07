package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Session getSessionByID(Long id) {
        return sessionRepository.getOne(id);
    }

    public List<Session> findAllSessions() {
        return sessionRepository.findAll();
    }


    public Session saveAndFlushsession (Session session) {
        return sessionRepository.saveAndFlush(session);
    }


    public void deleteSessionid (Long id) {
        sessionRepository.deleteById(id);
        Logger logger = LoggerFactory.getLogger(Session.class);
        logger.info(Session.class.getName() + id);
    }


    public Session updateSession (Session session, Long id) {
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }


}
