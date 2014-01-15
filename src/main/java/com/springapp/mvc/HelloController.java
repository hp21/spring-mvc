package com.springapp.mvc;

import javax.ws.rs.Produces;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
 @RequestMapping("/base")
public class HelloController {

    // @RequestMapping(method = RequestMethod.GET)
    @RequestMapping("/hello")
    public String printWelcome(ModelMap model) {
        System.out.println("*** Hahlo Ocsi ***");
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @ResponseBody
    @RequestMapping(value = "/helloforname", produces = "text/plain")
    public String addTitle() {
        System.out.println("**** Called ajax");
        return "QQRQ";
        // System.out.println("Name: "+ name);
        // return null;
    }
}