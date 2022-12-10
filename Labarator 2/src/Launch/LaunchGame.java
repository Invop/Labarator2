package Launch;

public class LaunchGame extends GameLogic {
	private static final long serialVersionUID = 1L;
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		Music.playMusic("BgSound.wav");
		while(GetDifficultyLevel==0) {SetupMenu();waitForClick();}
		removeAll();
		SetupLevel();
		while(UserAttemps!=0 && numOfBricksToWin!=0) {
			moveBall();
			pause(10);
			theEnd();	
		}
		
	}
	
}