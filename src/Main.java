import problem.Operators;
import problem.Operators2048;
import problem.Problem2048;
import search.Solution;


public class Main {

	public static void main(String[] args) {
		Problem2048 problem = new Problem2048(11);
		Solution s = problem.solve("GR1", true);
		System.out.println(s.getGoalNode().toString());
		System.out.println(s.getGoalNode().returnPath());
	}
	
}
