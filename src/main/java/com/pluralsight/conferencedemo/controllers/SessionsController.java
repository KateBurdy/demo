package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
@RequiredArgsConstructor
public class SessionsController {

    private SessionService sessionService;

    @GetMapping
    public List<Session> list() {
        return sessionService.findAllSessions();
    }

    @GetMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionService.getSessionByID(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionService.saveAndFlushsession(session);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        sessionService.deleteSessionid(id);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.updateSession(session, id);
    }

}
