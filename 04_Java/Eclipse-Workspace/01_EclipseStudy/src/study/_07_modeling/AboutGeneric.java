package study._07_modeling;

// Generic 제네릭. 객체를 저장할대 데이터타입을 미리 결정하지 않고 데이터를 저장할 수있다.
// <T> 보통은 T로 표시하지만 A-Z 모두 사용가능. T라는 데이터타입이 아니라 아직 데이터타입이 정해지지 않았다는 의미.
// 매개변수 같은 느낌. 자리만 잡아놓고 실제 데이터타입은 해당 클래스나 배열을 생성할때 지정한 데이터타입이 자동으로 지정됨.
// 특정 클레스에 다른 클래스를 참조해서 저장하고 싶은데 저장할 클래스의 데이터타입이 결정되어 있지 않을때, 바뀔 가능성이 있을때.
// 제네릭에 입력하는 데이터타입은 해당 데이터타입을 생성할 수 있는 객체의 클래스명이나 인터페이스임.
// 따라서 primitive 타입의 데이터일경우 축약어인 int, char 등이 아닌 Integer, Character 인 wrapper 클래스를 사용.
// 쉼표 구분으로 제네릭 여러개를 사용할 수도 있...음?
// <> 안에 들어가는 문자들을 타입 파라메터라고 함.

class GenTest01<T>{
	public T content;
}
class GenTest02 {
	public int content;
}
class GenTest03<T, M> {
	public T contentT;
	public M contentM;
}

// 인터페이스에도 사용가능. 메소드에 제네릭을 사용할 경우에는 반환타입이나, 매개변수등에 사용함.
interface GenTest04<K>{
	public K method();
}
public class AboutGeneric {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
//		동일한 GenTest01 클래스를 다른 데이터타입으로 만들 수 있다.
		GenTest01<String> test01 = new GenTest01<String>();
		GenTest01<Integer> test02 = new GenTest01<Integer>();
		GenTest02 test03 = new GenTest02();
		
//		필드의 타입을 찍고싶었는데 Object 가 찍히네?? 제네릭 클래스를 만들면 생성할때 지정해도 전부 Object로 변환되는건가?
//		그런거 같기도 하고... 제네릭 안쓴 클래스는 똑같이 찍어와도 제대로 String이 찍히네
		System.out.println(test01.getClass().getField("content").getType().getName());
		System.out.println(test02.getClass().getField("content").getType().getName());
		System.out.println(test03.getClass().getField("content").getType().getName());
		
//		변수를 지정해보면 타입이 String 과 Integer 로 되어 있는걸 확인할 수 있음. 
		test01.content = "String?";
		test02.content = 100;
		System.out.println("==========");
		
//		.getGenericType(); 으로 해당 필드나 메소드에 사용되고 있는 제네릭이 어떤 타입인지 알려주는듯.
		System.out.println(test01.getClass().getDeclaredField("content").getGenericType());
		System.out.println(test01.getClass().getDeclaredField("content").getType().getName() + ", " + test01.content);
		System.out.println(test02.getClass().getDeclaredField("content").getType().getName() + ", " + test02.content);

//		타입파라메터가 여러개일 경우 해당 파라메터를 전부 채워줘야 생성이 가능함.
		System.out.println("==========");
		GenTest03<Integer, Character> test04 = new GenTest03<>();
		
	}
}
