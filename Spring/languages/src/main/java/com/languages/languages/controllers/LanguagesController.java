package com.languages.languages.controllers;

import com.languages.languages.models.languages;
import com.languages.languages.services.LanguagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguagesController {
    private final LanguagesService languageService;

    public LanguagesController(LanguagesService languageService) {
        this.languageService = languageService;
    }
    @RequestMapping("/")
    public  String index(Model model){
        List<languages> language =languageService.allLanguages();
        model.addAttribute("languages",language );
        return "index.jsp";
    }
    @RequestMapping("/new")
    public String newBook(@ModelAttribute("book") languages language) {
        return "new.jsp";
    }
    @RequestMapping(value="/books", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") languages language, BindingResult result) {
        if (result.hasErrors()) {
            return "/new.jsp";
        } else {
            LanguagesService.createBook(languages);
            return "redirect:/";
        }
    }

}
