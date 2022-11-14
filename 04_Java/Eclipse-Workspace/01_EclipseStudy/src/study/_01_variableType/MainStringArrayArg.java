package study._01_variableType;

public class MainStringArrayArg {

//	args = 프로그램을 실행할때 미리 값을 넣어줄 수 있는........변...수...?
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("not enough");
//			프로그램을 강제종료하는 메소드.
			System.exit(0);
		}
		String strNum01 = args[0];
		String strNum02 = args[1];
		int num01 = Integer.parseInt(strNum01);
		int num02 = Integer.parseInt(strNum02);
		
		System.out.println("01 : " + num01 + " / 02 : " + num02 + " / Add : " + (num01 + num02));
	}

}
