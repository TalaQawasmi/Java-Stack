package com.example.mvcmodels.mvc.services;
import com.example.mvcmodels.mvc.models.book;
import com.example.mvcmodels.mvc.repositories.bookRepositories;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;


@Service

public class bookServices {
    private final bookRepositories bookRepository;

    public bookServices(bookRepositories bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public book createBook(book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public book findBook(Long id) {
        Optional<book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }

    }

    public book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        book f=findBook(id);
        f.setTitle(title);
        f.setDescription(desc);
        f.setLanguage(lang);
        f.setNumberOfPages(numOfPages);
        return bookRepository.save(f);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(book book) {
        bookRepository.save(book);
    }
}
