package Launch;

public class LaunchGame extends GameLogic {
	private static final long serialVersionUID = 1L;
	public void init() {
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		Music.playMusic("BgSound.wav");
		Music.play();
		Music.loop(1);
	}
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		while(GetDifficultyLevel==0) {SetupMenu();waitForClick();}
		removeAll();
		SetupLevel();
		while(UserAttemps!=0 && numOfBricksToWin!=0) {
			moveBall();
			MoveBuff();			
			pause(10);
			theEnd();	
		}
		waitForClick();
		removeAll();
		GetDifficultyLevel=0;
		UserAttemps=NTURNS;
		doRandomBuff=true;
		vy=5;
		run();
	}
	
}