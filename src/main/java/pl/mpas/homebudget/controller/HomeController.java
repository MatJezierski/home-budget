package pl.mpas.homebudget.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/","home"}) // dzięki temu wpisując nazwę strony, albo nazwę strony + home, wejdziemy na główną
    public String home() {
        logger.info("home()");
        return "home";
    }
}
