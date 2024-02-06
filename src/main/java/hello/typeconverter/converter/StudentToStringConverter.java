package hello.typeconverter.converter;

import hello.typeconverter.type.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StudentToStringConverter implements Converter<Student,String> {
    @Override
    public String convert(Student source) {
        log.info("source={}",source);
        return source.getName()+":"+source.getAge();
    }
}
