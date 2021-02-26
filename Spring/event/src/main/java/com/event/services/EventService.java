package com.event.services;

import com.event.models.Event;
import com.event.models.EventUser;
import com.event.models.Message;
import com.event.repositories.EventRepository;
import com.event.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eRepo;
    @Autowired
    private MessageRepository mRepo;

    public List<Event> allEventsWithState(String state) {
        return this.eRepo.findByState(state);
    }
    public List<Event> allEventsNotState(String state) {
        return this.eRepo.findByStateIsNot(state);
    }

    public Event findById(Long id) {
        return this.eRepo.findById(id).orElse(null);
    }

    public Event create(Event event) {
        return this.eRepo.save(event);
    }
    public Event update(Event event) {
        return this.eRepo.save(event);
    }

    public void comment(EventUser user, Event event, String comment) {
        this.mRepo.save(new Message(user, event, comment));
    }
    public void delete(Long id) {
        this.eRepo.deleteById(id);
    }

    public void manageAttendees(Event event, EventUser user, boolean isJoining) {
        if(isJoining) {
            event.getAttendees().add(user);
        } else {
            event.getAttendees().remove(user);
        }
        this.eRepo.save(event);
    }
}
