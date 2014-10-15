package search;

import java.util.Collection;
import java.util.PriorityQueue;

import problem.Problem;


public class GRSearch extends GenericSearch{
	
	int heuristic; 
	/*
	 * TODO: Set the heuristic method in SearchTreeNode so that the compareTo function works
	 * according to the correct heuristic.
	 */
	
	public GRSearch(Problem problem, int heuristic){
		super(problem, new PriorityQueue<SearchTreeNode>());
		
	}

	@Override
	public Collection<SearchTreeNode> enqueue(SearchTreeNode s) {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		p.add(s);
		return p;
	}

	@Override
	public SearchTreeNode dequeue() {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		return p.poll();
	}
	
}
