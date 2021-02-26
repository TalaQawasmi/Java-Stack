package com.belt.exam.controllers;

import com.belt.exam.models.Review;
import com.belt.exam.models.Show;
import com.belt.exam.models.User;
import com.belt.exam.services.ShowService;
import com.belt.exam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ShowsController {

    private ShowService showService;
    private UserService userService;

    public ShowsController(ShowService showService, UserService userService) {
        this.showService = showService;
        this.userService = userService;
    }
    @PostMapping("/shows")
    public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        }
        if(result.hasErrors()) {
            return "newShow.jsp";
        } else {
            Show s = showService.create(show);
            Long newShowId = s.getId();
            return String.format("redirect:/shows/%d", newShowId);
        }
    }

    @RequestMapping("/shows/new")
    public String newShow(Model model, @ModelAttribute("show") Show show, HttpSession session, RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        }
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
        return "newShow.jsp";
    }


    @RequestMapping("/shows/{id}")
    public String show(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash, @Valid @ModelAttribute("review") Review review, BindingResult result) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        }
        model.addAttribute("show", showService.findOneById(id));
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
        return "showShow.jsp";
    }

    @RequestMapping("/shows/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
        Show s = showService.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        } else if(userId != s.getUserOne().getId()) {
            flash.addFlashAttribute("error", "You are not allowed to edit this show!");
            return "redirect:/shows";
        }
        model.addAttribute("show", s);
        return "editShow.jsp";
    }
    @RequestMapping(value="/shows/{id}", method= RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
        Show s = showService.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        } else if(userId != s.getUserOne().getId()) {
            flash.addFlashAttribute("error", "You are not allowed to edit this show!");
            return "redirect:/shows";
        }

        showService.delete(id);
        return "redirect:/shows";
    }

    @RequestMapping("/shows/{id}/update")
    public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
        Show s = showService.findOneById(id);
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return "redirect:/";
        } else if(userId != s.getUserOne().getId()) {
            flash.addFlashAttribute("error", "You are not allowed to edit this show!");
            return "redirect:/shows";
        }

        if(result.hasErrors()) {
            return "editShow.jsp";
        } else {
            showService.update(show);
            return String.format("redirect:/shows/%d", id);
        }
    }




}

