package problem;

public class Problem2048 extends Problem {
	
	int goalNumber;
	
	public Problem2048(int M) {
		super(new Operators2048(), genGrid());
		goalNumber = (1<<M);
	}

	private static State2048 genGrid() {
		return new State2048();
	}

	public boolean goalTest(State state) {
		State2048 state2048 = (State2048) state;
		return state2048.grid.isGoal(goalNumber);
	}

	public int pathCost(State parentState, State childState) {
		State2048 childSt = (State2048) childState;
		int cost = 0;
		for (int i = 0; i < childSt.grid.grid.length; i++) {
			for (int j = 0; j < childSt.grid.grid[i].length; j++) {
				cost += blockCost(childSt.grid.grid[i][j]);
			}
		}
		return cost;
	}
	
	private int blockCost(int n) {
		int cost = 0;
		while(n > 2) {
			cost += n;
			n >>= 1;
		}
		return cost;
	}

}
