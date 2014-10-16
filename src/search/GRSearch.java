package search;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import problem.Problem;

public class GRSearch extends GenericSearch {

	int heuristic;

	public GRSearch(Problem problem, int heuristic) {
		super(problem);
		this.heuristic = heuristic;
		setQueue(new PriorityQueue<SearchTreeNode>(11, SearchTreeNodeComparator.getComparator(heuristic)));
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
