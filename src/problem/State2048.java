package problem;

public class State2048 extends State {
	int score;
	Grid grid;
	
	public State2048() {
		super();
		grid = new Grid();
		score = 0;
	}
	
	public State2048(Grid grid, int score) {
		this.grid = grid;
		this.score = score;
	}
	
	public void setAsGoalState() {
		isGoal = true;
	}
}
