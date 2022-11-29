package study._07_modeling;

import java.util.Vector;

// 연관관계. 클래스가 서로를, 또는 일방적으로 한쪽을 참조하는 관계. 실선에 화살표
// 아래 AssoClassA 와 AssoClassB 는 서로가 서로의 객체를 생성해서 필드로 사용하기 때문에 이를 연관관계라고한다.
// AssoClassA 와 AssoClassB 는 서로가 서로를 각자 한번씩 참조하는 일대일 관계.
class AssoClassA {
	private AssoClassB assoClass01;
	private Vector<AssoClassE> assoClass08;
	AssoClassA(){
		System.out.println("AssoClassA create");
//		이거 서로의 생성자에서 서로를 생성하면 무한루프 도는거 아닌가 했는데 진짜 도네...
//		이렇게 쓰면 안되는게 맞는듯.
//		assoClass01 = new AssoClassB();
	}
}

class AssoClassB {
	private AssoClassA assoClass02;
	private Vector<AssoClassE> assoClass09;
	AssoClassB(){
		System.out.println("AssoClassB create");
//		assoClass02 = new AssoClassA();
	}
}

// 아리의 AssoClassC 는 AssoClassB 를 리스트형태로 저장하여 사용하기 때문에 여러개의 AssoClassB 를 참조한다고 본다.
// 따라서 아래의 경우에는 아마도 일대 다수의 관계? 이고 AssoClassB 에서는 AssoClassC를 참조하지 않기 때문에 단방향관계.
class AssoClassC {
//	Vector<> 는 ArrayList 랑 비슷한거래.
	private Vector<AssoClassB> assoClass03;
	private Vector<AssoClassD> assoClass05;
}

// 다대다 관계인 코드를 작성하기 위해서는 코드만으로는 잘 안되고 보통 DB에서 중간자 역할을 하는 공간을 따로 만드는듯?
// 아닌가. 어떻게 실행하는지는 애매하긴 해도. AssoClassC 를 배열형으로 여러개 참조하는 AssoClassD 와
// 똑같이 여러개의 AssoClassD를 참조하는 AssoClassC 는 서로 다대다관계.
class AssoClassD {
	private Vector<AssoClassC> assoClass04;
}

// 아래의 경우는 AssoClassE 가 AssoClassA 와 AssoClassB 를 다중참조하고있다. 
// AssoClassE 가 중간자가 되어서 여러개의 AssoClassA 와 AssoClassB 를 연결하는? 역할?
// 보통은 AssoClassE 의 정보가 AssoClassA 와 AssoClassB 의 데이터를 모두 취합해야 할 때 이런 형태가 되는듯.
// ex) 학생클래스와 교과클래스가 있을 때, 수강신청은 학생과 교과목 둘다 있어야 하기 때문에 두 정보를 취합하는 클래스를 따로 구성.
class AssoClassE {
//	AssoClassC 와 AssoClassD 는 애초에 서로를 다중참조하는 클래스여서 이렇게 해도... 되는가보네
//	AssoClassC 에는 애초에 AssoClassD 의 데이터가 배열형식으로 저장이 되어있고, AssoClassD도 마찬가지.
//	여기서는 굳이 배열형식으로 가져오지 않아도 참조하는 객체가 이미 배열을 가지고 있구나. 아니네.
//	변경.
//	AssoClassA 와 AssoClassB 의 중간자역할인 AssoClassE 니까, 이렇게 하고... 
//	AssoClassA 와 AssoClassB 에서 AssoClassE를 배열로 저장하고 있다.
//	E 에서 A 와 B의 정보로 산출한 값을 A 와 B 가 각각 자신이 가지고있는 E타입의 vector 에 저장하게되는형식.
//	A 와 B 에 E타입의 데이터를 매개변수로 받는 메소드가 있고, 이걸 A와 B를 매개변수로 가지는 E의 생성자에 선언해버림.
//	E의 생성자에서 A, B 의 메소드를 실행시키면 방금 생성된 E 가 넘어가면서 A, B 각각의 vector 배열에 E를 저장...?
	private AssoClassA assoClass06;
	private AssoClassB assoClass07;
}
public class Association {
	public static void main(String[] args) {
		AssoClassA test01 = new AssoClassA();
	}
}
