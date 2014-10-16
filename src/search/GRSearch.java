package search;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import problem.Problem;

public class GRSearch extends GenericSearch {

	int heuristic;

	/*
	 * TODO: Set the heuristic method in SearchTreeNode so that the compareTo
	 * function works according to the correct heuristic.
	 */

	public GRSearch(Problem problem, int heuristic) {
		super(problem);
		this.heuristic = heuristic;
		setQueue(new PriorityQueue<SearchTreeNode>(11, getComparator(heuristic)));
	}

	private Comparator<SearchTreeNode> getComparator(int heuristic) {
		if (heuristic == 1) {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode arg0, SearchTreeNode arg1) {
					// TODO Greedy heuristic #1
					return 0;
				}
			};
		} else {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode arg0, SearchTreeNode arg1) {
					// TODO Greedy heuristic #2
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
