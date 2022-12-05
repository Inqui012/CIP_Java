package study._08_Collection;

import java.util.*;

// Collection Framework.
// 자료구조를 바탕을 여러개의 객체를 효율적으로 추가, 삭제, 검색할 수 있는 기능들.
// 해당 기능을 편하게 이용할 수 있게 해주는 인터페이스와 클래스가 java.util 패키지에 담겨있다.
// 자료구조는 자료의 사용을 효율적으로 하기 위해 자료를 조직, 관리, 저장하는것을 말한다.

// Collection 인터페이스 list (arrayList, vector, linkedList, stack), set(hashSet, TreeSet) 등이 있고
// map 인터페이스에 hashmap hashTable treemap properties 가 있다.

// list 인터페이스 하위는 데이터의 순서를 유지하고 저장하게 되며 중복저장이 가능하다.
// Vector는 기본적으로 ArrayList 와 동일하며, 차이점으로는 멀티스레드 환경에서의 동시성을 제어하기 위한 동기화를 지원해준다는 점이다.
class VectorTestClass {
	private String subject;
	
	public VectorTestClass(int a) {
		this.subject = String.valueOf(a) + " th subject";
	}
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
}

public class CollectionList {
	public static void main(String[] args) {
//		순서를 저장하는 리스트형 데이터클래스들은 모두 List 인터페이스를 상속받은 관계이기 때문에 자동형변환으로 아래처럼 사용가능.
		List<String> superList = new LinkedList<>();
		Vector<VectorTestClass> vecList = new Vector<>();
		LinkedList<Integer> linkList = new LinkedList<>();
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			linkList.add(i);
			arrList.add(i);
		}
		
//		변수에 같은 인덱스번호에 있는 값을 저장하는 시간이 두 리스트 타입에서 차이가 난다.
//		ArrayList 는 인덱스 번호를 지정하면 바로 해당 인덱스의 데이터에 접근 가능하지만
//		LinkedList 의 경우는 해당 인덱스를 가지고있는 데이터까지는 순차적으로 주소값이 연결되어 있을 뿐이기 때문에
//		해당 인덱스를 가지는 주소까지 도달하기 위해 모든 데이터를 순회해야 한다.
//		따라서 데이터를 참조할때는 ArrayList > LinkedList
		long time1 = System.nanoTime();
		int a = arrList.get(99);
		long time2 = System.nanoTime();
		System.out.println("ArrayList idx 99 time : " + (time2 - time1));
		
		time1 = System.nanoTime();
		a = linkList.get(99);
		time2 = System.nanoTime();
		System.out.println("LinkedList idx 99 time : " + (time2 - time1));

//		데이터 구조의 중간에 새로운 데이터를 추가하거나 삭제할경우에는 LinkedList 의 성능이 더 좋음.
//		이유로는 ArrayList의 경우 우선은 해당 값을 추가/제거한 다음 뒤에 있는 모든 인덱스의 값을 하나씩 변경해야 하는 반면
//		LinkedList 는 단순히 해당 인덱스의 앞 뒤 데이터가 가지고 있는 이전,이후 주소값을 변경해주기만 하면 끝나기때문.
//		따라서 데이터의 추가/삭제의 경우 LinkedList > ArrayList 
		time1 = System.nanoTime();
		for(int i = 101; i < 200; i++) {
			arrList.add(22, i);
		}
		time2 = System.nanoTime();
		System.out.println("ArrayList Insert time : " + (time2 - time1));
		
		time1 = System.nanoTime();
		for(int i = 101; i < 200; i++) {
			linkList.add(22, i);
		}
		time2 = System.nanoTime();
		System.out.println("LinkedList Insert time : " + (time2 - time1));
		
//		두개의 스레드에서 동시에 같은 리스트에 값을 추가하고 있지만 Vector 는 동기화를 자동으로 지원해주기 때문에
//		알아서 한쪽이 참조하는동안은 다른쪽에서 접근할 수 없도록 해주기 때문에 각각 10번씩 기능을 실행한다.
//		ArrayList로 실행하면 동기화가 안되서 제대로 실행이 안됨.
		Thread thread01 = new Thread () {
			@Override
			public void run() {
				for(int i = 0; i <= 10; i++) {
					vecList.add(new VectorTestClass(i));
				}
			}
		};
		Thread thread02 = new Thread () {
			@Override
			public void run() {
				for(int i = 11; i <= 20; i++) {
					vecList.add(new VectorTestClass(i));
				}
			}
		};
		
		thread01.start();
		thread02.start();
		
		try {
//			.join() 은 해당 스레드들이 끝날때까지 메인 스레드를 정지시키는...메소드인가?
			thread01.join();
			thread02.join();
		} catch (Exception e) {
			
		}
		
//		위의 코드만 보면 병행으로 실행되는 01과 02의 스레드에서 추가한 각각 1000개의 객체, 총 2000의 객체를 가지는
//		vecList 의 사이즈 2000을 찍을거라 예상하지만, 스레드와는 별개로 진행하는 main 스레드에 있는 sysout 이 먼저 오기 때문에
//		결과적으로 아무런 객체도 가지고 있지 않은 초기 vecList 의 사이즈인 0 을 찍는다.
//		위처럼 try catch 문으로 .join 을 사용하면 제대로 수치가 찍힌다.
		System.out.println("VecList size : " + vecList.size());
//		for(VectorTestClass str : vecList) {
//			System.out.println(str.getSubject());
//		}		
	}
}
