package hello.typeconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ControllerV3 {

    @RequestMapping("/test/fommater/money")
    public String testControllerV3(@RequestParam Integer money){
        log.info("money = {}",money);
        return "fommater success!";
    }
}
