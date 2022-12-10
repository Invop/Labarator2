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
	private static final long serialVersionUID = 1L;
	public int numOfBricksToWin;
	public int UserAttemps=NTURNS;
	
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
		 * @return setup level 1
		 */
		public void SetupLevel() {
		addKeyListeners();
        SecondBg();
        tenRowsOfBricks();
        bricksCounter();
        livesCounter();
        createPaddle();
        createBall(); 

		}
		
	/**
	 	* @author Andrii
	 * @return lives counter
	 */
		public void livesCounter() {
        livesCounterLabel = new GLabel("YOUR ATTEMPTS: " + UserAttemps);
        livesCounterLabel.setColor(Color.white);
        livesCounterLabel.setFont("Arial-13");

        double x = WIDTH - livesCounterLabel.getWidth();
        double y = HEIGHT - livesCounterLabel.getDescent();

        livesCounterLabel.setLocation(x, y);
        add(livesCounterLabel);
    }
		
		/**
	 	* @author Andrii
	 	* @return update lives counter
	 	*/
		private void UpdateLivesCounter() {
			livesCounterLabel.setLabel("YOUR ATTEMPTS: " + UserAttemps);
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
		 * @return update lives counter
		 */
		private void UpdateBricksCounter() {
			bricksCounterLabel.setLabel("BRICKS TO WIN THIS GAME: " + numOfBricksToWin);
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
		* @return MouseClickMenu
		*/
		public void mouseClicked(MouseEvent e) {
			if((e.getX()>=button1.getX() && e.getX()<=button1.getX()+button1.getWidth())&&(e.getY()>=button1.getY() && e.getY()<=button1.getY()+button1.getHeight())) {
				GetDifficultyLevel=1;NBRICK_ROWS=3;
			}
			else if((e.getX()>=button2.getX() && e.getX()<=button2.getX()+button2.getWidth())&&(e.getY()>=button2.getY() && e.getY()<=button2.getY()+button2.getHeight())) {
				GetDifficultyLevel=2;NBRICK_ROWS=4;
			}
			else if((e.getX()>=button3.getX() && e.getX()<=button3.getX()+button3.getWidth())&&(e.getY()>=button3.getY() && e.getY()<=button3.getY()+button3.getHeight())) {
				GetDifficultyLevel=3;NBRICK_ROWS=10;
			}
		}
		
		/**
		* @author Andrii
		 * @return Move paddle
		 */
		public void keyPressed(KeyEvent paddleMove)  {
		        if (paddleMove.getKeyCode() == KeyEvent.VK_RIGHT) {
		            	paddle.move(25,0);
		        }
		        if (paddleMove.getKeyCode() == KeyEvent.VK_LEFT) {
		            	paddle.move(-25,0);
		        }
		}
	   
		/**
	     *  @author Andrii
	     *  @return Ball
	     */
		public void createBall() {
		RandomStartPosition();
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
		 * @author Andrii
		 */
		private GObject getCollidingObj(GOval ball) {
			double ballDiameter = BALL_RADIUS * 2;

	        if (getElementAt(ball.getX(), ball.getY()) != null) {
	            return getElementAt(ball.getX(), ball.getY());
	        }
	        if (getElementAt(ball.getX() + ballDiameter, ball.getY()) != null) {
	            return getElementAt(ball.getX() + ballDiameter, ball.getY());
	        }
	        if (getElementAt(ball.getX(), ball.getY() + ballDiameter) != null) {
	            return getElementAt(ball.getX(), ball.getY() + ballDiameter);
	        }
	        if (getElementAt(ball.getX() + ballDiameter, ball.getY() + ballDiameter) != null) {
	            return getElementAt(ball.getX() + ballDiameter, ball.getY() + ballDiameter);
	        }
			return null;
		}
		
		/**
		 * @authors Anna
		 * @param vx
		 * @param vy
		 * @param BALL_RADIUS
		 * @return the direction of the ball when it hits
		 */
		public void moveBall() {
			Ball.move(vx, vy);	
			GObject collider = getCollidingObj(Ball);
			if (collider == paddle) {vy = -vy; }
			if(collider == acceleration) {remove(acceleration); vy+=2; }
			if (collider== slowdown) {remove(slowdown); vy-=0.8;}
			else if (collider != null && collider != paddle && collider != bricksCounterLabel && collider != livesCounterLabel && collider!=backgroundGame) {                   
                vy = -vy ;
                remove(collider);
                numOfBricksToWin--;
                UpdateBricksCounter();
            }
	        else if (Ball.getX() > getWidth()-BALL_RADIUS*2) 
	        	{vx = -vx;}     
	        else if (Ball.getX() < 0) 
	        	{vx = -vx;}	
	        else if (Ball.getY() < 0) 
	        	{vy = -vy;}  	
	        else if (Ball.getY() > getHeight()-BALL_RADIUS * 2) 
	        	{UserAttemps--;
	        	UpdateLivesCounter();
	        	remove(Ball);
	        	createBall();
	        	waitForClick();
	        	}   
			
		}
		
		public void randomBuff() {
			int randImprovement = rgen.nextInt(1,2);
			if(numOfBricksToWin%10==0) {
				
				if (randImprovement == 1) {
					//acceleration();
					acceleration.move(0, vy);
				}
				else slowdown.move(0, vy);
				
			}
		}
		
		/**
		 * @author Anna
		 * @param UserAttemps
		 * @param numOfBricksToWin
		 * @return background depending on the outcome of the game
		 */
		public void theEnd() {
			removeAll();
			if(UserAttemps == 0) {
				FourthBg();
			}
			if(numOfBricksToWin == 0) {
				ThirdBg();
		}
		}
		/** random number generator */
	    private RandomGenerator rgen= new RandomGenerator();
}