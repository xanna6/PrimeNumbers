package apiotrowska.primenumbers.controller;

import apiotrowska.primenumbers.service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Validated
@RequestMapping( "/")
public class HomeController {
    private final PrimeNumberService primeNumberService;

    @Autowired
    public HomeController(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String findPrimeNumbers(@RequestParam("boundary") @NumberFormat(style= NumberFormat.Style.NUMBER)
                                               Integer upperBoundary, Model model) {
        System.out.println(upperBoundary);
        List<Integer> primeNumbers = this.primeNumberService.findPrimeNumbersLessThan(upperBoundary);
        System.out.println(primeNumbers);
        model.addAttribute("boundary", upperBoundary);
        model.addAttribute("result", primeNumbers);
        return "home";
    }
}
