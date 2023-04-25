package com.example.EOI.chatnotif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;


@Controller
public class GreetingController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting  greeting(HelloMessage  message) throws Exception {

        Thread.sleep(2000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");

    }


    @MessageMapping("/private")
    public void sendToSpecificUser(@Payload PrivateMessage message) {

        System.out.println("HOLA EQUIPO");
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/specific", message);

    }





}
