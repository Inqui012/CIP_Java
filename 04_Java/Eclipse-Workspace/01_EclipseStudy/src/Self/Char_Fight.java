package Self;

public class Char_Fight extends Char{

	public Char_Fight(String charName) {
		super(charName, "Fight");
	}

	@Override
	public void charInit() {
		super.charHP += charHP * 0.1;
		super.charMP += charMP * -0.2;
		super.charMleeAtt += charMleeAtt * 0.2;
		super.charMleeDef += charMleeDef * 0.1;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * -0.2;
	}

}
