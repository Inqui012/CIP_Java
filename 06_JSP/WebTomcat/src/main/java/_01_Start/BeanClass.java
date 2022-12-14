package _01_Start;

public class BeanClass {
	private int firstNum;
	private int secondNum;
	private String option;
	long result;	
	public long calcResult(){
		if(option != null) {
			switch (option) {
			case "+":
				return firstNum + secondNum;
			case "-":
				return firstNum - secondNum;
			case "*":
				return firstNum * secondNum;
			case "/":
				if(secondNum == 0) {
					return 0;
				}
				return firstNum / secondNum;
			case "%":
				return firstNum % secondNum;
			}
		}
		return 0;			
	}
	
//	빈으로 사용할 객체에는 반드시 getter / setter 가 있어야 하나?	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	
}
