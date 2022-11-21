package Self;

public class Char_Tank extends Char{
	
	public Char_Tank(String charName) {
		super(charName, "Tank");
	}

	public void charInit() {
		super.charHP += charHP * 0.2;
		super.charMP += charMP * -0.2;
		super.charMleeAtt += charMleeAtt * 0.1;
		super.charMleeDef += charMleeDef * 0.2;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * 0.1;
	}
	
	
}
