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
	
	public abstract List<State> getChildrenStates(Problem problem);
	
	public abstract boolean isGoal();
}
