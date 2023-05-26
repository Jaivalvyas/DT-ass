/*
 * Author Name: Jaival
 * Date: 25-05-2023
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.example.DeepThought.service;

import com.example.DeepThought.domain.Event;
import com.example.DeepThought.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventSeriveImpl implements IEventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventSeriveImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event fetchById(int uid) {
        return eventRepository.findById(uid).get();
    }

    @Override
    public boolean deleteEvent(int uid) {
        eventRepository.deleteById(uid);
        return true;
    }

    @Override
    public Event updateEvent(Event event, int uid) {
        Optional<Event> existingEvent = eventRepository.findById(uid);
        if (existingEvent.isEmpty()) {
            return null;
        }
        Event event1 = existingEvent.get();
        if (event.getType() != null) {
            event1.setType(event.getType());
        }
        if (event.getName() != null) {
            event1.setName(event.getName());
        }

        return eventRepository.save(event1);
    }


}
