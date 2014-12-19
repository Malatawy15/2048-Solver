import problem.Problem2048;
import search.Solution;

public class Main {

	public static void main(String[] args) {
		Problem2048 problem = new Problem2048(11);
		Solution s = problem.solve("AS2", true);
		System.out.println(s.getGoalNode().toString());
		System.out.println(s.getGoalNode().returnPath());
	}
	
}
