# Converter 👨🏻‍💻

이번엔 Converter에 대해 알아보자 ❗️<br>
나는 학원을 다니고 프로젝트를 해보면서 자동으로 타입 변환을 해준다는 것을 알고 있었지만, 정확히 어떤 원리에 의해 타입 변환이 되는지 몰랐다.
이번엔 스프링에서 어떤 기능을 제공해주기 때문에 자동으로 타입 변환이 가능한지 확인해보고 내가 직접 정의해서 타입을 만들어 볼 것이다!

예시 컨트롤러를 추가해보자.<br>
[예시 Controller](https://github.com/imkh817/converter-spring/blob/master/src/main/java/hello/typeconverter/controller/Controller.java)

예시 컨트롤러에는 간단히 GET 방식으로 아이디 값을 입력하고, 그걸 Integer형으로 변환해서 보여주는 코드를 짰다.

결과 ✅

![결과](https://blog.kakaocdn.net/dn/VMVaW/btsEtiWdA4i/lxPrzEjp6Qk3AmUPOvwe6K/img.png)

URL을 보면 converter?id=10으로 넘겼지만 이 부분은 String 형태로 값이 전달되었다.   <br>
하지만 @RequestParam 애노테이션으로 값을 받으면서 자동으로 Integer형태로 값이 변환되었다.<br>
참고로 `@RequestParam`, `@ModelAttribute`, `@PathVariable` 모두 마찬가지로 `자동 타입 변환을 해준다.`<br>

### 이렇게 Spring은 개발자를 위해 다양한 타입 변환을 해준다. 
### 그런데 만약 개발자가 새로운 타입을 만들어서 변환하고 싶으면 어떻게 할까 ❓

이 또한 Spring 에서 확장 가능한 `컨버터 인터페이스`를 제공한다.

```java
 package org.springframework.core.convert.converter;
 public interface Converter<S, T> {
     /**
      * S -> T로 변환하는 코드 작성
      */
   T convert(S source);
}
```

개발자는 스프링에 추가적인 타입 변환이 필요하면 이 `컨버터 인터페이스를 구현해서 등록`하면 된다.

한번 직접 만들어 보자!

## 사용자 정의 타입 컨버터 ✍🏻

**타입 변환 시킬 객체 추가** <br>
[Student](https://github.com/imkh817/converter-spring/blob/master/src/main/java/hello/typeconverter/type/Student.java)

**사용자 정의 타입 컨버터 추가**<br>
[StringToStudentConverter](https://github.com/imkh817/converter-spring/blob/master/src/main/java/hello/typeconverter/converter/StringToStudentConverter.java) **String -> Student**<br>
[StudentToStringConverter](https://github.com/imkh817/converter-spring/blob/master/src/main/java/hello/typeconverter/converter/StudentToStringConverter.java) **String -> Student**<br>

**테스트 코드로 실행**<br>
[TestCode](https://github.com/imkh817/converter-spring/blob/master/src/test/java/hello/typeconverter/converter/StudentToStringConverterTest.java)<br>

![TestCode 성공](https://blog.kakaocdn.net/dn/b5c64Q/btsEy1kHZDe/pumKNenTFUAAK6nAbjTJI0/img.png)

테스트 코드 둘다 성공하였다.

### 그런데 이렇게 컨버터를 하나하나 직접 사용하면, 사실 그냥 Controller에서 코드로 처리하는 것과 다름이 없다.
### 그래서 스프링은 개별 컨버터를 모아두고 그것들을 묶어서 편리하게 사용할 수 있는 기능인 `ConversionService` 제공한다.

**ConversionService 인터페이스**
```java
 package org.springframework.core.convert;
 import org.springframework.lang.Nullable;
 public interface ConversionService {
     boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);
     boolean canConvert(@Nullable TypeDescriptor sourceType, TypeDescriptor targetType);
     <T> T convert(@Nullable Object source, Class<T> targetType);
     Object convert(@Nullable Object source, @Nullable TypeDescriptor sourceType, TypeDescriptor targetType);
}
```
ConversionService 인터페이스는 `컨버티가 가능한지 확인하는 기능`과 `컨버티 기능`을 제공하는 것을 볼 수 있다.

그럼 이제 컨버터를 Spring에 등록해보자 ❗️<br>
참고로 Spring 내부에서 ConversionService 제공하기 때문에 우리는 등록만 하면 된다 ❗️<br>

**ConversionService에 컨버터 등록**<br>
[Spring내의 ConversionService에 컨버터 등록](Webconfig)<br>
- `WebMvcConfigurer` 가 제공하는 `addFormatters()` 를 사용해서 추가하고 싶은 컨버터를 등록하면 된다. <br>
- 이렇게 하면 스프링은 내부에서 사용하는 `ConversionService` 에 컨버터를 추가해준다.<br>

## 실행 👨🏻‍💻

**ControllerV2 추가**<br>
[ControllerV2](https://github.com/imkh817/converter-spring/blob/master/src/main/java/hello/typeconverter/controller/ControllerV2.java)<br>
http://localhost:8080/test/converterV2/StringToStudent?student=전우치:120 호출<br>

![실행 결과](https://blog.kakaocdn.net/dn/djEoqo/btsEyvl3mvR/kdsgOH3CUcWPOtCerzy1Uk/img.png)<br>

실행 결과를 보면 로그가 잘 찍힌 것을 확인 할 수 있다!