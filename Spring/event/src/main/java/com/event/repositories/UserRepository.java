package com.event.repositories;

import com.event.models.EventUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<EventUser, Long> {
    EventUser findByEmail(String email);
}
