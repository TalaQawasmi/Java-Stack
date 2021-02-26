package com.counter.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class counter {
    @RequestMapping("/")
    public String main(HttpSession session){
        if(session.isNew()){
            session.setAttribute("counter",0);
        }
        else {
            Integer count= (Integer) session.getAttribute("counter");
            count += 1;
            session.setAttribute("counter",count);

        }
        return "index.jsp";
    }
    @RequestMapping("/counter")
    public String counter(){
        return "counter.jsp";
    }


}
