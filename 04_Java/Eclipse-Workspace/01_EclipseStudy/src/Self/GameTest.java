package Self;

import java.util.ArrayList;
import java.util.Scanner;

public class GameTest {

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Char> charList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("---------------------------------------");
			System.out.println("1.생성 | 2.목록 | 3.전투 | 4.휴식 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택 > ");
			String MenuNum = scan.nextLine();
			switch(MenuNum) {
			case "1":
				charCreate();
				break;
			case "2":
				showCharList();
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				break;
			default :
				break;
			}
		}
	}
	
	public static void charCreate() {
		System.out.println("---------------------------------------");				
		System.out.print("캐릭터 이름 >	");
		String charName = scan.nextLine();
		System.out.println("---------------------------------------");
		System.out.println("1.검사 | 2.마법사 | 3.탱크 | 4.힐러");
		System.out.println("---------------------------------------");
		System.out.print("캐릭터 클래스 >	");
		String charClass = scan.nextLine();
		while(true) {
			switch(charClass) {
			case "1":
				charList.add(new Char_Fight(charName));
				break;
			case "2":
				charList.add(new Char_Mage(charName));
				break;
			case "3":
				charList.add(new Char_Tank(charName));
				break;
			case "4":
				charList.add(new Char_Heal(charName));
				break;
			default :
				System.out.print("다시 선택	> ");
				charClass = scan.nextLine();
				continue;
			}
			break;
		}
	}
	
	public static void showCharList() {
		for(int i = 0; i < charList.size(); i++) {
			System.out.println("---------------------------------------");
			System.out.println(charList.get(i).charName + " [LV." + charList.get(i).charLv + "]	/ 클래스 : " + charList.get(i).charClass);
			System.out.println("HP : " + charList.get(i).charHP + " / MP : " + charList.get(i).charMP);
			System.out.println("---------------------------------------");
		}
	}

}
