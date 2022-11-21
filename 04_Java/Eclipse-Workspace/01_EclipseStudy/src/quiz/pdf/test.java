package quiz.pdf;

class Tire {
	public void run() {
		
	}
}

class SnowTire extends Tire {
	int a;
	SnowTire() {
		System.out.println("생성자");
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
}

public class test {

	public static void main(String[] args) {
		SnowTire st = new SnowTire();
		
		st.run();
	}

}
