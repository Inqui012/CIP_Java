package study._08_thread;

import java.util.*;

//set 인터페이스 하위는 데이터의 순서가 유지되지 않고, 중복저장이 안된다.
public class CollectionSet {
	public static void main(String[] args) {
//		SET 인터페이스 하위의 모음들은 인덱스 번호를 가지지 않는다. 순서없이 그저 데이터의 모음일 뿐.
//		따라서 같은 값이라면 중복저장을 하지 않게됨. 논리적동등을 비교하는듯.
		Set<Integer> setHasSet = new HashSet<>();
		HashSet<Integer> hasSet = new HashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		
//		set은 값의 논리적동등을 비교하여 값을 저장하기 때문에 아래 다섯번의 add 에서 중복된 1은 한번만 저장이 된다.
//		따라서 출력하면 1, 2, 3 하나씩만 가지고 있음. null 값도 하나만 허용한다.
		hasSet.add(1);
		hasSet.add(1);
		hasSet.add(2);
		hasSet.add(1);
		hasSet.add(3);
		hasSet.add(null);
		hasSet.add(null);
		
		for(Integer i : hasSet) {
			System.out.println(i);
		}
	}
}
