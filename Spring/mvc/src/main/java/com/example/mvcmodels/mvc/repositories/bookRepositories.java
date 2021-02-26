package com.example.mvcmodels.mvc.repositories;

import com.example.mvcmodels.mvc.models.book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookRepositories extends CrudRepository<book, Long> {
    // this method retrieves all the books from the database
    List<book> findAll();
    // this method finds books with descriptions containing the search string
    List<book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
