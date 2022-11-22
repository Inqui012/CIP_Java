package playAlone.smallGame.character;

public class Char_Heal extends Char{

	public Char_Heal(String charName) {
		super(charName, "Heal");
	}

	public void charInit() {
		super.charHP = Math.round(((charHP + charHP * 0.0) * 100) / 100.0);
		super.charMP = Math.round(((charMP + charMP * 0.1) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * -0.1;
		super.charMleeDef += charMleeDef * -0.1;
		super.charMagAtt += charMagAtt * 0.1;
		super.charMagDef += charMagDef * 0.1;
	}

}
