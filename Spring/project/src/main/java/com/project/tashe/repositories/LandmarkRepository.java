package com.project.tashe.repositories;

import com.project.tashe.models.Landmark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandmarkRepository extends CrudRepository<Landmark, Long> {
}
