package playAlone.smallGame.character;

public class Char_Tank extends Char{
	
	public Char_Tank(String charName) {
		super(charName, "Tank");
		charInit();
	}

	public void charInit() {
		super.charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.2) * 100) / 100.0);
		super.charMaxMP = Math.round(((charMaxMP + charMaxMP * -0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * 0.1;
		super.charMleeDef += charMleeDef * 0.2;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * 0.1;
		super.charHP = charMaxHP;
		super.charMP = charMaxMP;
	}
	
	
}
