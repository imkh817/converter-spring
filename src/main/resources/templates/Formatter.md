# Formatter 👨🏻‍💻

### 이번엔 `Formatter`에 대해 알아보자 ❗️<br>
`Converter` 는 입력과 출력 타입에 제한이 없는, 범용 타입 변환 기능을 제공한다. <br>
하지만 일반적인 웹 애플리케이션 환경을 생각해볼때 불린 타입을 숫자로 바꾸는 것 같은 범용 기능 보다는 개발자 입장에서는
문자를 다른 타입으로 변환하거나, 다른 타입을 문자로 변환하는 상황이 대부분이다.<br>

### 예시 ✍🏻
- 화면에숫자를출력해야하는데, `Integer` `String` 출력시점에숫자 `1000` 문자 `"1,000"` 이렇게 1000 단위에 쉼표를 넣어서 출력하거나, 또는 `"1,000"` 라는 문자를 `1000` 이라는 숫자로 변경해야 하는 상황
- 날짜 객체를 문자인 `"2021-01-01 10:50:11"` 와 같이 출력하거나 또는 그 반대의 상황

**이럴때 Formatter를 사용하는 것이 유용하다 ‼️️<br>**

**Converter vs Formatter**
- `Converter` 는 범용(객체->객체)
- `Formatter` 는 문자에 특화(객체->문자, 문자->객체) + 현지화(Locale)

### 그럼 이제 Formatter를 만들어보자 ❗️<br>
스프링에서 제공하는 Formatter 인터페이스를 확인해보자.<br>
```java
public interface Printer<T> {
     String print(T object, Locale locale); // 객체를 문자로 변경
}
 public interface Parser<T> {
     T parse(String text, Locale locale) throws ParseException; // 문자를 객체로 변경
}
 public interface Formatter<T> extends Printer<T>, Parser<T> {
 }
```

숫자 `1000` 을 문자 `"1,000"` 으로 그러니까, 1000 단위로 쉼표가 들어가는 포맷을 적용해겠다. 그리고 그 반대도 처리해주는 포맷터도 적용해보겠다.<br>
**MyNumberFormat 추가**<br>
[MyNumberFormat]()

**테스트 코드로 실행**<br>
[Test Code]()<br>

![Test 결과](https://blog.kakaocdn.net/dn/baHxN1/btsExIlRYSB/azUZW1bteHnsJYwJK8nkh1/img.png)
테스트 코드 둘다 성공하였다.<br>

### 그럼 이제 내가 만든 Formatter를 Converter와 마찬가지로 Spring 내부에 등록해보자 ❗️

Converter와 마찬가지로 동일하게 WebConfig에 등록해주면 된다. 나는 나중에 다시 한번 더 공부할때를 위해서 따로 WebConfig2를 만들어 등록하겠다.<br>

**WebConfig2 추가**<br>
[WebConfig2]()

## 실행 👨🏻‍💻

**ControllerV3 추가**<br>
[ControllerV3]() <br>

http://localhost:8080/test/fommater/money?money=1,000 호출 <br>
![실헹 결과](https://blog.kakaocdn.net/dn/YkCxD/btsEy1Syf9L/gNqJSzkgMrxZeLxFYEeQqk/img.png)

실행 결과를 보면 로그가 잘 찍힌 것을 확인 할 수 있다!

