package Self;

import java.util.Scanner;

public class GameTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println();
		CharCreate[] charList = new CharCreate[20];
		
		while(true) {
			System.out.println("---------------------------------------");
			System.out.println("1.생성 | 2.목록 | 3.전투 | 4.휴식 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택 > ");
			String MenuNum = scan.nextLine();
			switch(MenuNum) {
			case "1":
				for (int i = 0; i < charList.length; i++) {
					if(charList[i] == null) {
						charList[i] = new CharCreate(CharCreate.charNameSet(), CharCreate.charClassSet());
						break;
					}
				}
				break;
			case "2":
				for (int i = 0; i < charList.length; i++) {
					if(charList[i] != null) {
						System.out.println("---------------------------------------");
						System.out.println("캐릭터명 		: " + charList[i].charName);
						System.out.println("캐릭터직업 	: " + charList[i].charClass);
						System.out.println("캐릭터레벨 	: " + charList[i].charLv);
						System.out.println("캐릭터 현재 HP	: " + charList[i].charHP);
						System.out.println("캐릭터 현재 MP	: " + charList[i].charMP);
						System.out.println("---------------------------------------");
					}
				}
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

}
