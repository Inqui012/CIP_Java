package study._03_class;

public class PublicPrivate {
//	패키지 = 소스파일의 폴더. 같은 src 안에서라도 패키지가 다르면 다른 클래스로 인식한다.
	
//	접근제한자 = private < default < protected < public
//	오직 해당 클래스 내부 < 동일 패키지 내 < 동일 패키지 + 상속 클래스 < 모든 클래스

//	private 선언. 변수마 메소드를 외부에서 직접 접근하지 못하도록 설정한다.
//	값을 변경하려면 getter / setter 메소드를 사용한다. 파일 오른쪽클릭 source 메뉴에 generate 항목이 있음. 권장.
//	외부에서 값을 보고싶을때는 get메소드, 변경하고 싶을때는 set 메소드. 왜 굳이 이렇게 하지?
//	외부에서 접근할 수 없다 = 사용할 수 없다? 기본 생성자를 막아놓는다던가 특정 생성자를 직접 사용 못하게 하거나?
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num += num;
	}
	
	public static void main(String[] args) {

	}

}
