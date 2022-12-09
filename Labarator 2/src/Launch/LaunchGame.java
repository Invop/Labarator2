package Launch;
public class LaunchGame extends GameLogic {
/* Method: run() */
/** Runs the Breakout program. */
	private boolean GameTrue = true;
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);	
		//SetupMenu();
		SecondBg();
		//tenRowsOfBricks();
		createBall();
		while(GameTrue) {			
			moveBall();
			pause(10);
		}
	}
}