package problem;

import java.util.ArrayList;
import java.util.List;

public class State2048 extends State {
	int score;
	Grid grid;
	
	public State2048() {
		super();
		grid = new Grid(4);
		score = 0;
	}
	
	public State2048(Grid grid) {
		this.grid = grid;
	}
	
	public void setAsGoalState() {
		isGoal = true;
	}

	public List<State> getChildrenStates(Problem problem) {
		ArrayList<State> children = new ArrayList<State>();
		for (problem.Operators2048.Operators op : Operators2048.Operators.values()) {
			children.add(new State2048(this.grid.move(op)));
		}
		return children;
	}

}
