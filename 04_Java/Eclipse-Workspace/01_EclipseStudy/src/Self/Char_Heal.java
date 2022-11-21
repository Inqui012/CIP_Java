package Self;

public class Char_Heal extends Char{

	public Char_Heal(String charName) {
		super(charName, "Heal");
	}

	@Override
	public void charInit() {
		super.charHP += charHP * 0.0;
		super.charMP += charMP * 0.1;
		super.charMleeAtt += charMleeAtt * -0.1;
		super.charMleeDef += charMleeDef * -0.1;
		super.charMagAtt += charMagAtt * 0.1;
		super.charMagDef += charMagDef * 0.1;
	}

}
