package hello.typeconverter.controller;

import hello.typeconverter.type.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @RequestMapping("/test/converter")
    public String testConverter(@RequestParam Integer id){

        if(id == 10) return "문자 '10'이 숫자 10으로 변환되었습니다.";
        return "변환하지 못햇습니다.";
    }
}
