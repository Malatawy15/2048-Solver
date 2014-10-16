package problem;

import java.util.List;

public abstract class State {
	boolean isGoal;
	
	public State() {
		isGoal = false;
	}
	
	public abstract List<State> getChildrenStates(Problem problem);
	
	public abstract boolean isGoal();
}
