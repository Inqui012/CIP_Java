package study._04_exception;

// 리소스 = 컴파일 대상이 아닌 파일. .java로 끝나지 않는 모든 파일. ex) .xml, .html, .js, .css 등
// 자바 내부에서 리소스를 참조할 수 있는데 이경우 반드시 참조를 시작하면서 리소스를 읽어오고 참조가 끝나면 리소스를 닫는 구문이 필요.
// 보통은 프로젝트 폴더의 src / main / resources 폴더 안에 해당 파일들을 모아놓는다.
// 이 파일들은... 컴파일할때 .jar 형태로 루트 디렉토리에 위치....???
// 불러오는 방법이 코틀린이나 maven 등과 차이가 있는듯???

// AutoCloseable 자동으로 '닫는' 행동을 실행할 수 있게 해주는 자바의 인터페이스.
class ResourceA implements AutoCloseable{
	private String name;
	ResourceA (String name) {
		this.name = name;
		System.out.println("open resource : " + name);
	}
	String methodRead01 () {
		System.out.println("methodRead01 read resource : " + name);
		return "methodRead01 Return";
	}
	String methodRead02 () {
		System.out.println("methodRead02 read resource : " + name);
		return "methodRead02 Return";
	}
	
//	파일을 닫을때 실행할 메소드를 작성한다.
//	try문에서 객체를 열었기 때문에 try문이 끝남과 동시에 객체가 닫히면서 해당 메소드가 실행됨.
//	파일을 읽고 닫는건 catch 들어가기 전인듯. catch문에 있는 로그는 아래 메소드가 찍힌 다음에 찍힌다.
	@Override
	public void close() throws Exception {
		System.out.println("Close resource : " + name);
	}
}

public class AboutResource {
	public static void main(String[] args) {
//		ResourceA test02 = new ResourceA("test01");
//		try의 매개변수? 란에서 객체를 생성하면 '닫는' 구문이 없어서 오류가 남. 이경우에는 클래스에 인터페이스를 받아와야함.
//		try() 에 들어가있는건 내가 열고싶은 객체.
		try(ResourceA test01 = new ResourceA("test01")){
			String data01 = test01.methodRead01();
			String data02 = test01.methodRead02();
		} catch(Exception e) {
			System.out.println("error");
		}
	}

}
