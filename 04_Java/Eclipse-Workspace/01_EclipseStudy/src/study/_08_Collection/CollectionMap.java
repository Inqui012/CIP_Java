package study._08_Collection;

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
		hasMap.put("키06", "0001");
		hasMap.put("키a", "0001");
		hasMap.put("키B", "0011");
		hasMap.put("키c", "0001");
		hasMap.put("키04", "0001");
		hasMap.put("키f", "0011");
		
//		키값을 알고있다면 .get(키값); 으로 해당 키값이 가지고 있는 값을 가져올 수 있지만 만약 모든 키를 순회해야 한다면
//		아래와 같은 .forEach() 구문을 사용한다. 람다식. Map 인터페이스는 literlator 를 상속하지 않아서 일반적인 for문 사용불가.
//		가장 나중에 넣은 값이 가장 먼저 나오네. 아니네? 항상 5부터 나오네 뭐지... 키값이 정렬이 되어있는것 같기도 하고???
		hasMap.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		
//		.forEach() 를 쓰지 않을경우 아래처럼 해시맵의 키를 Set 타입으로 받아올 수 있는 .KeySet(); 메소드를 사용할 수 있음.
		Set<String> keySetName = hasMap.keySet();
		for(String str : keySetName) {
			System.out.println(str);
		}
		
//		Iterator 객체를 이용해서 아래처럼도 쓸 수 있다.
		Iterator<String> keyIter = keySetName.iterator();
//		.hasNext(); 다음 순서에 객체가 존재하는지
		while(keyIter.hasNext()) {
			String str = keyIter.next();
			String num = hasMap.get(str);
		}
		
//		이외에도 .containsValue(); .containsKey(); .KeySet(); 같은 쓰기 좋아보이는 메소드가 있음.
//		이후로는 api 문서 참조.
	}
}
