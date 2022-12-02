package Launch;

import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Initial extends GraphicsProgram{

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
	public static final int NBRICK_ROWS = 10;

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
		/**
		 * @author Andrii
		 * @param yCoordinateRow
		 * @param xCoordinate
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
		 * @
		 */
	   private void createBrick(double xCoordinate, double yCoordinateRow, int NumLine) {
	        // create a brick
	        GRect brick = new GRect(xCoordinate, yCoordinateRow, BRICK_WIDTH, BRICK_HEIGHT);
	        brick.setFilled(true);
	        if (NumLine == 0 || NumLine == 1) {
	        	brick.setColor(Color.RED);
	        }
	        if (NumLine == 2 || NumLine == 3) {
	        	brick.setColor(Color.ORANGE);
	        }
	        if (NumLine == 4 || NumLine == 5) {
	        	brick.setColor(Color.YELLOW);
	        }
	        if (NumLine== 6 || NumLine == 7) {
	        	brick.setColor(Color.GREEN);
	        }
	        if (NumLine == 8 || NumLine == 9) {
	        	brick.setColor(Color.CYAN);
	        }
	        add(brick);
	    }
}
