package Self;

public class Char_Mage extends Char{

	public Char_Mage(String charName) {
		super(charName, "Mage");
		charInit();
	}

	public void charInit() {
		super.charHP = Math.round(((charHP + charHP * 0.0) * 100) / 100.0);
		super.charMP = Math.round(((charMP + charMP * 0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * -0.2;
		super.charMleeDef += charMleeDef * -0.1;
		super.charMagAtt += charMagAtt * 0.2;
		super.charMagDef += charMagDef * 0.2;
	}

}
