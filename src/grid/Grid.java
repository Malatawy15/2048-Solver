package grid;

import java.util.Random;

import problem.Operators;

public class Grid {
	
	int[][] grid;
	
	public Grid() {
		grid = new int[4][4];
		Random rand = new Random();
		int row = rand.nextInt(4);
		int col = rand.nextInt(4);
		grid[row][col] = 2;
		row = rand.nextInt(4);
		col = rand.nextInt(4);
		grid[row][col] = 2;
	}
	
	// TODO Finish function move
	public void move(Operators op) {
		switch(op) {
		case UP:
		case DOWN:
		case RIGHT:
		case LEFT:
		}
	}

}
