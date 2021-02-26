package com.lookify.services;

import com.lookify.models.lookify;
import com.lookify.repositories.LookifyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LookifyService {
    private final LookifyRepository lookifyRepository;

    public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    public List<lookify> allartist() {
        return lookifyRepository.findAll();
    }
    // creates a book
    public lookify createBook(lookify b) {
        return lookifyRepository.save(b);
    }
    // retrieves a book
    public lookify findBook(Long id) {
        Optional<lookify> optionalLookify = lookifyRepository.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }

    }

    public lookify updateBook(Long id, String title, String artist,Integer rating) {
        lookify f=findBook(id);
        f.setTitle(title);
        f.setArtist(artist);
        f.setRating(rating);
        return lookifyRepository.save(f);
    }

    public void deleteBook(Long id) {
        lookifyRepository.deleteById(id);
    }

    public void updateBook(lookify book) {
        lookifyRepository.save(book);
    }
}
