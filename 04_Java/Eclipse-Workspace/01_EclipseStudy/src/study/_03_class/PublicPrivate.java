package study._03_class;

import quiz.Account;

//import quiz.Account;

public class PublicPrivate {
//	패키지 = 소스파일의 폴더. 같은 src 안에서라도 패키지가 다르면 다른 클래스로 인식한다.
//	보통 도메인(domain.com) 이 있는경우 이걸 역순으로 생성하는듯. => com.domain.projectName 형식으로.
//	폴더가 com > domain > projectName 으로 구성될테니 확실히 이게 관리하기 편하겟네
//	설정이 없을경우 dafault 라서 같은 패키지 내의 클래스는 문제없이 불러올 수 있지만
//	타 패키지의 클래스를 불러오려면 따로 import를 해줘야한다. 다른프로젝트는 불가능.
//	Account impTest = new Account();
//	다른 방법으로는 아래처럼 경로를 전부 지정해서 설정할 수 있는데 자주 안씀.
//	quiz.Account impTest01 = new quiz.Account();
	
//	접근제한자 = private < default < protected < public
//	오직 해당 클래스 내부 < 동일 패키지 내 < 동일 패키지 + 상속 클래스 < 모든 클래스
//	설정하지 않으면 기본으로 dafault 로 설정됨.
	
//	private 선언. 변수마 메소드를 외부에서 직접 접근하지 못하도록 설정한다.
//	값을 변경하려면 getter / setter 메소드를 사용한다. 파일 오른쪽클릭 source 메뉴에 generate 항목이 있음. 권장.
//	외부에서 값을 보고싶을때는 get메소드, 변경하고 싶을때는 set 메소드. 왜 굳이 이렇게 하지?
//	외부에서 접근할 수 없다 = 사용할 수 없다? 기본 생성자를 막아놓는다던가 특정 생성자를 직접 사용 못하게 하거나?
//	set 메소드는 함수니까 이 안에 for문이나 if문을 이용해서 변수에 넣을 값을 선별할 수 있네. 이건 확실히 쓸만한듯.
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num += num;
	}
	
	class InheritTest extends Account {
		InheritTest(String strNum, String strName, int bal) {
//			Account의 생성자를 거쳐야 하기 때문에 자식 클래스에서도 생성자를 똑같이 만들어서 super 형태로 보내야하네.
//			게다가 해당 생성자가 default 라 다른 패키지에서 못쓰니까 적어도 protected로 바꿔줘야 사용가능하고.
			super(strNum, strName, bal);
			testStr01 = "is this possible?";
//			일단 사용하는거에 오류는 안뜨는것 같은데 이걸 어떻게 찍어내지??? 실행에는 오류가 나네
			System.out.println(testStr01);
		}
	}
	
	public static void main(String[] args) {
		FinalType PublClass = new FinalType("test", "tttt");
//		testStr은 protected 속성이지만 같은 패키지 안에서 불러오므로 호출이 가능하다.
		System.out.println(PublClass.testStr);

		
//		같은 패키지에 있어서 이미 생성한 객체에 있는 변수이지만 private로 설정되어 있어서 여기서도 '안보임'
//		System.out.println(PublClass.testStr01);
		
//		다른 패키지에 있는 Account 클래스는 public 속성이라 불러오는것 까지는 가능한데
//		변수인 testStr01 은 protected 속성이라 같은 패키지가 아닌 이곳에서는 '보이지 않아' 라고 인식하네.
//		외부에서는 접근할 수 없다는게 이런소리인듯. 아예 없는것처럼 취급하는 느낌?
//		System.out.println(Account.testStr01);
		
	
		
	}

}
