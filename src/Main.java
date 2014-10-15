import problem.Problem2048;


public class Main {

	public static void main(String[] args) {
		Problem2048 problem = new Problem2048(2);
		System.out.println(problem.solve("BF", true).getCost());
	}
	
}
