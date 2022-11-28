package study._06_reflectAnno;

import java.lang.annotation.*;
import java.lang.reflect.*;

// 어노테이션 = 코드에서 @ 로 작성되는 요소
// 컴파일시 사용되는 정보 = 자주쓰는 @override 등
// 빌드툴(gradle, maven...)이 자동생성하는 코드에 사용할 정보
// 실행시 특정기능을 처리할때 사용하는 정보
// 총 세가지 용도로 나눠서 사용할 수 있음.
// 새파일 만들기에 anno 전용 타입의 파일 생성 메뉴가 있음. 일반적으로는 그쪽을 사용해서 새 파일로 만든다.
// 어노테이션을 사용하기 위해서는 우선 정의부터. 클래스 만드는거랑 비슷한가.

// @Retention() 은 해당 어노테이션이 언제부터 적용되고, 언제까지 적용할것인지 기간을 지정한다.
// SOURCE = 컴파일할 때 적용 ~ 컴파일 후 제거
// CLASS = 메모리로 로딩할 때 ~ 로딩 후 제거
// RUNTIME = 파일을 실행할 때 ~ 실행중에는 계속 유지
@Retention(RetentionPolicy.RUNTIME)
// @Target() 은 어떤 대상에 어노테이션을 적용할것인지 지정하는 문구인듯. 어떤 대상에 사용할 것인지.
// ElementType으로 상세설정. ElementType 에서 사용할 수 있는것들은 아래와 같음. 여러개를 지정하고 싶을경우 단순히 , 구분
// TYPE = 클래스, 인터페이스, 열거타입(열거상수 Enum) / ANNOTATION_TYPE = 어노테이션
// FIELD = 필드 / CONSTRUCTOR = 생성자 / METHOD = 메소드 / LOCAL_VARIABLE = 로컬변수 / PAKCAGE = 패키지
@Target({ElementType.METHOD, ElementType.FIELD})
@interface PrintAnno {
//	어노테이션에도 필드를 선언할 수 있네 근데 선언방법이 좀 다르다.
//	테이터타입 키값(); 으로 선언하는듯. default 를 써서 기초값을 설정해줄 수 있다.
//	default 가 있을경우 어노테이션을 사용할때 해당 속성에 값을 넣어주지 않아도 작동할 수 있음.
	String value() default "-";
	int number() default 0;

}

class AnnoTestClassA {
	String str = "tttttt";
	AnnoTestClassA(){
		
	}
	
//	정의한 어노테이션을 사용하고 싶은 장소 위에 @어노테이션명 으로 선언해준다.
//	어노테이션에 값을 정의했다면 반드시 값을 넣어줘야 작동하나보지? 어노테이션에 default 선언해주면 괜찮아짐.
	@PrintAnno
	void methodA() {
		System.out.println("methodA called");		
	}
//	어노테이션을 주면서 정의한 키값이 있다면 ()안에 해당 키값에 넣을 값을 지정해줄 수 있다.
	@PrintAnno(value = "a", number = 1)
	void methodB() {
		System.out.println("methodB called");
	}
	void methodC() {
		System.out.println("methodC called");		
	}
}

public class Annotation {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AnnoTestClassA test01 = new AnnoTestClassA();
		Class refClass01 = test01.getClass();
		Method refMethod01 = refClass01.getDeclaredMethod("methodB", null);
		Method refMethod02 = refClass01.getDeclaredMethod("methodC", null);
//		.getAnnotation(어노테이션명.class); 지정한 어노테이션이 적용되어 있으면 해당 어노테이션이 가지는 값? 속성을 반환하고
//		만약 어노테이션이 없다는 null 을 돌려준다. 돌아오는 값이 어노테이션 자체이기 때문에 생성할때의 데이터타입을 해당 어노테이션으로 잡아주는듯.
//		만약 적용된 어노테이션이 복수이고 이 모든걸 가져오려면 .getDeclaredAnnotations(); 를 사용할 수 있다.
//		복수개이기 때문에 돌아오는 값은 어노테이션 타입의 배열임.
		PrintAnno annoTest = refMethod01.getAnnotation(PrintAnno.class);
		
		System.out.println(refClass01.isAnnotationPresent(PrintAnno.class));
		System.out.println("-----");
		System.out.println(refMethod01.getName());
//		.isAnnotationPresent(어노테이션명.class); 로 지정된 메소드, 필드, 클래스에 해당 어노테이션이 존재하는지 판별가능.
//		반환값은 true/false 의 boolean 값.
		System.out.println(refMethod01.isAnnotationPresent(PrintAnno.class));
		System.out.println(refMethod02.isAnnotationPresent(PrintAnno.class));
		
		System.out.println("-----");
		refMethod01.invoke(new AnnoTestClassA());
//		@Retention 을 설정해주지 않으면 작동하지 않음.
		printLine(annoTest);
	}
	public static void printLine(PrintAnno anno) {
		if(anno != null) {
			int number = anno.number();
			String value = anno.value();
			System.out.println(number);
			System.out.println(value);
		}
	}
}
