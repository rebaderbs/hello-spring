package org.launchcode.hellospring.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";

    }


    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model)  {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

    //COMMENTED OUT MY OWN CODE BELOW SO IT'S EXACTLY LIKE CHRIS'
    //Modify your HelloController class to display a form on a GET request that asks the user for both their name and the language they would like to be greeted in
//    @GetMapping("form")
//    @ResponseBody
//    public String helloLanguageForm()   {
//        return "<html>" +
//                "<body>" +
//                "<form action='/hello' method = 'post'>" +
//                "<input type = 'text' name='name'/>" +
//                "<select name='language' id='language-select'>" +
//                "<option value=''>--Please choose a language--</option>" +
//                "<option value='english'>English</option>" +
//                "<option value='french'>French</option>" +
//                "<option value='italian'>Italian</option>" +
//                "<option value='swedish'>Swedish</option>" +
//                "<option value='spanish'>Spanish</option>" +
//                "</select>" +
//                "<input type = 'submit' value='Greet me!'/>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }
//
//    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    //takes two arguments: name and language
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//
//        return createMessage(name, language);
//
//    }
//
//    public static String createMessage(String name, String language)    {
//        String greeting = "";
//
//        if (language.equals("english")) {
//            greeting = "Hello";
//        }
//        else if (language.equals("french")) {
//            greeting = "Bonjour";
//        }
//        else if (language.equals("italian"))    {
//            greeting = "Bonjourno";
//        }
//        else if (language.equals("swedish"))    {
//            greeting = "Hallå";
//        }
//        else if (language.equals("spanish"))    {
//            greeting = "Hola";
//        }
//
//        return greeting + " " + name;
//    }

}
