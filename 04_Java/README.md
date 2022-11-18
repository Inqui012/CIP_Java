# JAVA 8.
https://nadwey.eu.org/

### 인터넷 주소
IP = 숫자로 된 주소
도메인 = 영어로 된 주소
DNS(Domain Name System) 도메인으로 접속하면 맞는 IP를 찾아서 연결해줌.

### Port
pc가 각종 정보를 주고받는 통신통로. 기본 80(HTTP)이고 생략되있음. 443(HTTPS)

### CMD Teltet [ip 또는 도메인] [포트번호] 
해당 도메인의 포트가 접근가능한지 알 수 있음.
정상적으로 접근이 가능할경우 아무런 내용이 뜨지 않고, 불가능할경우 에러메세지가 출력됨.

### 프로세스의 메모리
* stack : 함수의 호출과 관계되는 지역/매개 변수가 저장되는 영역. 함수가 완료되면 소멸.
* heap : 사용자가 직접 관리하는 영역. 할당/해제가 동적
* data : 프로그램의 전역/정적 변수 저장. 프로그램이 끝나면 소멸.
* text/code : 프로그램의 코드가 저장.

### Arrays.sort();
```java
import java.util.Arrays;
Arrays.sort(배열, 시작할 인덱스, 끝낼 인덱스, 정렬조건);
```
배열을 간단하게 오름차순으로 정렬할 수 있음. 기존배열을 덮어씌움.

내림차순이나 다른 정렬조건을 사용하고 싶을경우는 아래와 같은 다른 메소드를 사용.
```java
import java.util.Collections;
Collections.reverseOrder();
```
### 배열.length
```java
int a = array.length;
```
배열의 길이를 정수로 반환. 마지막 인덱스번호 + 1 의 값을 가진다.

### 문자열.length();
```java
int a = String.length();
```
문자열 String의 길이를 정수로 반환. 띄어쓰기와 특수문자 포함. 

### 문자열.charAt();
```java
char a = String.charAt(인덱스번호);
```
문자열을 배열로보고 지정한 인덱스번호에 있는 문자를 문자형으로 반환.

### Arrays.copyOfRange();
```java
Arrays.copyOfRange(배열, 시작할 인덱스, 끝낼 인덱스);
```
지정된 배열을 지정한 위치에서 잘라내어 새 배열로 저장.
항상 그렇듯 끝낼 인덱스는 실제 끝내고싶은 위치의 인덱스 + 1 로 계산해야함.

### Arrays.stream();
```java
Stream<데이터타입> var = Arrays.stream(배열 / 콜렉션, 시작할 인데스, 끝낼 인덱스);
```
자바8에서 추가된 람다? 를 활용할 수 있는 기술.
배열과 콜렉션 인스턴스의 요소를 하나하나 꺼내어 다루는 방법.

### 문자열.replace(); / .replaceAll();
```java
문자열.replace(CharSequence target, CharSequence replacement);
문자열.replace(바꾸고싶은 문자열, 바꿀 문자열);
```
문자열에서 특정 문자열을 원하는 문자열로 바꾼다. 사용 받는 매개변수의 타입이 다르다.


```java
문자열.replaceAll(String regex, String replacement);
문자열.replaceAll(바꾸고싶은 문자열, 바꿀 문자열);
```
문자열에서 특정 문자열을 원하는 문자열로 바꾼다.
바꾸고싶은 문자열에 정규식을 사용 가능.

```java
문자열.replaceFirst(String regex, String replacement);
문자열.replaceAll(바꾸고싶은 문자열, 바꿀 문자열);
```
문자열에서 특정 문자열을 원하는 문자열로 바꾸지만 가장 처음으로 찾는 문자열만 바꾸고 나머지는 그대로 유지한다.
마찬가지로 문자열에 정규식 사용 가능.

