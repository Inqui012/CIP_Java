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
	
//	와일드카드 타입 파라메터. ? 로 타입을 범위지정가능?
//	아래처럼 메소드이 매개변수에 들어오는 제네릭의 타입파라메터에 들어올 수 있는 클래스를 제한할 수 있다.
//	T<? extends Number> t 는 변수 t 에 저장할 제네릭타입 T는 Number 와 Number 의 자식클래스만을 가질 수 있다고 상한제한하는것.
//	T<? super Number> t 는 반대로 자기자신인 Number 클래스와 Number 의 부모클래스만을 범위로 가질 수 있다. 하한제한이래.
//	T<?> t 로 지정하면 제네릭 T 에는 어떤 클래스던 들어올 수 있음을 표현함. 이거는 안쓰는거랑 똑같은거 아닌가?	
//	메소드에 와일드카드를 쓴다 -> 받아오는 클래스에 제네릭이 존재한다 -> 한가지 타입으로 형변환할수가 없다....같은?
//	그냥 T 쓰면 오류나고 제네릭을 가지고 있는 클래스명을 쓰니까 오류가 사라지네.... 이건 매개변수에 클래스 쓸때만 쓸수 있는걸까?
//	제네릭 여러개 쓸 수 있는것처럼 와일드카드도 여러개 쓸 수 있네.
//	메소드에서 이걸 쓰는건 매개변수의 제네릭타입을 바꾼것만으로는 메소드의 오버로드가 안되서 그런가봐.
//	하나의 객체에 제네릭을 사용해서 여러타입으로 만들 수 있는데 이것들 중에서 원하는것만 매개변수로 받는... 리턴타입으로도 쓸 수 있대.
	public void genMethod01(GenTest01<? extends Number> t) {
	}	
	
//	제네릭을 지정하지 않은 GenTest02 클래스에는 사용할 수 없다.
//	public void genMethod01(GenTest02<? extends Number> t) {
//	}	
	
//	제한이 상한, 하한제한이거 보면 지정한 Number의 아래 전부, 위 전부 로 인식하는것 같다. 아래 위를 같이 지정할수는 없나..?
	public void genMethod01(GenTest03<? extends Number, ? super Number> t) {
	}	
}
class GenTest02 {
	public int content;
//	메소드에 제네릭을 사용할경우 리턴타입에 지정하는 파라메터 T 와 매개변수의 타입을 일치시켜야 한다.
//	그러게 반환하는 타입이 T 니까 안에서 다른 값으로 계산한다고 해도 반환할때는 강제로 T 형으로 변형시켜야하네.
	public<T> T genericMethod(T t){
		return t;
	}
	
//	접근제한자 뒤에 오는 제네릭이 메소드에 적용되는 제네릭을 의미하는것인듯. 클래스 자체에 제네릭이 없어도 사용가능
//	반환타입을 일반 타입으로 하고 매개변수에만 제네릭을 사용할수도 있네.
//	숫자형 반환으로 하려고 들어온값을 비교해서 트라이 캐치로 해봤더니 더 간단한게 있네
	public<M> int genericMethod01(M m) {
		try {
			System.out.print("Param M m is : " + m.getClass().getTypeName());
			return (int) m;
		} catch(Exception e) {
			return -1;			
		} 
	}

//	제네릭을 상속받는다? 해당 메소드의 제네릭 M은 Number 라는 클래스에서 상속받아서 해당 Number의 자식클래스만을 제네릭으로 받아올 수 있게 제한이 됨.
//	이렇게 생성할경우 메소드를 호출할때 매개변수에 Number 의 자식클래스가 아닌 타입(String, char...) 을 넣으면 오류가 난다.
//	이렇게 하면 Number를 상속한 제네릭 M 객체를 사용하는거니 Number가 가지고 있는 메소드도 사용 가능...
//	상속이랑 다르게 Number 자식클래스가 가지고있는 필드랑 메소드는 쓸 수 없대... 딱 Number가 가지고 있는 필드, 메소드만 사용 가능한데
//	하지만 들어오는 제네릭이 만약 Number의 자식클래스이고 Number의 필드나 메소드를 자식클래스에서 오버라이딩 했으면 오버라이딩 된 자식의 코드를 쓸 수 있는 느낌.
	public<M extends Number> int genericMethod02(M m) {
		try {
			System.out.print("Param M m is : " + m.getClass().getTypeName());
			return (int) m;
		} catch(Exception e) {
			return -1;			
		} 
	}
//	반대는 안돼네. 정해지지 않은 데이터타입 M 으로 반환을 해야하는데 M 에 어떤게 들어올 줄 알고 return 문을 쓰냐 하는 느낌인가
//	강제로 형변환을 한다고 해도 형변환 자체가 불가능할 가능성도 있고.. 반환타입이 제네릭일경우에는 매개변수에 제네릭을 써야 뭘 하겠구나.
//	public<M> M genericMethod01(String str) {
//		return (M) 300;
//	}
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
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
//		동일한 GenTest01 클래스를 다른 데이터타입으로 만들 수 있다.
		GenTest01<String> test01 = new GenTest01<String>();
		GenTest01<Integer> test02 = new GenTest01<Integer>();
		GenTest02 test03 = new GenTest02();
		
//		필드의 타입을 찍고싶었는데 Object 가 찍히네?? 제네릭 클래스를 만들면 생성할때 지정해도 전부 Object로 변환되는건가?
//		그런거 같기도 하고... 제네릭 안쓴 클래스는 똑같이 찍어와도 제대로 int 찍히네
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
		System.out.println(test04.getClass().getGenericSuperclass());
		
		System.out.println("==========");
		System.out.println(test03.genericMethod("TEST"));
		System.out.println(test03.genericMethod(555));
		System.out.println("==========");
		System.out.println(" : " + test03.genericMethod01("TEST"));
		System.out.println(" : " + test03.genericMethod01(555));
		System.out.println(" : " + test03.genericMethod01(489.9999999));
		System.out.println(" : " + test03.genericMethod01('A'));
		System.out.println(" : " + test03.genericMethod01(true));
		System.out.println("==========");
//		메소드02 에는 Number 로 제한된 제네릭을 가지고 있기 때문에 이외의 값을 넣으면 오류가 나서 컴파일이 안됨.
//		System.out.println(test03.genericMethod02(true));
		System.out.println(" : " + test03.genericMethod02(555));
		System.out.println(" : " + test03.genericMethod02(84.22));
		
//		String 타입으로 생성한 GenTest01 test01 과 Integer 타입으로 생성한 GenTest01 test02.
//		genMethod01 에 들어가는 매개변수 GenTest01의 제네릭은 Number 상한제한 와일드카드이기 때문에 
//		String 형식인 test01 로는 메소드 호출이 불가능하다.
		test01.genMethod01(test02);
//		메소드 호출하면서 새로 객체를 생성할수도 있음.
//		test01.genMethod01(new GenTest01<Character>(true));
//		test01.genMethod01(test01);
	}
}
