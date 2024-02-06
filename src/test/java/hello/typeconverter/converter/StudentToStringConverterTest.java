package hello.typeconverter.converter;

import hello.typeconverter.type.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentToStringConverterTest {

    @Test
    void StringToStudent() {
        StringToStudentConverter stringToStudent = new StringToStudentConverter();
        Student convert = stringToStudent.convert("전우치:120");
        assertThat(convert).isEqualTo(new Student("전우치",120));
    }

    @Test
    void StudentToString(){
        StudentToStringConverter studentToStringConverter = new StudentToStringConverter();
        String student = studentToStringConverter.convert(new Student("홍길동", 100));
        assertThat(student).isEqualTo("홍길동:100");

    }
}