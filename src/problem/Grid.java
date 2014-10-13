package problem;

import java.util.Random;


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
	public void move(Operators2048 op) {
		switch(op.operators) {
		case UP:
		case DOWN:
		case RIGHT:
		case LEFT:
		}
	}
	
	public boolean isGoal(int goalNumber) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == goalNumber)
					return true;
			}
		}
		return false;
	}

}
