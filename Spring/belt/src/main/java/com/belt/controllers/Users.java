package com.belt.controllers;

import com.belt.models.Show;
import com.belt.models.User;
import com.belt.services.ShowService;
import com.belt.services.UserService;
import com.belt.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class Users {
    private final UserService userService;
    private final UserValidator userValidator;
    private final ShowService showService;

    public Users(UserService userService, UserValidator userValidator, ShowService showService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.showService = showService;
    }

    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId != null) {
            return "redirect:/shows";
        }
        return "index.jsp";
    }

    @RequestMapping(value="/users", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "index.jsp";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId",  u.getId());;
            return "redirect:/shows";
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {

        boolean isAuthenticated = userService.authenticateUser(email, password);
        if(isAuthenticated) {

            User u = userService.findByEmail(email);
            session.setAttribute("userId", u.getId());
            return "redirect:/shows";
        } else {
            model.addAttribute("error", "Invalid. Please try again.");
            return "index.jsp";
        }
    }

    @RequestMapping("/shows")
    public String home(HttpSession session, Model model, RedirectAttributes flash) {

        Long userId = (Long) session.getAttribute("userId");

        if(userId == null) {
            flash.addFlashAttribute("error", "You must be logged in");
            return "redirect:/login";
        }

        User u = userService.findUserById(userId);
        List<Show> shows = showService.findAll();
        model.addAttribute("user", u);
        model.addAttribute("shows", shows);
        return "dashboard.jsp";
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        return "redirect:/";
    }
}
