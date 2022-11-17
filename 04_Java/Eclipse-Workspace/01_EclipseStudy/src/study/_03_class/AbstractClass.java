package study._03_class;

abstract class Human {
	protected int age;
	public int height;
	public String name;
// 	추상화 메소드. 필드는 불가능하고 메소드만.
//	추상화 메소드가 있는 클래스도 반드시 추상화 키워드 abstract 를 설정해줘야 한다. 
//	메소드의 매개변수까지만 지정하고 코드는 지정하지 않고 코드는 이 추상화 클래스를 상속받는 자식개체에서 오버라이딩해서 생성.
//	메소드를 추상화로 선언하면 자식클래서에서 반드시 오버라이딩해야 에러없이 실행가능하다.
//	반드시 필요한 값? 메소드? 를 지정할때 좋을것 같은데.
	public abstract void say(String words);
	public void over () {
		System.out.println("overriding test");
	}
	
	Human (String name, int height, int age) {
		this.height = height;
		this.name = name;
		this.age = age;
		over ();
	}
}

class Hum01 extends Human {	
//	오버로드 = 같은이름 / 매개변수타입 갯수가 다른 하나의 메소드를 여러종류로 정의하는것
//	오버라이딩 = 같은이름 / 매개변수타임 갯수가 같은 하나의 메소드를 덮어씌움.
	
//	source 메뉴에 자동생성 있음. 추상화 클래스에서 지정한 메소드를 오버라이딩하여 코드를 지정한다.
//	오버라이딩 하려면 반환타입, 메소드이름, 매개변수의 타입과 갯수가 모두 같아야함. 이건 다른 오버라이드랑 같은듯.
//	여러 자식클래스에서 동일한 이름으로 사용할 메소드를 추상화로 만들어놓고, 자식클래스에서 오버라이딩으로 자식에서 필요한 코드를 맞춰서 쓰는?
//	일단 틀을 만들어놓고 내용물은 나중에 만들어넣는.
	@Override
	public void say(String words) {
		System.out.println(words);
	}

//	메소드의 오버라이드 abstract 아니어도 사용가능하고 super로 부모객체에 선언한 기본 메소드를 불러오는것도 가능.
	@Override
	public void over() {
		super.over();
		System.out.println("done overide");
	}

	Hum01(String name, int height, int age, String words){
		super(name,height,age+10);
		say(words);
		over();
	}
}

class Hum02 extends Human {
	@Override
	public void say(String words) {
		System.out.println("This is Second " + words);
	}
	Hum02(String name, int height, int age, String words) {
		super(name, height, age);
		say(words);
	}
}

public class AbstractClass {

	public static void main(String[] args) {
		Hum01 plus10 = new Hum01("AAA", 100, 20, "HELLO");
		System.out.println("-----------------------------");
		Hum02 difWord = new Hum02("BBB", 20, 120, "Hello");
		
		System.out.println(plus10.name + ", " + plus10.height + ", " + plus10.age);
		System.out.println(difWord.name + ", " + difWord.height + ", " + difWord.age);
	}

}
