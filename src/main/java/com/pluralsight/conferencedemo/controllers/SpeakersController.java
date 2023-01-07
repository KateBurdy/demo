package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.services.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
@RequiredArgsConstructor
public class SpeakersController {
    private SpeakerService speakerService;

    public List<Speaker> list() {
        return speakerService.findAllSpeakers();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerService.getSpeakerByID(id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker) {
        return speakerService.saveAndFlushspeaker(speaker);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        speakerService.deleteSpeakerid(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        return speakerService.updateSpeaker(speaker, id);
    }
}
