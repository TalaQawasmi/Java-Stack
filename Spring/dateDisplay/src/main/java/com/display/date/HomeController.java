package com.display.date;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String Index(Model model) {
        Date date = new Date();
        model.addAttribute("rightNow", date);
        return "index.jsp";
    }
    @RequestMapping("/{path}")
    public String DateTime(@PathVariable("path") String dt, Model model) {
        if(!dt.equals("date") && !dt.equals("time"))
            return "redirect:/";
        SimpleDateFormat dm = (dt.equals("date"))
                ? new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY")
                : new SimpleDateFormat("h:mm a");
        model.addAttribute("pathFormat", dm.format(new java.util.Date()));
        model.addAttribute("path", dt);
        return "datetime.jsp";
    }

}
