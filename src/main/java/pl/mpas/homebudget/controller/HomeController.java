package pl.mpas.homebudget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","home"}) // dzięki temu wpisując nazwę strony, albo nazwę strony + home, wejdziemy na główną
    public String home() {
        return "home";
    }
}
