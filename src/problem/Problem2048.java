package problem;

import search.*;

public class Problem2048 extends Problem {
	
	int goalNumber;
	
	public Problem2048(int M) {
		super(Operators2048.values(), genGrid((1<<M)));
		goalNumber = (1<<M);
	}

	private static State2048 genGrid(int goalNumber) {
		return new State2048(new Grid(4, goalNumber), null);
	}

	public boolean goalTest(State state) {
		State2048 state2048 = (State2048) state;
		return state2048.grid.isGoal();
	}

	public int pathCost(State childState) {
		State2048 childSt = (State2048) childState;
		int cost = 0;
		for (int i = 0; i < childSt.grid.grid.length; i++) {
			for (int j = 0; j < childSt.grid.grid[i].length; j++) {
				cost += blockCost(childSt.grid.grid[i][j]);
			}
		}
		return cost;
	}

	public int edgeCost(State parentState, State childState) {
		return pathCost(childState) - pathCost(parentState);
	}
	
	//TODO fix this function
	private int blockCost(int n) {
		int cost = 0;
		int counter = n;
		while(counter > 2) {
			cost += n;
			counter >>= 1;
		}
		return cost;
	}
	
	public Solution solve(String strategy, boolean visualize) {
		return search(initialState, goalNumber, strategy, visualize);
	}
	
	public Solution search(State init, int goalN, String strategy, boolean visualize) {
		GenericSearch searcher = null;
		switch (strategy) {
		case "DF":
			searcher = new DFSSearch(this);
			break;
		case "BF":
			searcher = new BFSSearch(this);
			break;
		case "ID":
			searcher = new IDSearch(this);
			break;
		case "GR1":
			searcher = new GRSearch(this, 1);
			break;
		case "GR2":
			searcher = new GRSearch(this, 2);
			break;
		case "AS1":
			searcher = new ASSearch(this, 1);
			break;
		case "AS2":
			searcher = new ASSearch(this, 2);
			break;
			
		}
		return searcher.search(init, goalN);
	}

}
