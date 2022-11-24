package playAlone.smallGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

import playAlone.smallGame.character.*;
import playAlone.smallGame.enemy.*;

public class GameTest {

	public static Scanner scan = new Scanner(System.in);
	public static ArrayList<Char> charList = new ArrayList<>();
	public static String timeOut = scan.nextLine();

	public static void main(String[] args) {
		while (true) {
			clrscr();
			System.out.println("---------------------------------------");
			System.out.println("1.생성 | 2.목록 | 3.전투 | 4.휴식 | 5.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택 > ");
			String MenuNum = scan.nextLine();
			switch (MenuNum) {
			case "1":
				charCreate();
				break;
			case "2":
				showCharList();
				break;
			case "3":
				battleStart();
				break;
			case "4":
				restInn();
				break;
			case "5":
				System.exit(0);
			default:
				break;
			}
		}
	}

	public static void charCreate() {
		String charName = "";
		boolean flag = true;
		charNameLoop : while(flag) {
			System.out.println("---------------------------------------");
			System.out.print("캐릭터 이름 >	");
			charName = scan.nextLine();
			if(charList.size() == 0) {
				break;
			} else {
				for(int i = 0; i < charList.size(); i++) {
					if(charList.get(i).charName.equals(charName)) {
						flag = true;
						continue charNameLoop;
					} else {
						flag = false; 						
					}
				}
			}
			
		}
		
		System.out.println("---------------------------------------");
		System.out.println("1.검사 | 2.마법사 | 3.탱크 | 4.힐러");
		System.out.println("---------------------------------------");
		System.out.print("캐릭터 클래스 >	");
		String charClass = scan.nextLine();
		while (true) {
			switch (charClass) {
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
			default:
				System.out.print("다시 선택	> ");
				charClass = scan.nextLine();
				continue;
			}
			break;
		}
	}

	public static void showCharList() {
		for (int i = 0; i < charList.size(); i++) {
			System.out.println("---------------------------------------");
			System.out.println(charList.get(i).charName + " [LV." + charList.get(i).charLv + "]	/ 클래스 : "
					+ charList.get(i).charClass);
			System.out.println("HP : " + charList.get(i).charHP + " / MP : " + charList.get(i).charMP);
			System.out.println("Coin : " + charList.get(i).charCoin);
			System.out.println("---------------------------------------");
		}
		timeOut = scan.nextLine();
	}

	public static void battleStart() {
		showCharList();
		Char battleChar = selectCharBattle();
		while (true) {
			clrscr();
			System.out.println("---------------------------------------");
			System.out.println(battleChar.charName + " [LV." + battleChar.charLv + "]	/ 클래스 : " + battleChar.charClass);
			System.out.println("HP : " + battleChar.charHP + " / MP : " + Math.round(battleChar.charMP * 100) / 100.0);
			System.out.println("Coin : " + battleChar.charCoin);
			System.out.println("---------------------------------------");
			System.out.println();
			System.out.print("여행을 계속 하시겠습니까? (Y / N)");
			String nextBattle = scan.nextLine();

			while (!nextBattle.equals("Y") && !nextBattle.equals("N")) {
				System.out.print("여행을 계속 하시겠습니까? (Y / N)");
				nextBattle = scan.nextLine();
			}
			if (nextBattle.equals("N")) {
				break;
			} else {
				if(!battleChar.isCharStatus()) {
					System.out.println(battleChar.charName + " 은 더이상 싸울 수 없다....");
					break;
				} else {
					Enemy_Base battleEnemy = new Enemy_Base();
					if (Math.random() * 100 < 35) {
						battleEnemy = new Enemy_Goblin();
					} else if (Math.random() * 100 < 70 && Math.random() * 100 >= 35) {
						battleEnemy = new Enemy_Wolf();			
					}
//		Enemy_Base battleEnemy = new Enemy_Goblin();
					battleEnemy.createEnemy(battleEnemy);
					battleING(battleEnemy, battleChar);					
				}
			}
		}
	}

