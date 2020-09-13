package org.example.sweater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WelcomeController
{
    @GetMapping
    public String main(Map<String, Object> model)
    {
        model.put("something", "something");
        return "main";
    }

    @GetMapping("/welcome")
    public String welcome(
            @RequestParam(defaultValue = "Mister Robot") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "welcome";
    }
}
