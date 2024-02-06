package hello.typeconverter.controller;

import hello.typeconverter.type.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
@Slf4j
public class ControllerV4 {

    @GetMapping("/test/formmatv2/account")
    public String getAccount(Model model){
        Account account = new Account(1000000,LocalDateTime.now());
        model.addAttribute("account",account);
        return "views/formatter-form";
    }

    @PostMapping("/test/formmatv2/account")
    public String posttAccount(@ModelAttribute Account account){
        return "views/formatter-view";
    }
}
