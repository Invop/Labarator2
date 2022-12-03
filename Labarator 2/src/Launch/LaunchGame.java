package Launch;
public class LaunchGame extends Initial {
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);	
		//FirstBg();
		//StartButtons();
		//StartLabel();
		SecondBg();
		tenRowsOfBricks();
	}
}