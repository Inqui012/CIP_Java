package playAlone.smallGame.character;

import playAlone.smallGame.BattelFunc;

public class Char implements BattelFunc{
	
	public String charName;
	public String charClass;
	public int charLv;
	public double charHP = 100;
	public double charMP = 100;
	protected int charMleeAtt = 10;
	protected int charMleeDef = 10;
	protected int charMagAtt = 10;
	protected int charMagDef = 10;
	protected boolean charStatus;
			
	public Char (String charName, String charClass) {
		this.charName = charName;
		this.charClass = charClass;
		this.charLv = 1;
		setCharStatus(true);
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
	

	@Override
	public int battleAttack() {
		int charDamege = (int) (Math.random() * charMleeAtt + 1);
		System.out.println(charName + " 의 공격! " + charDamege + " 의 데미지!");
		return charDamege;
	}

	@Override
	public void battleDead() {
		setCharStatus(false);
		System.out.println(charName + " 의 힘이 다했다... ");
		
	}

}
