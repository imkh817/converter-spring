package hello.typeconverter.converter;

import hello.typeconverter.type.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToStudentConverter implements Converter<String,Student> {
    @Override
    public Student convert(String source) {
        log.info("source={}", source);
        String[] split = source.split(":");
        String name = split[0];
        Integer age = Integer.valueOf(split[1]);
        return new Student(name,age);

    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Student, ? extends U> after) {
        return Converter.super.andThen(after);
        /**
         * 현재의 Converter 객체를 다른 Converter 객체와 연결하여 새로운 변환 과정을 만들어낼 수 있도록 도와주는 역할을 한다.
         * 구체적으로 말하면, andThen 메소드는 현재의 Converter를 기존의 변환 후 새로운 변환을 수행하는 Converter와 연결하여 새로운 Converter를 반환한다.
         * 이를 통해 체인 형태로 여러 변환 과정을 순차적으로 적용할 수 있다.
         */
    }
}
