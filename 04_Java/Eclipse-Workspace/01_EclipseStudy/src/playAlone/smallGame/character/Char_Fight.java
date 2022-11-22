package playAlone.smallGame.character;

public class Char_Fight extends Char{

	public Char_Fight(String charName) {
		super(charName, "Fight");
	}

	public void charInit() {
		super.charHP = Math.round(((charHP + charHP * 0.1) * 100) / 100.0);
		super.charMP = Math.round(((charMP + charMP * -0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * 0.2;
		super.charMleeDef += charMleeDef * 0.1;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * -0.2;
	}

}
