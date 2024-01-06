package ru.kampaii.websockets.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import ru.kampaii.websockets.model.Message;

@Controller
@Slf4j
public class WebsocketsController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        log.info("got message {}", message);
        return Message.builder()
                .content("Hello, " + HtmlUtils.htmlEscape(message.getContent()) + "!")
                .build();
    }
}
