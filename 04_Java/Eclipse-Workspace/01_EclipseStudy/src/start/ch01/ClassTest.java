package start.ch01;

public class ClassTest {

	public static void main(String[] args) {
//		메인에서 객체를 사용하기 위해서는 우선 생성부터
//		아래는 ClassCar 클래스의 car01 인스턴스. 클래스로 실제 생성된 객체를 인스턴스라고 한다.
		ClassCar car01 = new ClassCar("K9", "Yellow", 450);
		
//		변수자체는 객체를 생성한 파일이 가지고있는 메모리를 참조하는듯?
//		실제 객체는 heap 영역에 저장되고 변수에는 해당 객체로 갈 수 있는 메모리를 참조. 참조타입.
//		각 필드로의 접근은 JS의 객체와 동일.
		System.out.println(car01);
		System.out.println("car01 : " + car01.company + " / " + car01.model + " / " + car01.color + " / " + car01.speed + " / " + car01.maxSpeed);

		ClassCar car02 = new ClassCar("Roll", "Blue", 230);
		car02.color = "green";
		System.out.println("car02 : " + car02.company + " / " + car02.model + " / " + car02.color + " / " + car02.speed + " / " + car02.maxSpeed);

		ClassCar car03 = new ClassCar("Roll");
		System.out.println("car03 : " + car03.company + " / " + car03.model + " / " + car03.color + " / " + car03.speed + " / " + car03.maxSpeed);

		ClassCar car04 = new ClassCar(999);
		System.out.println("car04 : " + car04.company + " / " + car04.model + " / " + car04.color + " / " + car04.speed + " / " + car04.maxSpeed);
	}

}
