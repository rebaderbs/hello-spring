package org.launchcode.hellospring.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller 
@RequestMapping("hello")
@ResponseBody
public class HelloController {

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //lives at /hello
//    @GetMapping("")
//    public String hello()   {
//        return "Hello, Spring!";
//    }
//
//    @PostMapping("goodbye")
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }

//    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, Request.POST})
//    public String hellogoodbye()    {
//        return "Hello. Goodbye!";
//    }

//    @GetMapping("")
//    public String hello()   {
//        return "Hello, Spring!";
//    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    //variable is part of the PATH, not the query string like above
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm()   {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method = 'post'>" +
                "<input type = 'text' name='name'/>" +
                "<input type = 'submit' value='Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
