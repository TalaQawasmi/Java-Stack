package com.belt.exam.controllers;

import com.belt.exam.models.Review;
import com.belt.exam.models.Show;
import com.belt.exam.models.User;
import com.belt.exam.services.ReviewService;
import com.belt.exam.services.ShowService;
import com.belt.exam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ReviewsController {

    private ReviewService reviewService;
    private ShowService showService;
    private UserService userService;

    public ReviewsController(ReviewService reviewService, ShowService showService, UserService userService) {
        this.reviewService = reviewService;
        this.showService = showService;
        this.userService = userService;
    }

    @PostMapping("/shows/{id}/review")
    public String review(@Valid @ModelAttribute("review") Review review, BindingResult result, Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId == null) {
            flash.addFlashAttribute("error", "You have to be logged in!");
            return String.format("redirect:/shows/%d", id);
        }
        if(result.hasErrors()) {
            model.addAttribute("show", showService.findOneById(id));
            model.addAttribute("user", userService.findUserById(userId));
            return "showShow.jsp";
        } else {
            User u = userService.findUserById(userId);
            Show s = showService.findOneById(id);
            List<Review> reviews = s.getReviews();

            for(Review r: reviews) {
                if(r.getUser().getId() == u.getId()) {
                    flash.addFlashAttribute("error", "You have already reviewed this show!");
                    return String.format("redirect:/shows/%d", id);
                }
            }

            review.setId(null);
            Review newR = reviewService.create(review);

            if(s.getAvgRating() == null) {
                s.setAvgRating(newR.getRating()/1.0);
                showService.update(s);
            } else {

                Double sum = 0.0;
                for(Review r: reviews) {
                    System.out.println("rating: " + r.getRating());
                    sum += r.getRating();
                }

                sum += newR.getRating();
                System.out.println(sum);

                System.out.println("average: " + sum/(reviews.size() + 1));
                s.setAvgRating(sum/(reviews.size()+1));
                showService.update(s);
            }
            return String.format("redirect:/shows/%d", id);
        }
    }
}
