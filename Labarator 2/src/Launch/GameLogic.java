package Launch;

import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class GameLogic extends Initial{
	private static final long serialVersionUID = 1L;
	/**Brick to win*/
	public int numOfBricksToWin;
	/**User Attemps*/
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
		* @return LEVEL
		*/
		public void SetupLevel() {
		addKeyListeners();
        SecondBg();
        tenRowsOfBricks();
        bricksCounter();
        livesCounter();
        createPaddle();
        createBall(); 
        waitForClick();
		}
		
		/**
	 	* @author Andrii
	 	* @param x
	 	* @param y
	 	* @return livesCounterLabel
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
	 	* @return livesCounterLabel
	 	*/
		private void UpdateLivesCounter() {
			livesCounterLabel.setLabel("YOUR ATTEMPTS: " + UserAttemps);
		}
	
		/**
	 	* @author Andrii
		 * @return bricksCounterLabel
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
		 * @return bricksCounterLabel
		 */
		private void UpdateBricksCounter() {
			bricksCounterLabel.setLabel("BRICKS TO WIN THIS GAME: " + numOfBricksToWin);
		}
	
		/**
	 	* @author Andrii
		 * @return paddle
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
		* @param GetDifficultyLevel
		* @param LimitX
		* @param LimitX2
		* @param mouseCenterOfThePaddle
		* @return Move paddle
	 	*/
	    public void mouseMoved(MouseEvent paddleMove) {
	    	if(GetDifficultyLevel!=0) {
	        double mouseCenterOfThePaddle = PADDLE_WIDTH / 2;
	        double LimitX = getWidth() - mouseCenterOfThePaddle;
	        double LimitX2 = mouseCenterOfThePaddle;
	        if (paddleMove.getX() <= LimitX && paddleMove.getX() >= LimitX2) {
	            paddle.setLocation(paddleMove.getX() - mouseCenterOfThePaddle, getHeight() - PADDLE_Y_OFFSET);
	        }}
	    }
	   
		/**
	     *  @author Andrii
	     *  @param ovalWidthHeight
	     *  @param GOval
	     *  @param BALL_RADIUS
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
	     * @param vx
	     * @return randomX
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
		 * @return Ball collision
		 * @param ballDiameter
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
			
			if (collider == paddle) {Music.playMusic("wee-wee.wav");vy = -vy;}
			
			else if (collider != null && collider != paddle && collider != bricksCounterLabel && collider != livesCounterLabel && collider!=backgroundGame && collider!=colliderPaddle && collider!=acceleration && collider!=slowdown)  {                   
				Music.playMusic("hitting.wav");
				Music.play();
				Music.loop(0);
				vy = -vy ;
                remove(collider);
                numOfBricksToWin--;
                UpdateBricksCounter();
                if(GetDifficultyLevel>=2) {randomBuff();}
            }
	        else if (Ball.getX() > getWidth()-BALL_RADIUS*2) 
	        	{Music.playMusic("wee-wee.wav");
	        	Music.play();
				Music.loop(0);
	        	vx = -vx;}     
	        else if (Ball.getX() < 0) 
	        	{Music.playMusic("wee-wee.wav");
	        	Music.play();
				Music.loop(0);
	        	vx = -vx;}	
	        else if (Ball.getY() < 0) 
	        	{Music.playMusic("wee-wee.wav");
	        	Music.play();
				Music.loop(0);
	        	vy = -vy;}  	
	        else if (Ball.getY() > getHeight()-BALL_RADIUS * 2) 
	        	{UserAttemps--;
	        	UpdateLivesCounter();
	        	remove(Ball);
	        	createBall();
	        	if(UserAttemps!=0)waitForClick();
	        	}
			
		}
		/**
		 * @author Andrii
		 * @param acceleration
		 * @param slowdown
		 * @param paddle
		 * @param vy
		 * @param doRandomBuff
		 * @return move Buff
		 * 
		 */
		public void MoveBuff() {
			if(acceleration!=null) {
				acceleration.move(0,2);
				if(paddle.contains(acceleration.getX(),acceleration.getY())) {	
					if(vy>0) {vy+=0.3;}
					else {vy-=0.3;}
					Music.playMusic("bombaaa.wav");
					Music.play();
					Music.loop(0);
					remove(acceleration);
					doRandomBuff=false;
					
				}	
			}
			if (slowdown!=null) {
				slowdown.move(0,2);
				if(paddle.contains(slowdown.getX(),slowdown.getY())) {	
					if(vy>0)vy-=0.2;
					else {vy+=0.2;}
					Music.playMusic("bombaaa.wav");
					Music.play();
					Music.loop(0);
					remove(slowdown);
					doRandomBuff=true;
					
				}	
			}
		}
		/**
		 * @author Anna
		 * @param numOfBricksToWin
		 * @param acceleration
		 * @param slowdown
		 * @return random buff and its movement
		 */
		public void randomBuff() {		
			if(numOfBricksToWin%10==0 && numOfBricksToWin!=NBRICKS_PER_ROW*NBRICK_ROWS ) {					
						if(doRandomBuff)doAcceleration();
						else doSlowdown();
				}
			}
		
		/**
		 * @author Anna
		 * @param UserAttemps
		 * @param numOfBricksToWin
		 * @return background depending on the outcome of the game
		 */
		public void theEnd() {
			
			if(UserAttemps == 0) {
				removeAll();FourthBg();
				Music.playMusic("sad.wav");
				Music.play();
				Music.loop(0);
			}
			if(numOfBricksToWin == 0) {
				removeAll();ThirdBg();
				Music.playMusic("happy.wav");
				Music.play();
				Music.loop(0);
		}
		}
		/** random number generator */
	   protected boolean doRandomBuff=true;
}