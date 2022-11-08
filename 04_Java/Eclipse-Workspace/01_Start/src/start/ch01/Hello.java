package start.ch01;

public class Hello {
	// main 안의 코드가 가장 먼저 실행됨. 
	public static void main(String[] args) {
		// System.out.println(); = console.log();
		System.out.println("Hello");
		//변수가 메모리에 공간을 가지게 되는것은 변수에 값이 들어가는 순간.
		// int a; 상태에서는 메모리를 가지고 있지 않음.
		int a = 10;
		float b = 2.5f;
		// 변수는 반드시 초기화를 해 줘야 에러 없이 실행이 가능.	
		int num = 0;
		String init = null;
		
		System.out.println("ADD : " + (a+b));
		System.out.println("MINUS : " + (a-b));
		System.out.println("NUM : " + num);
		System.out.println("INIT : " + init);
	}

}
