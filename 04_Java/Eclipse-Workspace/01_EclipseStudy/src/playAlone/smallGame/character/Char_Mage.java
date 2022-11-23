package playAlone.smallGame.character;

public class Char_Mage extends Char{

	public Char_Mage(String charName) {
		super(charName, "Mage");
		charInit();
	}

	public void charInit() {
		super.charMaxHP = Math.round(((charMaxHP + charMaxHP * 0.0) * 100) / 100.0);
		super.charMaxMP = Math.round(((charMaxMP + charMaxMP * 0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * -0.2;
		super.charMleeDef += charMleeDef * -0.1;
		super.charMagAtt += charMagAtt * 0.2;
		super.charMagDef += charMagDef * 0.2;
		super.charHP = charMaxHP;
		super.charMP = charMaxMP;
	}

}
