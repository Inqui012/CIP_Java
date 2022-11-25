package playAlone.smallGame.character;

public class Char_Mage extends Char {

	public Char_Mage(String charName) {
		super(charName, "Mage");
		charInit();
	}

	@Override
	public void charInit() {
		charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.0) * 100) / 100.0);
		charMaxMP = Math.round(((charMaxMP + charMaxMP * 0.2) * 100) / 100.0);
		charMleeAtt += charMleeAtt * -0.2;
		charMleeDef += charMleeDef * -0.1;
		charMagAtt += charMagAtt * 0.2;
		charMagDef += charMagDef * 0.2;
		charHP = charMaxHP;
		charMP = charMaxMP;
	}

	@Override
	public void calcLvupStatus() {
		double randNum =  (Math.random() * 15) + 1;
		setCharMaxHP(getCharMaxHP() + randNum * 0.4);
		setCharMaxMP(getCharMaxMP() + randNum);
		charMleeAtt += randNum * 0.4;
		charMleeDef += randNum * 0.4;
		charMagAtt += randNum;
		charMagDef += randNum * 0.8;
		charHP = getCharMaxHP();
		charMP = getCharMaxMP();
	}
}
