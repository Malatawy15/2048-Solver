package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Grid {

	int[][] grid;
	int size;
	int goal;

	public Grid(int size, int goal) {
		grid = new int[size][size];
		this.size = size;
		Random rand = new Random();
		int row = rand.nextInt(size);
		int col = rand.nextInt(size);
		grid[row][col] = 2;
		row = rand.nextInt(size);
		col = rand.nextInt(size);
		grid[row][col] = 2;
		this.goal = goal;
	}
	
	public Grid copyGrid() {
		Grid newGrid = new Grid(size, goal);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				newGrid.grid[i][j] = grid[i][j];
			}
		}
		return newGrid;
	}
	
	public Grid move(Operators2048 op) {
		Grid newGrid = this.copyGrid();
		newGrid.applyMove(op);
		return newGrid;
	}

	public void applyMove(Operators2048 op) {
		boolean moved = false;
		switch (op) {
		case UP:
			moved = moveUp();
			break;
		case DOWN:
			moved = moveDown();
			break;
		case RIGHT:
			moved = moveRight();
			break;
		case LEFT:
			moved = moveLeft();
			break;
		}
		if (moved) {
			addTile();
		}
	}

	private boolean moveUp() {
		boolean moved = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				boolean[] newVal = new boolean[4];
				if (grid[j][i] != 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (grid[k][i] == 0) {
							grid[k][i] = grid[k + 1][i];
							grid[k + 1][i] = 0;
							moved = true;
							if (newVal[k + 1]) {
								newVal[k] = true;
								newVal[k + 1] = false;
							}
						} else if (grid[k][i] == grid[k + 1][i]) {
							if (!newVal[k] && !newVal[k + 1]) {
								grid[k][i] *= 2;
								newVal[k] = true;
								moved = true;
								grid[k + 1][i] = 0;
							}
							break;
						} else if (grid[k][i] != grid[k + 1][i]) {
							break;
						}
					}
				}
			}
		}
		return moved;
	}

	private boolean moveDown() {
		boolean moved = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				boolean[] newVal = new boolean[4];
				if (grid[j][i] != 0) {
					for (int k = j + 1; k < size; k++) {
						if (grid[k][i] == 0) {
							grid[k][i] = grid[k - 1][i];
							grid[k - 1][i] = 0;
							moved = true;
							if (newVal[k - 1]) {
								newVal[k] = true;
								newVal[k - 1] = false;
							}
						} else if (grid[k][i] == grid[k - 1][i]) {
							if (!newVal[k] && !newVal[k - 1]) {
								grid[k][i] *= 2;
								newVal[k] = true;
								moved = true;
								grid[k - 1][i] = 0;
							}
							break;
						} else if (grid[k][i] != grid[k - 1][i]) {
							break;
						}
					}
				}
			}
		}
		return moved;
	}

	private boolean moveRight() {
		boolean moved = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				boolean[] newVal = new boolean[4];
				if (grid[i][j] != 0) {
					for (int k = j + 1; k < size; k++) {
						if (grid[i][k] == 0) {
							grid[i][k] = grid[i][k - 1];
							grid[i][k - 1] = 0;
							moved = true;
							if (newVal[k - 1]) {
								newVal[k] = true;
								newVal[k - 1] = false;
							}
						} else if (grid[i][k] == grid[i][k - 1]) {
							if (!newVal[k] && !newVal[k - 1]) {
								grid[i][k] *= 2;
								newVal[k] = true;
								moved = true;
								grid[i][k - 1] = 0;
							}
							break;
						} else if (grid[i][k] != grid[i][k - 1]) {
							break;
						}
					}
				}
			}
		}
		return moved;
	}

	private boolean moveLeft() {
		boolean moved = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				boolean[] newVal = new boolean[4];
				if (grid[i][j] != 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (grid[i][k] == 0) {
							grid[i][k] = grid[i][k + 1];
							grid[i][k + 1] = 0;
							moved = true;
							if (newVal[k + 1]) {
								newVal[k] = true;
								newVal[k + 1] = false;
							}
						} else if (grid[i][k] == grid[i][k + 1]) {
							if (!newVal[k] && !newVal[k + 1]) {
								grid[i][k] *= 2;
								newVal[k] = true;
								moved = true;
								grid[i][k + 1] = 0;
							}
							break;
						} else if (grid[i][k] != grid[i][k + 1]) {
							break;
						}
					}
				}
			}
		}
		return moved;
	}

	public void addTile() {
		int[] dx = { 0, 0, size - 1, size - 1 };
		int[] dy = { 0, size - 1, size - 1, 0 };
		for (int i = 0; i < dx.length; i++) {
			if (grid[dx[i]][dy[i]] == 0) {
				grid[dx[i]][dy[i]] = 2;
				return;
			}
		}
	}

	public boolean isGoal() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == goal)
					return true;
			}
		}
		return false;
	}

	public String printGrid() {
		String s = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				s += grid[i][j] + "\t";
			}
			s += "\n";
		}
		return s;
	}
	
	public int getMaxCorner() {
		return Math.max(grid[0][0], Math.max(grid[0][size-1], Math.max(grid[size-1][0], 
				grid[size-1][size-1])));
	}

	public static void main(String[] args) throws IOException {
		Grid g = new Grid(4, 2048);
		g.printGrid();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			switch (s) {
			case "w":
				g.move(Operators2048.UP);
				break;
			case "s":
				g.move(Operators2048.DOWN);
				break;
			case "a":
				g.move(Operators2048.LEFT);
				break;
			case "d":
				g.move(Operators2048.RIGHT);
				break;
			}
			g.printGrid();
		}
	}
	
	public boolean isEqual(Grid g) {
		if (this.size != g.size) {
			return false;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != g.grid[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int getNumMerges() {
		int numMerges = 0;
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				for (int j2 = 0; j2 < dy.length; j2++) {
					int nx = i + dx[j2], ny = j + dy[j2];
					if (nx >=0 && ny >=0 && nx < grid.length && ny < grid[i].length) {
						if (grid[i][j] == grid[nx][ny] && grid[i][j]!=0) {
							numMerges++;
						}
					}
				}
			}
		}
		return numMerges;
	}
	
	private int log(int a) {
		int sum = 0;
		while (a>0) {
			sum++;
			a>>=1;
		}
		return sum;
	}
	
	public int getMaxMerge() {
		int numMerges = 0;
		int dx[] = {1, 0, -1, 0};
		int dy[] = {0, 1, 0, -1};
		int pow = 1;
		for (int k=1;k<=11;k++) {
			int sum = 0;
			pow<<=1;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if (grid[i][j]==pow) sum++;
				}
			}
			numMerges += (sum);
		}
		return numMerges;	}

}
