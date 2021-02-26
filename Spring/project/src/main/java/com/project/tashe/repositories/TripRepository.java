package com.project.tashe.repositories;

import com.project.tashe.models.Landmark;
import com.project.tashe.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {
    List<Trip> findAll();
    List<Trip> findAllByOrderByPriceAsc();
    List<Trip> findAllByOrderByDateAsc();
}

