package Self;

public class Char {
	
	String charName;
	String charClass;
	int charLv;
	double charHP = 100;
	double charMP = 100;
	protected int charMleeAtt = 10;
	protected int charMleeDef = 10;
	protected int charMagAtt = 10;
	protected int charMagDef = 10;
	private boolean charStatus;
			
	public Char (String charName, String charClass) {
		this.charName = charName;
		this.charClass = charClass;
		this.charLv = 1;
		charInit();
		setCharStatus(true);
	}

	public void charInit() {
		this.charHP += 0;
		this.charMP += 0;
		this.charMleeAtt += 0;
		this.charMleeDef += 0;
		this.charMagAtt += 0;
		this.charMagDef += 0;
	}
	
	public int getCharMleeAtt() {
		return charMleeAtt;
	}

	public void setCharMleeAtt(int charMleeAtt) {
		this.charMleeAtt = charMleeAtt;
	}

	public int getCharMleeDef() {
		return charMleeDef;
	}

	public void setCharMleeDef(int charMleeDef) {
		this.charMleeDef = charMleeDef;
	}

	public int getCharMagAtt() {
		return charMagAtt;
	}

	public void setCharMagAtt(int charMagAtt) {
		this.charMagAtt = charMagAtt;
	}

	public int getCharMagDef() {
		return charMagDef;
	}

	public void setCharMagDef(int charMagDef) {
		this.charMagDef = charMagDef;
	}

	public boolean isCharStatus() {
		return charStatus;
	}

	public void setCharStatus(boolean charStatus) {
		this.charStatus = charStatus;
	}
	

}
