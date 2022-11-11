package start.ch02;

public class StringMethod {

	public static void main(String[] args) {
		String ssn = "9212032222222";
//		.charAt(인덱스번호); 스트링의 글자를 인덱스로 나눠서 지정한 인덱스에 맞는 문자를 가져온다.
		char sex = ssn.charAt(6);
//		js와 동일하게 문자열의 길이를 출력한다.
		int length = ssn.length();
		
		if (length == 13) {
			System.out.println("correct");			
		} else {
			System.out.println("incorrect");
		}
		
//		스위치문 case 를 아래처럼 중복해서 사용할 수도 있네.
		switch (sex) {
		case '1' : 
		case '3' : 
			System.out.println("male");
			break;
		case '2' :
		case '4' :
			System.out.println("female");
			break;
		}
		
//		.replace("변경하고싶은 문자열", "변경할 문자열"); 리턴값이 문자열인 함수.
//		새로운 문자열 객체를 생성해서 리턴해준다고 생각하면 되려나.
		String oldStr01 = "Java String";
		String newStr01 = oldStr01.replace("Java", "English");
		System.out.println(newStr01);
		
//		.substring(시작할 인덱스번호, 끝나는 인덱스번호+1); 문자열을 인덱스번호에 따라 잘라낸다. 새로운 문자열.
//		끝나는 인덱스번호는 js와 동일하게 해당 인덱스번호 이전까지이니 주의필요. 끝 인덱스가 없을경우 지정된 시작부터 끝까지.
		String subStr01 = oldStr01.substring(0, 6);
		System.out.println(subStr01);
		
//		.indexOf("찾을 문자열", 찾기시작할 인덱스번호); 지정된 문자열과 일치하는 위치의 시작하는 인덱스번호를 리턴한다.
//		일치하는 문자열이 없을경우 -1 을 리턴. 문자열을 찾아낼때 많이 사용하는듯.
		int idxOfStr01 = oldStr01.indexOf("String");
		System.out.println(idxOfStr01);
		
//		.contains("문자열"); 지정한 문자열을 포함하고 있는지 true / false 로 반환. 대소문자 구분함.
		boolean contStr01 = oldStr01.contains("Java");
		System.out.println(contStr01);
		
		String str01 = "23, JAVA, studing now";
//		String을 배열로 선언할 수 있다.
//		.split("기준이 되는 문자열"); 기준을 기반으로 문자열을 잘라내어 배열형태로 저장한다.
		String[] splitStr01 = str01.split(", ");
		for (int i = 0 ; i < splitStr01.length; i++) {
			System.out.println(splitStr01[i]);
		}
		
	}

}
