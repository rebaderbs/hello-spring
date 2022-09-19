package org.launchcode.hellospring.controllers;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //Modify your HelloController class to display a form on a GET request that asks the user for both their name and the language they would like to be greeted in
    @GetMapping("form")
    @ResponseBody
    public String helloLanguageForm()   {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method = 'post'>" +
                "<input type = 'text' name='name'/>" +
                "<select name='language' id='language-select'>" +
                "<option value=''>--Please choose a language--</option>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='swedish'>Swedish</option>" +
                "<option value='spanish'>Spanish</option>" +
                "</select>" +
                "<input type = 'submit' value='Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    //takes two arguments: name and language
    public String helloPost(@RequestParam String name, @RequestParam String language) {

        return createMessage(name, language);

    }

    public static String createMessage(String name, String language)    {
        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello";
        }
        else if (language.equals("french")) {
            greeting = "Bonjour";
        }
        else if (language.equals("italian"))    {
            greeting = "Bonjourno";
        }
        else if (language.equals("swedish"))    {
            greeting = "Hallå";
        }
        else if (language.equals("spanish"))    {
            greeting = "Hola";
        }

        return greeting + " " + name;
    }

}
