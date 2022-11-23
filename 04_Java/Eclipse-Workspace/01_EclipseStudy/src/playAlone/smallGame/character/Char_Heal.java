package playAlone.smallGame.character;

public class Char_Heal extends Char{

	public Char_Heal(String charName) {
		super(charName, "Heal");
		charInit();
	}

	public void charInit() {
		super.charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.0) * 100) / 100.0);
		super.charMaxMP = Math.round(((charMaxMP + charMaxMP * 0.1) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * -0.1;
		super.charMleeDef += charMleeDef * -0.1;
		super.charMagAtt += charMagAtt * 0.1;
		super.charMagDef += charMagDef * 0.1;
		super.charHP = charMaxHP;
		super.charMP = charMaxMP;
	}

}
