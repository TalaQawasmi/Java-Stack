package com.belt.exam.repositories;

import com.belt.exam.models.Show;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
    @Query(value="SELECT * FROM shows ORDER BY avg_rating DESC;", nativeQuery=true)
    List<Show> findAll();
}
