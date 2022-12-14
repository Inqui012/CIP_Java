package playAlone.smallGame.character;

public class Char_Heal extends Char{

	public Char_Heal(String charName) {
		super(charName, "Heal");
	}

	@Override
	public void charInit() {
		charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.0) * 100) / 100.0);
		charMaxMP = Math.round(((charMaxMP + charMaxMP * 0.1) * 100) / 100.0);
		charMleeAtt += charMleeAtt * -0.1;
		charMleeDef += charMleeDef * -0.1;
		charMagAtt += charMagAtt * 0.1;
		charMagDef += charMagDef * 0.1;
		charHP = charMaxHP;
		charMP = charMaxMP;
	}

	@Override
	public void calcLvupStatus() {
		double randNum =  (Math.random() * 15) + 1;
		setCharMaxHP(getCharMaxHP() + randNum * 0.6);
		setCharMaxMP(getCharMaxMP() + randNum);
		charMleeAtt += randNum * 0.4;
		charMleeDef += randNum * 0.4;
		charMagAtt += randNum * 0.6;
		charMagDef += randNum * 0.8;
		charHP = getCharMaxHP();
		charMP = getCharMaxMP();
	}
}
