package Launch;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class GameLogic extends Initial implements KeyListener {
	public int numOfBricksToWin;
	public int UserAttemps=3;
	
	/** variables for speed */
	private double vx;
	private double vy = 5;
	/**
	 	* @author Andrii
	 * @return Menu
	 */
		public void SetupMenu() {
		addMouseListeners();
		FirstBg();
		StartButtons();
		StartLabel();
	}
	
	/**
	 	* @author Andrii
	 * @return Видаляє елементи методу SetupMenu 
	 */
		public void RemoveMenu() {
	  removeAll();
  }
	
	/**
	 	* @author Andrii
	 * @return setup level 1
	 */
		public void SetupLevel() {
		addKeyListeners();
        SecondBg();
        tenRowsOfBricks();
        bricksCounter();
        livesCounter();
        createPaddle();
        RandomStartPosition();
        createBall();
        
   }
	/**
	 	* @author Andrii
	 * @return lives counter
	 */
		public void livesCounter() {
        livesCounterLabel = new GLabel("YOUR ATTEMPTS: " + NTURNS);
        livesCounterLabel.setColor(Color.white);
        livesCounterLabel.setFont("Arial-13");

        double x = WIDTH - livesCounterLabel.getWidth();
        double y = HEIGHT - livesCounterLabel.getDescent();

        livesCounterLabel.setLocation(x, y);
        add(livesCounterLabel);
    }
	
	/**
	 	* @author Andrii
	 * @return brick counter
	 */
		private void bricksCounter() {
		numOfBricksToWin=NBRICKS_PER_ROW * NBRICK_ROWS;
		bricksCounterLabel = new GLabel("BRICKS TO WIN THIS GAME: " + numOfBricksToWin);
        bricksCounterLabel.setColor(Color.white);
        bricksCounterLabel.setFont("Arial-13");
        bricksCounterLabel.setLocation(0, HEIGHT - bricksCounterLabel.getDescent());
        add(bricksCounterLabel);
	}

	/**
	 	* @author Andrii
	 * @return створює платформу 
	 */
		public void createPaddle() {
		paddle= new GRect(0,HEIGHT-PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
        paddle.setColor(Color.BLACK);
        add(paddle);
	}
	   /**
		* @author Andrii
		* @param MouseEvent
		* @return MouseClick
		*/
		public void mouseClicked(MouseEvent e) {
			if(GetDifficultyLevel==0)
			{ClickMenuButton(e);}
		}
		
		/**
		* @author Andrii
		* @param e
		* @return Menu buttons click
		*/
		public void ClickMenuButton(MouseEvent e) {
			if((e.getX()>=button1.getX() && e.getX()<=button1.getX()+button1.getWidth())&&(e.getY()>=button1.getY() && e.getY()<=button1.getY()+button1.getHeight())) {
				GetDifficultyLevel=1;RemoveMenu();SetupLevel();
			}
			else if((e.getX()>=button2.getX() && e.getX()<=button2.getX()+button2.getWidth())&&(e.getY()>=button2.getY() && e.getY()<=button2.getY()+button2.getHeight())) {
				GetDifficultyLevel=2;
			}
			else if((e.getX()>=button3.getX() && e.getX()<=button3.getX()+button3.getWidth())&&(e.getY()>=button3.getY() && e.getY()<=button3.getY()+button3.getHeight())) {
				GetDifficultyLevel=3;
			}
		}

		/**
		* @author Andrii
		 * @return Move paddle
		 */
		public void keyPressed(KeyEvent paddleMove)  {
		        if (paddleMove.getKeyCode() == KeyEvent.VK_RIGHT) {
		            	paddle.move(10,0);
		        }
		        if (paddleMove.getKeyCode() == KeyEvent.VK_LEFT) {
		            	paddle.move(-10,0);
		        }
		}
    /**
     	*  @author Andrii
     *  @return Ball
     */
		public void createBall() {
        
        double ovalWidthHeight = BALL_RADIUS * 2;
        Ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS, ovalWidthHeight, ovalWidthHeight);
        Ball.setFilled(true);
        Ball.setColor(Color.WHITE);
        add(Ball);
    }
    /**
     	* @author Andrii
     * @return 1 рандомний мув кулі
     */
		private void RandomStartPosition() {
    	randomX = RandomGenerator.getInstance();
        vx = randomX.nextDouble(1.0, 3.0);
        if (randomX.nextBoolean(0.5)) {
            vx = -vx;
        }

    }
		
		
		/**
		 * @author Anna
		 * @param vx
		 * @param vy
		 * @param BALL_RADIUS
		 * @return the direction of the ball when it hits
		 */
		public void moveBall() {	
			
	        Ball.move(vx, vy);		        
	        if (Ball.getX() > getWidth()-BALL_RADIUS*2) 
	        	vx = -vx;
	        else if (Ball.getX() < 0) 
	        	vx = -vx;
	        else if (Ball.getY() < 0) 
	        	vy = -vy;
	        else if (Ball.getY() > getHeight()) 
	        	vy = -vy;
	        
		}
		
		RandomGenerator rgen = RandomGenerator.getInstance();{
	        vx = rgen.nextDouble(1.0, 3.0);
	        if (rgen.nextBoolean(0.5)) 
	            vx = -vx;}
		

}