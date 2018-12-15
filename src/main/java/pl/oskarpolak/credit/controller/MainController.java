package pl.oskarpolak.credit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private List<String> decision = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("creditDecision", decision);
        return "main";
    }

    @PostMapping("/")
    public  String userInput(Model model,
                             @RequestParam("salary")int monthIncome,
                             @RequestParam("bills")int monthOutcome,
                             @RequestParam("amountOfCredit")int requestedCredit,
                             @RequestParam("numberOfMonths") int requestedTime){
        boolean gotCredit =  (monthIncome - monthOutcome) * 0.7 > requestedCredit / requestedTime;
        addDecisionToList(gotCredit);


        model.addAttribute("gotCredit", gotCredit);
        model.addAttribute("creditDecision", decision);
        return "main";
    }

    private void addDecisionToList(boolean gotCredit) {
        decision.add(LocalDateTime.now() + " " + gotCredit);
    }
}
