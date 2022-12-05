package study._08_Collection;

import java.awt.Toolkit;
import java.util.*;

// 스레드를 지원하는 클래스를 생성할경우 Thread 클래스를 상속받거나, Runnable 인터페이스를 상속받는 방법을 쓴다.
// 클래스 상속으로 Thread를 상속받을 경우 다중상속이 불가능하여 다른 클래스의 상속을 받지 못하기 때문에 보통 Runnable을 많이 쓰는듯.
class ThreadClass extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("thread02		1sec 	: " + getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
	}
}

class RunnableClass implements Runnable {
	@Override
	public void run() {
		int num;
		for (int i = 0; i < 5; i++) {
			System.out.println("thread03		2sec 	: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (Exception e) {

			}
		}
	}
}

class SingletonTest {
	private int num;
	private static SingletonTest instance = null;

	private SingletonTest() {
	}

	public static SingletonTest getInstance() {
		if (instance == null) {
			instance = new SingletonTest();
		}
		return instance;
	}

//	메소드에 lock 을 건다고 표현. 한번에 하나의 스레드만이 해당 메소드나 변수에 접근할 수 있도록 제한하는것. 동기화를 건다?
//	동시성문제는 해결할 수 있지만 스레드가 해당 메소드나 변수를 참조하는동안 다른 스레드는 대기상태가 되기때문에 병렬성이 낮아짐.
//	lock을 변수에 걸기 위해서는 변수가 객체여야할 필요성이 있기 때문에 wrapper 클래스 사용해야함.
//	lock을 걸고 메인에서 똑같이 여러개의 스레드를 실행시키면 스레드가 순차적으로 실행되고 있는 상황이 보인다. 아닌듯?
	public synchronized int getNum() {
		return num++;
	}
//	동기화를 코드범위로 지정하고 싶을경우 synchronized(this){코드} 로 작성하면 가능하다.
}

public class AboutThread {
	public static void main(String[] args) {
//		Toolkit 비프음을 생성. 이외에도 특정 위치로 스크롤을 움직인다거나, 포커스를 옮긴다거나 하는등의 기능을 사용할때 생성.
		Toolkit tool = Toolkit.getDefaultToolkit();
		Thread thread01 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("thread01		3sec 	: ");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {

				}
			}
		});
		Thread thread02 = new ThreadClass();
		Thread thread03 = new Thread(new RunnableClass());
		Thread thread04 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("thread04		2sec 	: " + getName());
					try {
						Thread.sleep(2000);
					} catch (Exception e) {

					}
				}
			}
		};

//		소리와 글자가 동시에 나오게하려면 이렇게 하면 멀테스레드 기능이 실행되지 않는다.
//		for(int i = 0; i < 5; i++) {
//			비프음
//			tool.beep();
//			try {
//			스레드를 지정된 시간동안 대기상태로 돌린다. 밀리초 단위.
//				Thread.sleep(500);
//			} catch (Exception e) {
//				
//			}
//		}
//		다중 스레드를 만들때 스레드에 우선순위를 결정할 수 있다. Thread 클래스에 private로 지정되어 있는 int 변수가 있는데 이를 적용함.
//		우선순위를 지정하고 싶은 스레드객체에 setPriority() 메소드를 통해 지정 가능하고 범위는 1-10 이다.
//		기본적으로 순위는 모두 5이며 숫자가 상대적으로 높을수록 높은 우선순위를 가진다.
//		동시에 찍히는 3하고 4에서 3이 무조건 먼저 찍힐거라 생각했는데 그렇지도 않네???
//		아까는 .start(); 보다 뒤에 놨어서 그런가보다. 먼저 설정하고 실행하면 03보다 무조건 뒤에 찍힘.
//		아니네. 가끔 4가 먼저 찍히는 일도 있네.
		thread04.setPriority(1);
//		쓰레드의 이름을 정할 수 있는 메소드. 이것도 이름 자체는 private인가보지?
		thread03.setName("changed thread");

//		스레드를 사용할경우 자동으로 run() 메소드를 생성하고 그 메소드를 스레드에서 실행한다.
//		.start() 메소드가 해당 스레드의 run() 메소드를 실행한다.
//		.strat() 메소드가 실행되기 전에는 메모리에 스레드가 생성되기 않기 때문에 스레드에 관련된 코드를 실행하려면 이거 전에 해야하는듯.
//		실행하면 각각 다른 sleep 시간을 가지는 네개의 스레드가 실행되게 된다.
//		제일 처음에 찍히는 순서가 시작할때마다 바뀌는데 이걸로 쓰레드가 동시에 실행되면서도 서로 순서가 없다는걸 알 수 있음.
//		코드는 thread01 부터 시작하지만 각각의 스레드는 순서가 없이 그냥 동시에만 실행한다.
//		thread01.start();
//		thread02.start();
//		thread03.start();
//		thread04.start();		

//		for(int i = 0; i < 5; i++) {
//			System.out.println("main			0.5sec 	: " + Thread.currentThread().getName());
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				
//			}
//		}

//		유일한 객체인 싱글톤 객체를 참조해서 찍는 5개의 스레드를 생성하고 실행.
//		스레드가 실행되는 순서를 보면 같은 스레드에서 찍히는 번호가 연속되지 않고, 중간에 다른 스레드가 끼었을 경우
//		해당 스레드를 통과한 숫자에서 연속되는걸 볼 수 있다.
//		하나의 스레드가 5번 실행되는 도중에 또다른 스레드가 실행되고 있고, 복수의 스레드가 동시에 같은 .getNum() 메소드로
//		하나의 객체가 가지고 있는 int 값을 올리고 있다.
//		다섯개의 스레드가 가장 처음 시작하는 0번 째 프린트에서의 값이 동일한 0이 아니라 다 다른 값인걸 보면 알 수 있음.
//		이렇게 여러개의 스레드가 같은 객체를 참조하면서 스레드간의 간섭으로 값이 변동하는상황을 동시성이라고 하는듯?
//		이런 동시성을 제어하기 위해 사용하는것이 synchronized 라는 키워드인것같음.
//		SingletonTest onlyInstance = SingletonTest.getInstance();
//		for (int i = 0; i < 5; i++) {
//			new Thread() {
//				public void run() {
//					for (int i = 0; i < 5; i++) {
//						System.out.println(i + " 	: " + getName() + ", " + onlyInstance.getNum());
//					}
//				}
//			}.start();
//		}
		
//		동기화가 되지 않는 ArrayList를 두 스레드에서 동시에 참조하며 값을 add 하고 있다.
//		0부터 30, 51부터 80 까지의 값이 들어갈 것으로 예상이 되지만 실제로는 그렇지 않음.
//		으음...두번째 스레드가 79까지는 넣는것 같으니 첫번째 쓰레드가 하는 작업을 두번째 스레드가 몇번 덮어 씌워 버리는건가?
//		null 값이 들어가는건 뭘까...
		List<Integer> arrListTest = new ArrayList<>();
		Thread thread05 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 30; i++) {
					arrListTest.add(i);
				}
			}
		};
		Thread thread06 = new Thread() {
			@Override
			public void run() {
				for(int i = 51; i < 80; i++) {
					arrListTest.add(i);
				}
			}
		};

		thread05.start();
		thread06.start();
		try {
			thread05.join();
			thread06.join();
		} catch (Exception e) {
			
		}
		
		for(Integer num : arrListTest) {
			System.out.println(num);
		}
		System.out.println(arrListTest.size());
	}
}
