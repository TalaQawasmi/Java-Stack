package com.code.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class code {
    @RequestMapping("/")
    public String main(){
        return "index.jsp";
    }
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    public String codeCheck(@RequestParam(value = "code") String code, RedirectAttributes redirectAttributes){
        if (code.equals("bushido")) {
            return "code.jsp";
        }
        else{
            redirectAttributes.addFlashAttribute("error", "You must train harder!   ");
            return "redirect:/";
        }
    }

}
