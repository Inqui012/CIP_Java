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
	
	Human (String name, int height, int age) {
		this.height = height;
		this.name = name;
		this.age = age;
	}
}

class Hum01 extends Human {	
//	source 메뉴에 자동생성 있음. 추상화 클래스에서 지정한 메소드를 오버라이딩하여 코드를 지정한다.
//	여러 자식클래스에서 동일한 이름으로 사용할 메소드를 추상화로 만들어놓고, 자식클래스에서 오버라이딩으로 자식에서 필요한 코드를 맞춰서 쓰는?
//	일단 틀을 만들어놓고 내용물은 나중에 만들어넣는.
	@Override
	public void say(String words) {
		System.out.println(words);
	}

	Hum01(String name, int height, int age, String words){
		super(name,height,age+10);
		say(words);
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
		Hum02 difWord = new Hum02("BBB", 20, 120, "Hello");
		
		System.out.println(plus10.name + ", " + plus10.height + ", " + plus10.age);
		System.out.println(difWord.name + ", " + difWord.height + ", " + difWord.age);
	}

}
