package Launch;
import acm.graphics.GLabel;
import acm.program.*;
public class LaunchGame extends GraphicsProgram {
	public void run()
	{
			this.setSize(500,600);
			GLabel label = new GLabel("HI!");
			add(label);
			GLabel labe2 = new GLabel("HI!");
			add(labe2);
			add(labe2);
	}
}
