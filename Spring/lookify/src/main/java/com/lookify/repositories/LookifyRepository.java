package com.lookify.repositories;
import com.lookify.models.lookify;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface LookifyRepository extends CrudRepository<lookify, Long> {
    List<lookify> findAll();
}
