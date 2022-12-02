package study._08_thread;

import java.util.*;

// map 인터페이스 하위의 데이터는 key 와 value 로 구성되어 있고 key는 중복저장 불가능.
// key만 중복이 안될 뿐, 다른 key 에 저장되어 있는 값이 같을수는 있다.
public class CollectionMap {
	public static void main(String[] args) {
//		HashMap 키와 값으로 데이터를 저장하는 Map 컬렉션의 일종. 동기화를 지원하지 않음.
//		동기화를 사용하기 위해서는 HashTable 을 사용한다.
//		제네릭을 설정할경우 키의 제네릭, 값의 제네릭 두 종류를 선언해야함. 
		HashMap<String, String> hasMap = new HashMap<>();
		Hashtable<String, String> hasTable = new Hashtable<>();
		
//		.put(키, 값); 리스트의 .add와 비슷함. 지정한 키값을가지는 값을 저장한다.
//		만약 같은 키에 값을 두번 저장했다면 나중에 저장한 값으로 덮어씌움.
		hasMap.put("키01", "0001");
		hasMap.put("키01", "0011");
		hasMap.put("키02", "0001");
		hasMap.put("키03", "0001");
		hasMap.put("키04", "0011");
		hasMap.put("키05", "0001");
		
//		키값을 알고있다면 .get(키값); 으로 해당 키값이 가지고 있는 값을 가져올 수 있지만 만약 모든 키를 순회해야 한다면
//		아래와 같은 .forEach() 구문을 사용한다. 람다식. Map 인터페이스는 literlator 를 상속하지 않아서 일반적인 for문 사용불가.
		hasMap.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
//		이외에도 .containsValue(); .containsKey(); .KeySet(); 같은 쓰기 좋아보이는 메소드가 있음.
//		이후로는 api 문서 참조.
	}
}
