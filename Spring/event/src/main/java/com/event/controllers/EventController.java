package com.event.controllers;

import com.event.models.Event;
import com.event.models.EventUser;
import com.event.models.State;
import com.event.services.EventService;
import com.event.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private UserService uService;
    @Autowired
    private EventService eService;

    public Long userSessionId(HttpSession session) {
        if(session.getAttribute("userId") == null)
            return null;
        return (Long)session.getAttribute("userId");
    }

    private String now() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    @GetMapping("")
    public String Index(@ModelAttribute("event") Event event, Model model, HttpSession session) {
        Long userId = this.userSessionId(session);
        if(userId == null)
            return "redirect:/";

        EventUser user = this.uService.findById(userId);
        model.addAttribute("usersStates", this.eService.allEventsWithState(user.getState()));
        model.addAttribute("otherStates", this.eService.allEventsNotState(user.getState()));
        model.addAttribute("user", user);
        model.addAttribute("now", now());
        model.addAttribute("states", State.States);
        return "/events/index.jsp";
    }

    @PostMapping("")
    public String Create(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session, @RequestParam Map<String,String> body) {
        if(result.hasErrors()) {
            Long userId = this.userSessionId(session);
            EventUser user = this.uService.findById(userId);
            model.addAttribute("usersStates", this.eService.allEventsWithState(user.getState()));
            model.addAttribute("otherStates", this.eService.allEventsNotState(user.getState()));
            model.addAttribute("user", user);
            model.addAttribute("now", now());
            model.addAttribute("states", State.States);
            return "/events/index.jsp";
        }
        this.eService.create(event);
        return "redirect:/events";
    }

    @GetMapping("/{id}")
    public String Show(@PathVariable("id") Long id, Model model, HttpSession session) {
        Long userId = this.userSessionId(session);
        EventUser user = this.uService.findById(userId);
        Event event = this.eService.findById(id);
        if(userId == null)
            return "redirect:/";
        if(event == null)
            return "redirect:/events";
        model.addAttribute("event", event);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        return "/events/show.jsp";
    }
    @PostMapping("/{id}/comment")
    public String Comment(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes redirs, HttpSession session) {
        Long userId = this.userSessionId(session);
        if(userId == null)
            return "redirect:/";
        if(comment.equals("")) {
            redirs.addFlashAttribute("error", "Comment must not be blank");
            return "redirect:/events/" + id ;
        }
        Event event = this.eService.findById(id);
        EventUser user = this.uService.findById(userId);
        this.eService.comment(user, event, comment);
        return "redirect:/events/" + id;
    }
    @GetMapping("/{id}/edit")
    public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
        Long userId = this.userSessionId(session);
        Event event = this.eService.findById(id);
        if(userId == null)
            return "redirect:/";
        if(event == null || !event.getPlanner().getId().equals(userId))
            return "redirect:/events";

        EventUser user = this.uService.findById(userId);
        model.addAttribute("event", event);
        model.addAttribute("states", State.States);
        model.addAttribute("userId", userId);
        model.addAttribute("user", user);
        return "/events/edit.jsp";
    }
    @PutMapping("/{id}")
    public String Update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
        if(result.hasErrors()) {
            Long userId = this.userSessionId(session);
            EventUser user = this.uService.findById(userId);
            model.addAttribute("event", event);
            model.addAttribute("states", State.States);
            model.addAttribute("userId", userId);
            model.addAttribute("user", user);
            return "/events/edit.jsp";
        }
        this.eService.update(event);
        return "redirect:/events";
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") Long id) {
        this.eService.delete(id);
        return "redirect:/events";
    }
    @GetMapping("/{id}/a/{choice}")
    public String ManageAttendeees(@PathVariable("id") Long id, @PathVariable("choice") String choice, HttpSession session) {
        Long userId = this.userSessionId(session);
        Event event = this.eService.findById(id);
        boolean isJoining = (choice.equals("join"));
        if(userId == null)
            return "redirect:/";

        EventUser user = this.uService.findById(userId);
        this.eService.manageAttendees(event, user, isJoining);

        return "redirect:/events";
    }
}
