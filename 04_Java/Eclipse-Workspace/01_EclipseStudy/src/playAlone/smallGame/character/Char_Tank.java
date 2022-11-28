package playAlone.smallGame.character;

public class Char_Tank extends Char{
	
	public Char_Tank(String charName) {
		super(charName, "Tank");
	}
	
	@Override
	public void charInit() {
		charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.2) * 100) / 100.0);
		charMaxMP = Math.round(((charMaxMP + charMaxMP * -0.2) * 100) / 100.0);
		charMleeAtt += charMleeAtt * 0.1;
		charMleeDef += charMleeDef * 0.2;
		charMagAtt += charMagAtt * -0.2;
		charMagDef += charMagDef * 0.1;
		charHP = charMaxHP;
		charMP = charMaxMP;
	}
	
	@Override
	public void calcLvupStatus() {
		double randNum =  (Math.random() * 15) + 1;
		setCharMaxHP(getCharMaxHP() + randNum);
		setCharMaxMP(getCharMaxMP() + randNum * 0.4);
		charMleeAtt += randNum * 0.6;
		charMleeDef += randNum;
		charMagAtt += randNum * 0.4;
		charMagDef += randNum * 0.8;
		charHP = getCharMaxHP();
		charMP = getCharMaxMP();
	}
	
}
