package com.languages.languages.repositories;

import com.languages.languages.models.languages;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguagesRepository extends CrudRepository<languages, Long>{
    List<languages> findAll();
}
