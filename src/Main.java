import problem.Problem2048;
import problem.State2048;
import search.Solution;


public class Main {

	public static void main(String[] args) {
		Problem2048 problem = new Problem2048(2);
		Solution s = problem.solve("BF", true);
		System.out.println(s.getCost());
		//((State2048)s.getGoalNode().getState()).getGrid().printGrid();
	}
	
}
