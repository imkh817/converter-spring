# 스프링이 제공하는 기본 Formatter 👨🏻‍💻

스프링은 자바에서 기본으로 제공하는 타입들에 대해 수 많은 포맷터를 기본으로 제공한다.<br>
그런데 포맷터는 기본 형식이 지정되어 있기 때문에, 객체의 각 필드마다 다른 형식으로 포맷을 지정하기는 어렵다.<br>
스프링은 이런 문제를 해결하기 위해 애노테이션 기반으로 원하는 형식을 지정해서 사용할 수 있는 매우 유용한 포맷터 두 가지를 기본으로 제공한다.<br>
1. `@NumberFormat` : 숫자 관련 형식 지정 포맷터 사용, `NumberFormatAnnotationFormatterFactory` 
2. `@DateTimeFormat` : 날짜 관련 형식 지정 포맷터 사용, `Jsr310DateTimeFormatAnnotationFormatterFactory`

### 예제로 간단히 알아보자❗️<br>

**Account 객체 추가**<br>
[Account]()

**ControllerV4 추가**<br>
[ControllerV4]()

**View 추가**<br>
[formmater-form]()<br>
[formmater-view]()

## 실행 💻
컨트롤러에서 `Account account = new Account(1000000,LocalDateTime.now());`로 Account 객체를 생성해서 formatter-form으로 넘겨주었는데
잘 컨버티되서 화면에는 1,000,000 과 2024-02-07 02:09:07 나온다.

![formatter-form](https://blog.kakaocdn.net/dn/dIuAWM/btsEtlr0hsw/67YLrWDMbU5kUSuqvMz661/img.png)

## 정리 ✍🏻
**컨버터를 사용하든, 포맷터를 사용하든 등록 방법은 다르지만, 사용할 때는 컨버전 서비스를 통해서 일관성 있게 사용할 수 있다.**
