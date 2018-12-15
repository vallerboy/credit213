package pl.oskarpolak.credit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @PostMapping("/")
    public  String userInput(Model model,
                             @RequestParam("salary")int monthIncome,
                             @RequestParam("bills")int monthOutcome,
                             @RequestParam("amountOfCredit")int requestedCredit,
                             @RequestParam("numberOfMonths") int requestedTime){
        model.addAttribute("gotCredit", (monthIncome - monthOutcome) * 0.7 > requestedCredit / requestedTime);
        return "main";
    }
}
