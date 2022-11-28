package playAlone.smallGame.character;

public class Char_Fight extends Char{

	public Char_Fight(String charName) {
		super(charName, "Fight");
	}

	@Override
	public void charInit() {
		charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.1) * 100) / 100.0);
		charMaxMP = Math.round(((charMaxMP + charMaxMP * -0.2) * 100) / 100.0);
		charMleeAtt += charMleeAtt * 0.2;
		charMleeDef += charMleeDef * 0.1;
		charMagAtt += charMagAtt * -0.2;
		charMagDef += charMagDef * -0.2;
		charHP = charMaxHP;
		charMP = charMaxMP;
	}

	@Override
	public void calcLvupStatus() {
		double randNum =  (Math.random() * 15) + 1;
		setCharMaxHP(getCharMaxHP() + randNum);
		setCharMaxMP(getCharMaxMP() + randNum * 0.4);
		charMleeAtt += randNum;
		charMleeDef += randNum * 0.6;
		charMagAtt += randNum * 0.4;
		charMagDef += randNum * 0.4;
		charHP = getCharMaxHP();
		charMP = getCharMaxMP();
	}
}
