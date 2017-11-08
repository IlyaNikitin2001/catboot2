package catboot2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by USER on 06.11.2017.
 */
@Controller
public class mainController {
@GetMapping("/")
    public String main(){
        return "index";
    }
}
