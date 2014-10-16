package problem;

import java.util.ArrayList;
import java.util.List;

public class State2048 extends State {
	int score;
	Grid grid;
	
	public State2048(Grid grid) {
		super();
		this.grid = grid;
		this.score = 0;
	}
	
	public void setAsGoalState() {
		isGoal = true;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	public List<State> getChildrenStates(Problem problem) {
		ArrayList<State> children = new ArrayList<State>();
		for (problem.Operators2048.Operators op : Operators2048.Operators.values()) {
			State2048 newState = new State2048(this.grid.move(op));
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

}
