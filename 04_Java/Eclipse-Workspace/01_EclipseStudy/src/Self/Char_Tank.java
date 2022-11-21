package Self;

public class Char_Tank extends Char{
	
	public Char_Tank(String charName) {
		super(charName, "Tank");
		charInit();
	}

	public void charInit() {
		super.charHP = Math.round(((charHP + charHP * 0.2) * 100) / 100.0);
		super.charMP = Math.round(((charMP + charMP * -0.2) * 100) / 100.0);
		super.charMleeAtt += charMleeAtt * 0.1;
		super.charMleeDef += charMleeDef * 0.2;
		super.charMagAtt += charMagAtt * -0.2;
		super.charMagDef += charMagDef * 0.1;
	}
	
	
}
