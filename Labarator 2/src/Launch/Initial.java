package Launch;

import java.awt.Color;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Initial extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 700;

/** Dimensions of game board (usually the same) */
	public static final int WIDTH = APPLICATION_WIDTH;
	public static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	public static final int PADDLE_WIDTH = 60;
	public static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	public static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	public static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	public static  int NBRICK_ROWS = 10;

/** Separation between bricks */
	public static final int BRICK_SEP = 4;

/** Width of a brick */
	public static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	public static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	public static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	public static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	public static final int NTURNS = 3;

/** Width and height of a button */
	public static final int BUTTON_WIDTH = 250;
	public static final int BUTTON_HEIGHT = 60;
	
/** Font size of the text in the button*/
	public static final int font = 30;
	
/** Variable to select the difficulty of the game*/
	public int GetDifficultyLevel=0;
	
   		 /**
		 * @author Andrii
		 * @param yCoordinateRow
		 * @param xCoordinate
		 * @return Метод зміщує прямокутники, створені методом createBrick
		 */
	   public void tenRowsOfBricks() {    
	        double yCoordinateRow = BRICK_Y_OFFSET;
	        double xCoordinate;
	        for (int i = 0; i < NBRICK_ROWS; i++) {
	        	xCoordinate =0; 
	            for (int j = 0; j < NBRICKS_PER_ROW; j++) {    
	               createBrick(xCoordinate, yCoordinateRow, i);
	                xCoordinate = xCoordinate + BRICK_WIDTH + BRICK_SEP;
	            }
	            yCoordinateRow = yCoordinateRow + BRICK_HEIGHT + BRICK_SEP;
	        }
	    }
	   
	   /**
		 * @author Andrii
		 * @param xCoordinate
		 * @param yCoordinateRow
		 * @param NumLine
		 * @return Метод малює прямокутники різного кольору
		 */
	   private void createBrick(double xCoordinate, double yCoordinateRow, int NumLine) {
	        // create a brick
	        brick = new GRect(xCoordinate, yCoordinateRow, BRICK_WIDTH, BRICK_HEIGHT);
	        brick.setFilled(true);
	        if (NumLine == 0 || NumLine == 1) {
	        	brick.setColor(Color.RED);
	        }
	        else if (NumLine == 2 || NumLine == 3) {
	        	brick.setColor(Color.ORANGE);
	        }
	        else if (NumLine == 4 || NumLine == 5) {
	        	brick.setColor(Color.YELLOW);
	        }
	        else if (NumLine== 6 || NumLine == 7) {
	        	brick.setColor(Color.GREEN);
	        }
	        else if (NumLine == 8 || NumLine == 9) {
	        	brick.setColor(Color.CYAN);
	        }
	        add(brick);
	    }
	   
	   /**
	    * @author Anna
	    * @param BUTTON_WIDHT
	    * @param BUTTON_HEIGHT
	    * @param getWidth
	    * @param getHeight
	    * @return Метод створює три кнопки для вибору складності рівня
	    */
	   public void StartButtons() {	
			button1 = new GRect (WIDTH/2-BUTTON_WIDTH/2, HEIGHT*0.75-2.5*BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
			button1.setFilled(true);
			button1.setFillColor(Color.WHITE);
			add(button1);
			
			button2 = new GRect (WIDTH/2-BUTTON_WIDTH/2, HEIGHT*0.75-BUTTON_HEIGHT/2, BUTTON_WIDTH, BUTTON_HEIGHT);
			button2.setFilled(true);
			button2.setFillColor(Color.WHITE);
			add(button2);
				
			button3 = new GRect (WIDTH/2-BUTTON_WIDTH/2, HEIGHT*0.75+1.5*BUTTON_HEIGHT, BUTTON_WIDTH, BUTTON_HEIGHT);
			button3.setFilled(true);
			button3.setFillColor(Color.WHITE);
			add(button3);
			
		}
		
		/**
		 * @author Anna
		 * @param font
		 * @param getWidth
		 * @param getHeight
		 * @param BUTTON_HEIGHT
		 * @return Метод накладає назви рівнів на прямокутники зі StartButtons
		 */
		public void StartLabel() {
			button1Label = new GLabel ("Eazy");
			button1Label.setFont("Berlin Sans FB -"+font);
			add(button1Label, getWidth()/2-button1Label.getWidth()/2, button1.getY()+BUTTON_HEIGHT-button1Label.getHeight()/2);
			
			button2Label = new GLabel ("Medium");
			button2Label.setFont("Berlin Sans FB -"+font);
			add(button2Label, getWidth()/2-button2Label.getWidth()/2,  button2.getY()+BUTTON_HEIGHT-button2Label.getHeight()/2);
		
			button3Label = new GLabel ("Hard");
			button3Label.setFont("Berlin Sans FB -"+font);
			add(button3Label, getWidth()/2-button3Label.getWidth()/2, button3.getY()+BUTTON_HEIGHT-button3Label.getHeight()/2);
		
		}	
		
		/**
		 * @author Anna
		 * @return Метод створює фон при старті гри
		 */
		public void FirstBg() {
			backgroundStart = new GImage ("backgroundStart.png");			
			add(backgroundStart);}
		
		/**
		 * @author Anna
		 * @return Метод створює фон гри
		 */
		public void SecondBg() {
			backgroundGame = new GImage ("backgroundGame.png");			
			add(backgroundGame);}
		
		/**
		 * @author Anna
		 * @return Метод створює фон, якщо користувач переміг
		 */
		public void ThirdBg() {
			GImage backgroundWinner = new GImage ("backgroundWinner.png");			
			add(backgroundWinner);}
		
		/**
		 * @author Anna
		 * @return Метод створює фон, якщо користувач програв
		 */
		public void FourthBg() {
			GImage backgroundLoser = new GImage ("backgroundLoser.png");			
			add(backgroundLoser);}
		
		/**
		 * @author Anna
		 * @return booster that makes ball move faster 
		 */
		public void doAcceleration() {
			acceleration = new GImage ("ballFaster.png", Ball.getX(), Ball.getY());
			add(acceleration);
		}
		
		/**
		 * @author Anna
		 * @return booster that makes ball move slowly
		 */
		public void doSlowdown() {
			slowdown = new GImage ("ballSlowly.png",Ball.getX(), Ball.getY());
			add(slowdown);
		}
		
		/**Bg*/
		public GImage backgroundStart;
		public GImage backgroundGame;
		
		/**Start Labels*/
		public GLabel button1Label;
		public GLabel button2Label;
		public GLabel button3Label;
		
		/** three buttons to choose difficulty of the game*/
		public GRect button1;
		public GRect button2;
		public GRect button3;
		/**Ball*/
		public GOval Ball;
		/**Brick*/
		public GRect brick;
		/**Paddle*/
		public GRect paddle;
		/**Lives Counter*/
		public GLabel livesCounterLabel;
		/**Bricks Counter*/
		public GLabel bricksCounterLabel;
		/**Random start angle*/
		public RandomGenerator randomX;
		/**Acceleration*/
		public double vx;
		public double vy=5;
		/**booster faster and slowly*/
		public GImage acceleration;
		/**booster faster and slowly*/
		public GImage slowdown;
		/**Collection of items*/
		public GObject colliderPaddle;
	}


