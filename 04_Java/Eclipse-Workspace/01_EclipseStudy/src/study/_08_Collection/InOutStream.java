package study._08_Collection;

import java.io.*;

// 입력 : 데이터를 읽어오는 것. / 출력 : 데이터를 써내는것
// 바이트 스트림 : 그림, 멀티미디어, 문자등 모든 종류의 데이터를 입출력 할 때 사용하는 스트림.
// 입력일경우 InputStream, 출력일경우 OutputStream 을 가지는 클래스로 구분된다.
// 문자 스트림 : 문자만 입출력 할때 사용함.
// 입력일경우 Reader, 출력일 경우 Writer 를 가지는 클래스로 구분됨.
public class InOutStream {
	public static void main(String[] args) {
		try {
//			FileOutputStream = 출력물을 파일로 내보내는듯?
//			생성자의 매개변수에 작성한 파일명과 확장자, 절대경로를 입력.
			FileOutputStream foStream = new FileOutputStream("C:/Temp/FileOutTest01.db");
			byte a = 10;
			byte b = 20;
			int c = 300;
			byte[] d = {5, 15, 25, (byte) 400};
			
//			OutputStream 은 모두 buffer 를 가지고 있는데 들어오는 값을 차례로 저장하고, buffer가 꽉 찰경우 순서대로 출력한다.
//			OutputStream 의 write(); 의 경우 1byte씩을 buffer 에 입력한다. 아직 출력이 아님.
//			.write(); 의 기본 매개변수 타입은 int형이지만 어쨌든 buffer 에 들어가는건 1byte 씩이다.
//			이외에도 byte의 배열형을 넣거나, 해당 배열의 인덱스를 지정해서 buffer에 넣을 범위를 지정할 수 있음.
//			int형으로 1byte(8bit) 를 넘어가는 숫자 300를 넣으면 C 에 들어갈 데이터는 100101100 (9bit) 라서
//			8bit 에 맞추어서 00101100 과 1 로 들어가버리는듯? 아니네 넘치는 bit 는 전부 버리나?
			foStream.write(a);
			foStream.write(b);
			foStream.write(c);
//			byte 형 배열을 만들경우 .write(); 를 사용하면 배열의 모든 요소가 쭉 buffer로 입력된다.
//			배열입력의 경우 매개변수로 시작할 인덱스, 끝낼 인덱스를 지정할 수 있음. 
//			여기서는 특이하게 입력한 끝나는 인덱스를 포함시켜주네. 보통은 앞에서 자르더니만.
			foStream.write(d, 1, 2);
			
//			.flush(); buffer 에 들어가있는 데이터들을 실제로 출력을 한 뒤 buffer를 깨긋하게 비운다.
			foStream.flush();
//			.close(); 스트림을 닫고 메모리를 해제한다. 안하면 메모리를 낭비하게됨.
			foStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			FileInputStream 위와 반대로 외부의 파일을 읽어오는 객체. 매개변수로 읽어올 파일의 절대경로를 입력한다.
			FileInputStream fiStream = new FileInputStream("C:/Temp/FileOutTest01.db");
			while(true) {
				byte[] maxData = new byte[100];
//				.read(); 가져온 파일의 데이터를 1byte씩 읽는다.
//				while문과 같이 쓰는이유는 .read(); 를 하는도중 데이터에 더 이상 읽을 byte 가 없을경우 -1 을 리턴하기 때문에.
//				위에서 넣은 300은 쪼개져서 들어갔기 때문에 쪼개진 2진법 8bit 00101100 = 44 가 찍힌다.
//				길이 100을 가진 바이트배열을 지정하고 .read()의 매개변수에 해당 배열을 입력하게 되면
//				최대 지정한 배열의 길이만큼을 읽어들어 몇번 읽어들었는지의 횟수를 리턴한다.
//				이경우 데이터를 출력하기 위해서는 따로 for문을 사용하여 maxData의 인덱스로 읽어들어야 함.
				int data = fiStream.read(maxData);
				if(data == -1) {
					break;
				}
				for(int i = 0; i < data; i++) {
					System.out.println(maxData[i]);
				}
				System.out.println(data);
			}
			fiStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
