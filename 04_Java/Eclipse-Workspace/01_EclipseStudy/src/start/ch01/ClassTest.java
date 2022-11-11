package start.ch01;

public class ClassTest {

	public static void main(String[] args) {
//		메인에서 객체를 사용하기 위해서는 우선 생성부터
//		아래는 ClassCar 클래스의 car01 인스턴스. 클래스로 실제 생성된 객체를 인스턴스라고 한다.
		ClassCar car01 = new ClassCar();
		
//		변수자체는 객체를 생성한 파일이 가지고있는 메모리를 참조하는듯?
//		실제 객체는 heap 영역에 저장되고 변수에는 해당 객체로 갈 수 있는 메모리를 참조. 참조타입.
//		각 필드로의 접근은 JS의 객체와 동일.
		System.out.println(car01);
		System.out.println("car01 : " + car01.company + " / " + car01.model + " / " + car01.color + " / " + car01.speed + " / " + car01.maxSpeed);

		ClassCar car02 = new ClassCar();
		car02.color = "green";
		System.out.println("car02 : " + car02.company + " / " + car02.model + " / " + car02.color + " / " + car02.speed + " / " + car02.maxSpeed);
	}

}
