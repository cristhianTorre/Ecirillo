package edu.eci.arsw.Controllers;

import edu.eci.arsw.Model.Message;
import edu.eci.arsw.Services.EcirilloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Ecirillo")
public class EcirilloController {

    @Autowired
    EcirilloServices es= null;
    @Autowired
    SimpMessagingTemplate msgt;

    @MessageMapping("/Ecirillo.{room}")
    public synchronized void handlePointEvent(Message message, @DestinationVariable String room) throws Exception{
        msgt.convertAndSend("/topic."+room, message);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllBlueprintFilter(){
        try {
            return new ResponseEntity<>(es.get(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public String index(){
        return "Greetings from Spring Boot!";
    }

}
