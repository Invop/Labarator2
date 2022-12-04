package Launch;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.RandomGenerator;

public class GameLogic extends Initial implements KeyListener {
	public int numOfBricksToWin;
	public int UserAttempts=NTURNS;
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
	 * @return just setup
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
	   bricksCounter();
	   livesCounter();
	   createPaddle();
	   tenRowsOfBricks();

	   //createBallAndMove();
   }
	
   /**
	 * @author Andrii
	 * @param MouseEvent
	 */
	public void mouseClicked(MouseEvent e) {
		if(GetDifficultyLevel==0)
		{ClickMenuButton(e);}
	}
	
	/**
	 * @author Andrii
	 * @param e
	 * Menu buttons click
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
	 * <p>Move paddle</p>
	 */
	public void keyPressed(KeyEvent paddleMove)  {
	        if (paddleMove.getKeyCode() == KeyEvent.VK_RIGHT) {
	            	paddle.move(10,0);
	        }
	        if (paddleMove.getKeyCode() == KeyEvent.VK_LEFT) {
	            	paddle.move(-10,0);
	        }
	}
/*
	public void createBallAndMove() {
		createBall();
		moveBall();
	}

	private void moveBall() {
		
		RandomGenerator rgen = RandomGenerator.getInstance();
        vx = rgen.nextDouble(1.0, 3.0);
        if (rgen.nextBoolean(0.5)) {
            vx = -vx;
        }

	}*/
	
	
/*
 * private GObject getCollidingObject(GOval ball) {
		// TODO Auto-generated method stub
		return null;
	}
 */
	
	 

}
