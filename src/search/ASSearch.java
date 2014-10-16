package search;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import problem.Problem;

public class ASSearch extends GenericSearch{
	
	int heuristic; 
	
	public ASSearch(Problem problem, int heuristic, boolean visualize){
		super(problem, visualize);
		this.heuristic = heuristic;
		setQueue(new PriorityQueue<SearchTreeNode>(11, getComparator(heuristic)));
	}
	
	private Comparator<SearchTreeNode> getComparator(int heuristic) {
		if (heuristic == 1) {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode arg0, SearchTreeNode arg1) {
					// TODO A* heuristic #1 + path cost
					return 0;
				}
			};
		} else {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode arg0, SearchTreeNode arg1) {
					// TODO A* heuristic #2 + path cost
					return 0;
				}
			};
		}
	}

	@Override
	public void enqueue(SearchTreeNode s) {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		p.add(s);
	}

	@Override
	public SearchTreeNode dequeue() {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		return p.poll();
	}
	
}