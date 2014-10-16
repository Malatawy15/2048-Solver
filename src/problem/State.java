package problem;

import java.util.List;

public abstract class State {
	boolean isGoal;
	Operators operator;
	
	public State() {
		isGoal = false;
	}
	
	public Operators getOperator() {
		return operator;
	}
	
	public abstract int getHeuristic1();
	
	public abstract int getHeuristic2();
	
	public abstract List<State> getChildrenStates(Problem problem);
	
	public abstract boolean isGoal();
	
	public abstract boolean isEqual(State state);
}
