package start.ch03;

public class Block {

	public static void main(String[] args) {
//		변수의 사용범위. var01 은 main 블록 안에서는 전부 사용가능. 지역변수.
//		var02 는 if문의 블록 안에서 선언되었기 때문에 밖에서는 접근이 불가능하다.
//		if문 안의 var02 와 밖의 var02 는 다른 변수로 생각되어서 같은 변수병이라도 두번 선언할 수 있고 가지고 있는 값도 다름.
		int var01 = 15;
		if (var01 > 10) {
			int var02 = var01 - 10;
			System.out.println(var02);
		}
		int var02 = 10;
		int var03 = var01 + var02 + 5;
		System.out.println(var03);
	}

}