	public static void battleING(Enemy_Base battleEnemy, Char battleChar) {
		String battleContinue = "Y";
		battleLoop : while (battleContinue.equals("Y")) {
			clrscr();
			System.out.println("---------------------------------------");
			System.out.println(battleChar.charName + " [LV." + battleChar.charLv + "]	/ 클래스 : " + battleChar.charClass);
			System.out.println("HP : " + battleChar.charHP + " / MP : " + Math.round(battleChar.charMP * 100) / 100.0);
			System.out.println("Coin : " + battleChar.charCoin);
			System.out.println("---------------------------------------");
			System.out.println();
			System.out.println("---------------------------------------");
			System.out.println(battleEnemy.enemyRace + "	/ HP : " + Math.round(battleEnemy.enemyHp * 100) / 100.0);
			System.out.println("---------------------------------------");
			System.out.println();
			attMetLoop : while(true) {
				System.out.println("1. 물리공격 / 2. 마법공격 / 3. 도망");
				String selecAttMet = scan.nextLine();
				switch(selecAttMet) {
				case "1":
					battleEnemy.enemyHp -= battleChar.battleMleeAttack();
					break attMetLoop;
				case "2":
					battleEnemy.enemyHp -= battleChar.battleMagicAttack();
					break attMetLoop;
				case "3":
					System.out.println(battleChar.charName + " 은 도망쳤다!");
					timeOut = scan.nextLine();
					break battleLoop;
				}
			}
			if(Math.random() * 100 < 50) {
				battleChar.charHP -= battleEnemy.battleMleeAttack();				
			} else {
				battleChar.charHP -= battleEnemy.battleMagicAttack();								
			}
			System.out.println();
			if (battleEnemy.enemyHp <= 0) {
				battleEnemy.battleDead();
				battleChar.calcWinBattle(battleEnemy.getEnemyDropExp(), battleEnemy.getEnemyDropCoin());
				timeOut = scan.nextLine();
				break;
			} else if (battleChar.charHP <= 0) {
				battleChar.battleDead();
				timeOut = scan.nextLine();
				break;
			} else {
				System.out.print("전투를 계속 하시겠습니까? (Y / N)");
				battleContinue = scan.nextLine();
				while (!battleContinue.equals("Y") && !battleContinue.equals("N")) {
					System.out.print("전투를 계속 하시겠습니까? (Y / N)");
					battleContinue = scan.nextLine();
				}
				if (battleContinue.equals("N")) {
					System.out.println(battleChar.charName + " 은 도망쳤다!");
					timeOut = scan.nextLine();
					break;
				}
			}
		}
	}

	public static Char selectCharBattle () {
		System.out.print("사용하고싶은 캐릭터의 이름을 입력하세요 : ");
		String chooseChar = scan.nextLine();
		Char battleChar = null;
		while (battleChar == null) {
			for (int i = 0; i < charList.size(); i++) {
				if (charList.get(i).charName.equals(chooseChar)) {
					battleChar = charList.get(i);
					break;
				}
			}
			if (battleChar == null) {
				System.out.println("일치하는 캐릭터가 없습니다.");
				System.out.print("사용하고싶은 캐릭터의 이름을 다시 입력하세요 : ");
				chooseChar = scan.nextLine();
			}
			if (battleChar != null && battleChar.isCharStatus() == false) {
				System.out.println(battleChar.charName + " 은 움직일 수 없습니다...");
				System.out.print("사용하고싶은 캐릭터의 이름을 다시 입력하세요 : ");
				chooseChar = scan.nextLine();
				continue;
			}
		}
		return battleChar;
	}
	
	public static Char selectCharRest () {
		System.out.print("휴식할 캐릭터의 이름을 입력하세요 (메인으로 나가려면 Q 입력) : ");
		String chooseChar = scan.nextLine();
		Char restChar = null;
		while (restChar == null && !chooseChar.equals("Q")) {
			for (int i = 0; i < charList.size(); i++) {
				if (charList.get(i).charName.equals(chooseChar)) {
					restChar = charList.get(i);
					break;
				}
			}
			if (restChar == null) {
				System.out.println("일치하는 캐릭터가 없습니다.");
				System.out.print("사용하고싶은 캐릭터의 이름을 다시 입력하세요 (메인으로 나가려면 Q 입력) : ");
				chooseChar = scan.nextLine();
			}
			if (restChar != null && restChar.charHP == restChar.getCharMaxHP()) {
				System.out.println(restChar.charName + " 휴식이 필요하지 않습니다.");
				System.out.print("사용하고싶은 캐릭터의 이름을 다시 입력하세요 (메인으로 나가려면 Q 입력) : ");
				chooseChar = scan.nextLine();
				restChar = null;
				continue;
			}
		}
		return restChar;
	}
	
	public static void restInn() {
		while(true) {
			showCharList();
			Char restChar = selectCharRest();
			if(restChar == null) {
				break;
			}				
			int neededCoin = (int) (restChar.getCharMaxHP() - restChar.charHP);		
			System.out.println();
			System.out.print("총 " + neededCoin + " Coin 을 사용하여 휴식합니까?  (Y / N)");
			String doingRest = scan.nextLine();
			while (!doingRest.equals("Y") && !doingRest.equals("N")) {
				System.out.println("총 " + neededCoin + " Coin 을 사용하여 휴식합니까?  (Y / N)");
				doingRest = scan.nextLine();
			}
			if (doingRest.equals("Y")) {
				if(restChar.charCoin >= neededCoin) {
					restChar.charCoin -= neededCoin;
					restChar.charHP = restChar.getCharMaxHP();
				} else {
					System.out.println("코인이 부족합니다.");
					continue;
				}
			} else {
				break;
			}
		}
	}
	
 	public static void clrscr() {
		// Clears Screen in java
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}

}
