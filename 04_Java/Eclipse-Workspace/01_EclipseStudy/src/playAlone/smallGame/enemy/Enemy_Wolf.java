package playAlone.smallGame.enemy;

public class Enemy_Wolf extends Enemy_Base{
	@Override
	public void enemyInit() {
		this.enemyRace = "Wolf";
		this.enemyMaxVal = 50;
	}
}
