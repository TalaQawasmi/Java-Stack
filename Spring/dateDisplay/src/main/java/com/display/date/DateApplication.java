package com.display.date;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Controller
public class DateApplication {

    public static void main(String[] args) {

        SpringApplication.run(DateApplication.class, args);
    }
}
