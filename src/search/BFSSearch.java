package search;

import java.util.LinkedList;

import problem.Problem;

public class BFSSearch extends GenericSearch{
	
	public BFSSearch(Problem problem, boolean visualize) {
		super(problem, new LinkedList<SearchTreeNode>(), visualize);
	}

	@Override
	public void enqueue(SearchTreeNode s) {
		LinkedList<SearchTreeNode> q = (LinkedList<SearchTreeNode>) queue;
		q.addLast(s);
	}

	@Override
	public SearchTreeNode dequeue() {
		LinkedList<SearchTreeNode> q = (LinkedList<SearchTreeNode>) queue;
		return q.removeFirst();
	}

}
