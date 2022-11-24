package playAlone.smallGame.character;

import playAlone.smallGame.BattelFunc;

public class Char implements BattelFunc{
	
	public String charName;
	public String charClass;
	public int charLv;
	public double charHP;
	public double charMP;
	public int charCoin = 0;
	protected double charMaxHP = 100;
	protected double charMaxMP = 100;
	protected int charExp = 0;
	protected int charMleeAtt = 30;
	protected int charMleeDef = 30;
	protected int charMagAtt = 30;
	protected int charMagDef = 30;
	protected boolean charStatus;
			
	public Char (String charName, String charClass) {
		this.charName = charName;
		this.charClass = charClass;
		this.charLv = 1;
		this.charExp = 0;
		charInit();
		setCharStatus(true);
	}

	public void calcWinBattle(int exp, int coin) {
		this.charExp += exp;
		while(this.charExp / 100 > 0) {
			this.charLv++;
			System.out.println("레벨 업! [Lv. " + (charLv - 1) + "] -> [Lv. " + charLv + "]");	
			calcLvupStatus();
			this.charExp %= 100;
		}
		this.charCoin += coin;
	}
	public void charInit() {
		
	}
	public void calcLvupStatus () {
		
	}
	
	public double getCharMaxHP() {
		return charMaxHP;
	}

	public void setCharMaxHP(double charMaxHP) {
		this.charMaxHP = Math.round((charMaxHP * 100) / 100.0);
	}

	public double getCharMaxMP() {
		return charMaxMP;
	}
	public int getCharExp() {
		return charExp;
	}

	public void setCharExp(int charExp) {
		this.charExp = charExp;
	}

	public void setCharMaxMP(double charMaxMP) {
		this.charMaxMP = Math.round((charMaxMP * 100) / 100.0);
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
	public void battleDead() {
		setCharStatus(false);
		System.out.println(charName + " 의 힘이 다했다... ");
	}

	@Override
	public int battleMleeAttack() {
		int charDamege = (int) (Math.random() * charMagAtt + 1);
		System.out.println(charName + " 의 물리 공격! " + charDamege + " 의 데미지!");
		return charDamege;
	}

	@Override
	public int battleMagicAttack() {
		int charDamege = (int) (Math.random() * charMleeAtt + 1);
		System.out.println(charName + " 의 마법 공격! " + charDamege + " 의 데미지!");
		return charDamege;
	}

}
