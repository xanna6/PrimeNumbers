package apiotrowska.primenumbers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( "/calculate")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("boundary", null);
        return "home";
    }

    @PostMapping
    public String findPrimeNumbers(@RequestParam("boundary") Integer upperBoundary) {
        System.out.println(upperBoundary);
        return "home";
    }
}
