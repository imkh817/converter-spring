package hello.typeconverter.controller;

import hello.typeconverter.type.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ControllerV2 {

    // String -> Student
    @RequestMapping("/test/converterV2/StringToStudent")
    public String testConverterV2(@RequestParam Student student){
        log.info("StringToStudent name={}",student.getName());
        log.info("StringToStudent age={}",student.getAge());
        return "success!";
    }
}
