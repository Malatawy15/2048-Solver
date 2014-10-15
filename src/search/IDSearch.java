package search;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;

import problem.Problem;

public class IDSearch extends GenericSearch{
	
	public IDSearch(Problem problem, int heuristic){
		super(problem, new PriorityQueue<SearchTreeNode>());
	}
	
	public Collection<SearchTreeNode> enqueue(SearchTreeNode s) {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		p.add(s);
		return p;
	}

	public SearchTreeNode dequeue() {
		PriorityQueue<SearchTreeNode> p = (PriorityQueue<SearchTreeNode>) queue;
		return p.remove();
	}

}