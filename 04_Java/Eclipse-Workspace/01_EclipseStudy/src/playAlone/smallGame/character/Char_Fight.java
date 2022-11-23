package playAlone.smallGame.character;

public class Char_Fight extends Char{

	public Char_Fight(String charName) {
		super(charName, "Fight");
		charInit();
	}

	public void charInit() {
		super.charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.1) * 100) / 100.0);
		super.charMaxMP = Math.round(((charMaxMP + charMaxMP * -0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * 0.2;
		super.charMleeDef += charMleeDef * 0.1;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * -0.2;
		super.charHP = charMaxHP;
		super.charMP = charMaxMP;
	}

}
