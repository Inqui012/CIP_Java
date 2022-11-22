package playAlone;

public class Battle {
	private double enemyHP;
	
	public Battle() {
		double randomEnemyHP = Math.round(((Math.random() * 100) + 1)*100) / 100.0;
		setEnemyHP(randomEnemyHP);
	}

	public double getEnemyHP() {
		return enemyHP;
	}

	public void setEnemyHP(double enemyHP) {
		this.enemyHP = enemyHP;
	}
	
	
}
