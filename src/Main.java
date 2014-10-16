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
		/*Operators op = Operators2048.DOWN;
		Operators[] op1 = op.getClass().getEnumConstants();
		for (int i=0;i<op1.length;i++) {
			System.out.println(op1[i].toString());
		}
		System.out.println(op.toString());*/
		//((State2048)s.getGoalNode().getState()).getGrid().printGrid();
	}
	
}
