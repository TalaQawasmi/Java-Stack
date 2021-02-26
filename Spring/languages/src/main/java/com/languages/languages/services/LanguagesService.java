package com.languages.languages.services;

import com.languages.languages.models.languages;
import com.languages.languages.repositories.LanguagesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService {

    // adding the language repository as a dependency
    private final LanguagesRepository languageRepository;

    public LanguagesService(LanguagesRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<languages> allLanguages(){
        return languageRepository.findAll();
    }
    // creates a language
    public languages createBook(languages b) {
        return languageRepository.save(b);
    }
    // retrieves a language
    public languages findLanguage(Long id) {
        Optional<languages> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    // update a language
    public languages updateLanguage(Long id, String name, String creator, Integer version) {
        languages updateLang = findLanguage(id);
        updateLang.setName(name);
        updateLang.setCreator(creator);
        updateLang.setVersion(version);
        return languageRepository.save(updateLang);
    }
    //Delete
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
    public void updateBook(languages language) {
        languageRepository.save(language);
    }
}