package problem;

import java.util.HashSet;

public abstract class Problem {

	Operators operators;
	State initialState;
	HashSet<State> stateSpace;
	
	public Problem(Operators ops, State init) {
		operators = ops;
		initialState = init;
		stateSpace = new HashSet<State>();
	}

	public abstract boolean goalTest(State state);
	
	public abstract int pathCost(State childState);
	
	public abstract int edgeCost(State parentState, State childState);

	public State getInitialState() {
		return initialState;
	}
	
}
