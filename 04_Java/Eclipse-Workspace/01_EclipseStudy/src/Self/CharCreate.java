package Self;

public class CharCreate {

	String charName;
	String charClass;
	int charLv = 1;
	double charHP = 100;
	double charMP = 100;
	int charMleeAtt = 10;
	int charMleeDef = 10;
	int charMagAtt = 10;
	int charMagDef = 10;
	
	boolean charStatus = true;
	
	
	CharCreate(String charName, int charClass){
		this.charName = charName;
		switch(charClass) {
		case 1 :
			this.charClass = "Figter";
			charHP += 20;
			charMP += -20;
			charMleeAtt += 2;
			charMleeDef += 2;
			charMagAtt += -2;
			charMagDef += -2;
			break;
		case 2 :
			this.charClass = "Mage";
			charHP += -20;
			charMP += 40;
			charMleeAtt += -4;
			charMleeDef += -3;
			charMagAtt += 4;
			charMagDef += 3;
			break;
		case 3 :
			this.charClass = "Tank";
			charHP += 40;
			charMP += -35;
			charMleeAtt += 1;
			charMleeDef += 4;
			charMagAtt += -3;
			charMagDef += 3;
			break;
		case 4 :
			this.charClass = "Healer";	
			charHP += -30;
			charMP += 15;
			charMleeAtt += -2;
			charMleeDef += -4;
			charMagAtt += 2;
			charMagDef += 2;
			break;
		}
	}
	
	static String charNameSet () {
		System.out.print("캐릭터 이름	> ");
		String charCreateName = GameTest.scan.nextLine();
		return charCreateName;
	}
	static int charClassSet() {
		System.out.println("---------------------------------------");
		System.out.println("1.검사 | 2.마법사 | 3.탱크 | 4.힐러");
		System.out.println("---------------------------------------");
		System.out.print("캐릭터 직업	> ");
		String charCreateClass = GameTest.scan.nextLine();
		while(true) {
			switch(charCreateClass) {
			case "1":
			case "2":
			case "3":
			case "4":
				break;
			default :
				System.out.print("다시 선택	> ");
				charCreateClass = GameTest.scan.nextLine();
				continue;
			}
			break;
		}
		return Integer.parseInt(charCreateClass);
	}

}
