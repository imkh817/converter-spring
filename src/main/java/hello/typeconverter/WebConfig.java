package hello.typeconverter;

import hello.typeconverter.converter.StringToStudentConverter;
import hello.typeconverter.converter.StudentToStringConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToStudentConverter());
        registry.addConverter(new StudentToStringConverter());
    }
}
