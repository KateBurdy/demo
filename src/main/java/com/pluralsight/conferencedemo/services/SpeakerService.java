package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeakerService {
    private final SpeakerRepository speakerRepository;

    public List<Speaker> findAllSpeakers() {
        return speakerRepository.findAll();
    }

    public Speaker getSpeakerByID(Long id) {
        return speakerRepository.getOne(id);
    }

    public Speaker saveAndFlushspeaker(Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }


    public void deleteSpeakerid(Long id) {
        speakerRepository.deleteById(id);
        Logger logger = LoggerFactory.getLogger(Speaker.class);
        logger.info(Speaker.class.getName() + id);
    }


    public Speaker updateSpeaker(Speaker speaker, Long id) {
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
