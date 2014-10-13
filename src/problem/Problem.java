package problem;

import java.util.HashSet;

public abstract class Problem {

	Enum<?> operators;
	State initialState;
	HashSet<State> stateSpace;

	public abstract boolean goalTest(State state);
	
	public abstract int pathCost(State state);
	
}
