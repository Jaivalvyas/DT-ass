package com.example.DeepThought.service;

import com.example.DeepThought.domain.Event;

import java.util.List;

public interface IEventService {
    Event saveEvent(Event event);

    List<Event> getAllEvents();

    Event fetchById(int uid);

    boolean deleteEvent(int uid);

    Event updateEvent(Event event, int uid);
}
