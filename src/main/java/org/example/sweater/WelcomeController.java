package org.example.sweater;

import org.example.sweater.domain.Message;
import org.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WelcomeController
{
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String main(Map<String, Object> model)
    {
        Iterable<Message> messages = this.messageRepository.findAll();

        model.put("messages", messages);
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

    @PostMapping
    public String add(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        Message message = new Message(text, tag);
        this.messageRepository.save(message);

        Iterable<Message> messages = this.messageRepository.findAll();
        model.put("messages", messages);

        return "main";
    }
}
