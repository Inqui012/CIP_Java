package study._08_Collection;

import java.io.*;

// 파일과 디렉터리의 접근권한, 생성된 시간, 수정일자, 크기, 경로등의 정보등을 알아낼 수 있는 클래스.
// 메소드로 새로운 파일, 디렉터리 생성, 삭제, 이름변경등이 가능하다.
// File 과 Files 가 있는데 Files 가 File의 기능을 개선하고 정적메소드로 구성되어있는 클래스이다.
public class FileClass {
	public static void main(String[] args) throws IOException {
//		File 클래스. 생성자의 매개변수로 파일을 생성할 절대경로를 지정한다. 확장자가 없을경우 디렉토리를 지정하는듯.
//		여기서 생성을 하는건 아니고 그냥 밑준비를 하는 느낌?
		File dir = new File("C:/Temp/img");
		File file01 = new File("C:/Temp/file01.txt");
		File file02 = new File("C:/Temp/file02.txt");
		File file03 = new File("C:/Temp/file03.txt");
		
//		.exists() 메소드는 해당 객체로 지정한 경로가 존재하는지의 여부를 true/false 로 반환한다.
//		.mkdir(); 디렉토리를 생성하는 메소드. 생성되는 디렉토리는 객체에 지정한 경로를 참조하는것 같음.
		if(!dir.exists()) dir.mkdir();
//		.createNewFile(); 해당 객체에 지정된 파일명과 확장자로 파일을 생성함.
		if(!file01.exists()) file01.createNewFile();
		
		File tmp = new File("C:/Temp");
//		.listFiles(); 객체에 지정된 경로에 있는 파일의 목록을 File 형 배열로 가져온다.
		File[] contents = tmp.listFiles();
		for(File f : contents) {
//			.isDirecrot(); 읽어온 목록의 파일이 폴더인지 파일인지 판단함.
			if(f.isDirectory()) System.out.println(f.getName());
		}
	}
}
