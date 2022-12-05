package study._08_Collection;

import java.util.*;

//set 인터페이스 하위는 데이터의 순서가 유지되지 않고, 중복저장이 안된다.
public class CollectionSet {
	public static void main(String[] args) {
//		SET 인터페이스 하위의 모음들은 인덱스 번호를 가지지 않는다. 순서없이 그저 데이터의 모음일 뿐.
//		따라서 같은 값이라면 중복저장을 하지 않게됨. 논리적동등을 비교하는듯.
		Set<Integer> setHasSet = new HashSet<>();
		HashSet<Integer> hasSet = new HashSet<>();
		
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
		System.out.println("=============");
		
//		TreeSet 은 여전시 중복저장 안됨, 순서가 없지만 이름 그대로 나무처럼 데이터를 저장한다. 이진트리기반.
//		가장 기본이 되는 루트노드 가 존재하고 각 노드가 왼쪽, 오른쪽의 데이터를 가지고
//		루트에서부터 비교를 시작해서 낮을경우 왼쪽아래, 높을경우 오른쪽아래로 정렬하는 성질을 가진다.
//		데이터를 추가/삭제할경우에는 루트에서부터 비교를 시작해서 구조를 전부 변경해야 하기 때문에 시간이 걸린다.
//		검색에 유리한 데이터구조. TreeSet은 데이터를 저장할경우 기본적으로 오름차순으로 데이터를 정렬함.
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(7);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(1);
		treeSet.add(7);
		treeSet.add(8);
		treeSet.add(21);
		
//		단순이 뽑아보면 자동으로 오름차순으로 정렬되어있는 상태로 가져오는걸 알 수 있음.		
		for(Integer i : treeSet) {
			System.out.println(i);
		}
		System.out.println("=============");
//		.decendingSet(); 으로 해당 treeSet에 저장된 요소를 역순으로 정렬한다. 기본적으로 오름차순이니까 역순일경우 내림차순.
		for(Integer i : treeSet.descendingSet()) {
			System.out.println(i);
		}
		System.out.println("=============");
//		.first(); .last(); 가지고 있는 값들중에서 가장 낮은값, 가장 큰 값을 출력가능.
		System.out.println(treeSet.first() + ", " + treeSet.last());
//		.lower(); .higher(); 주어지는 기본값과 비교해서 가장 가까운 작은값, 높은값을 출력한다.
		System.out.println(treeSet.lower(5) + ", " + treeSet.higher(5));
//		.headSet(); .tailSet(); 주어지는 기본값과 비교해서 낮은 값, 높은값들의 모음을 전부 출력한다.
//		이걸로 반환받는 데이터는 Set 타입 데이터이고, 매개변수의 두번째에 true, false 지정 가능. 기본은 false.
//		true/false 는 지정된 값을 포함할지의 여부를 결정한다.
		System.out.println(treeSet.headSet(5) + ", " + treeSet.tailSet(5));
//		.subSet(객체1, 객체2); 지정한 두 객체 사이에 있는 모든 객체들을 Set 타입으로 리턴해준다.
//		각각의 값에 지정값을 포함/비포함 할지를 결정하는 true/false 값 지정 가능.
		System.out.println(treeSet.subSet(4, 8));
		System.out.println("=============");
	
	}
}
