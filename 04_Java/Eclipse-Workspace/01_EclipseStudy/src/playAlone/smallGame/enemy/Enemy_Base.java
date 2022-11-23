package playAlone.smallGame.enemy;

import playAlone.smallGame.BattelFunc;

public class Enemy_Base implements BattelFunc {
	public String enemyRace;
	public double enemyHp;
	protected int enemyMaxVal;
	protected int enemyDropCoin;
	protected int enemyDropExp;
	
	public void createEnemy (Enemy_Base enemy) {
		enemyInit();
		this.enemyHp = calcMaxHp(enemyMaxVal);
		setEnemyDropCoin(enemy.enemyHp);
		setEnemyDropExp(enemy.enemyHp);
	}
	
	public void enemyInit () {
		this.enemyRace = "Slime";
		this.enemyMaxVal = 10;
	}
	
	private double calcMaxHp (int mult) {
		return Math.round(((Math.random() * mult) + 1)*100) / 100.0;
	}
	
//	getter setter
	public int getEnemyDropCoin() {
		return enemyDropCoin;
	}

	public void setEnemyDropCoin(double enemyHp) {
		this.enemyDropCoin = (int) Math.floor(enemyHp / 2);
	}

	public int getEnemyDropExp() {
		return enemyDropExp;
	}

	public void setEnemyDropExp(double enemyHp) {
		if(enemyHp <= 15) {
			this.enemyDropExp = 1;
		} else {
			this.enemyDropExp = (int) Math.floor(enemyHp - 15);			
		}
	}

//	interface override
	@Override
	public int battleAttack() {
		int enemyDamege = (int) (Math.random() * enemyDropExp + 1);
		System.out.println(enemyRace + " 의 공격! " + enemyDamege + " 의 데미지!");
		return enemyDamege;
	}

	@Override
	public void battleDead() {
		System.out.println(enemyRace + " 를 쓰러트렸다! " + enemyDropExp + "의 경험치와 " + enemyDropCoin + " 코인을 얻었다!");
	}

}
