package problem;

import java.util.ArrayList;
import java.util.List;

public class State2048 extends State {
	int score;
	Grid grid;
	
	public State2048(Grid grid, Operators op) {
		super();
		this.grid = grid;
		this.score = 0;
		operator = op;
	}
	
	public void setAsGoalState() {
		isGoal = true;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public List<State> getChildrenStates(Problem problem) {
		ArrayList<State> children = new ArrayList<State>();
		for (Operators2048 op : Operators2048.values()) {
			State2048 newState = new State2048(this.grid.move(op), op);
			newState.setScore(problem.pathCost(newState));
			children.add(newState);
		}
		return children;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean isGoal() {
		return grid.isGoal();
	}
	
	@Override
	public String toString() {
		return grid.printGrid();
	}

}
