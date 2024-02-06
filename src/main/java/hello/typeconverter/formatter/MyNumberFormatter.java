package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Number는 int,long,double 숫자 관련 자료형이 다 들어가있다.
 * Converter는 <S,T> 이런식으로 S -> T로 변환할 자료형을 적어주었지만,
 * Formatter는 기본으로 String으로 바꿔주기 때문에 바꿔줄 타입만 적어주면 된다.
 *
 * `"1,000"` 처럼 숫자 중간의 쉼표를 적용하려면 자바가 기본으로 제공하는 `NumberFormat` 객체를 사용하면 된다.
 * 이 객체는 `Locale` 정보를 활용해서 나라별로 다른 숫자 포맷을 만들어준다.
 * `parse()` 를 사용해서 문자를 숫자로 변환한다. 참고로 `Number` 타입은 `Integer` , `Long` 과 같은 숫자 타입의 부모 클래스이다.
 * `print()` 를 사용해서 객체를 문자로 변환한다.
 */
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        /**
         * text: 숫자로 변환할 문자열
         * locale: 숫자의 형식을 결정하기 위한 로케일
         *
         * NumberFormat instance = NumberFormat.getInstance(locale); -> 주어진 로케일(Locale)에 맞는 NumberFormat 인스턴스를 반환
         * instance.parse(text) -> 주어진 문자열을 해당 숫자 포맷에 맞게 파싱하여 숫자로 변환
         */
        log.info("text={},locale={}",text,locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        return instance.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        return NumberFormat.getInstance(locale).format(object);
    }

    /**
     * `"1,000"` 처럼 숫자 중간의 쉼표를 적용하려면 자바가 기본으로 제공하는 `NumberFormat` 객체를 사용하면 된다.
     * 이 객체는 `Locale` 정보를 활용해서 나라별로 다른 숫자 포맷을 만들어준다.
     * `parse()` 를 사용해서 문자를 숫자로 변환한다. 참고로 `Number` 타입은 `Integer` , `Long` 과 같은 숫자 타입의 부모 클래스이다.
     * `print()` 를 사용해서 객체를 문자로 변환한다.
     */
}
