package com.ninjagold.ninjagold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class NinjaGold {
    public ArrayList<String> activities = new ArrayList<>();
    @RequestMapping("/")
    public String main(HttpSession session){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold",0);
        }
        return "main.jsp";
    }
    @RequestMapping("/")
    public String function(@RequestBody() String postData, HttpSession session){
        if (session.getAttribute("gold") == null){
            session.setAttribute("gold",0);
        }
        String location = postData.substring(0,postData.indexOf("="));
        Random some = new Random();
        int gold = (int)session.getAttribute("gold");
        int x = 0;
        String text = "You earned from";
        switch (location){
            case "farm":
                x = some.nextInt(10)+10;
                break;
            case "cave":
                x = some.nextInt(5)+5;
                break;
            case "house":
                x = some.nextInt(3)+2;
                break;
            case "casino":
                x = some.nextInt(50);
                if(some.nextInt(2)==1)
                    x = -x;
        }
        gold += x;
        session.setAttribute("gold",gold);
        activities.add(text+location+"this golds"+x);

        System.out.println(gold+"");
        return "redirect:/";
    }

}
