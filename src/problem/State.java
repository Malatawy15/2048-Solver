package problem;

public abstract class State {
	boolean isGoal;
	
	public State() {
		isGoal = false;
	}
	
	public boolean isGoal() {
		return isGoal;
	}
}
