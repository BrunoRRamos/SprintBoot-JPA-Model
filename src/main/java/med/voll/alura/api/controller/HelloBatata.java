package med.voll.alura.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batata")
public class HelloBatata {

    @GetMapping
    public String batata() {
        return "Batata";
    }
}
