package problem;

import java.util.ArrayList;
import java.util.List;

public class State2048 extends State {
	int score;
	Grid grid;
	Operators2048.Operators operator;

	public State2048(Grid grid, Operators2048.Operators operator) {
		super();
		this.grid = grid;
		this.score = 0;
		this.operator = operator;
	}

	public void setAsGoalState() {
		isGoal = true;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<State> getChildrenStates(Problem problem) {
		ArrayList<State> children = new ArrayList<State>();
		for (problem.Operators2048.Operators op : Operators2048.Operators
				.values()) {
			State2048 newState = new State2048(this.grid.move(op), op);
			newState.setScore(problem.pathCost(newState));
			if (!isEqual(newState)) {
				children.add(newState);
			}
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

	public boolean isEqual(State state) {
		State2048 st = (State2048) state;
		return grid.isEqual(st.getGrid());
	}

}
