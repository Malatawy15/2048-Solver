package search;

import java.util.Collection;
import java.util.LinkedList;

import problem.Problem;

public class BFSSearch extends GenericSearch{
	
	public BFSSearch(Problem problem) {
		super(problem, new LinkedList<SearchTreeNode>());
	}

	@Override
	public Collection<SearchTreeNode> enqueue(SearchTreeNode s) {
		LinkedList<SearchTreeNode> q = (LinkedList<SearchTreeNode>) queue;
		q.addLast(s);
		return q;
	}

	@Override
	public SearchTreeNode dequeue() {
		LinkedList<SearchTreeNode> q = (LinkedList<SearchTreeNode>) queue;
		return q.removeFirst();
	}

}
