package search;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;

import problem.Problem;

public class IDSearch extends GenericSearch{
	
	DLSearch depthLimitedSearch;
	int depth;
	
	public IDSearch(Problem problem){
		super(problem, new Stack<SearchTreeNode>());
		depth = 0;
		depthLimitedSearch = new DLSearch(problem, depth);
	}
	
	public void enqueue(SearchTreeNode s) {
		depthLimitedSearch.enqueue(s);
	}

	public SearchTreeNode dequeue() {
		Stack<SearchTreeNode> p = (Stack<SearchTreeNode>) queue;
		SearchTreeNode s = p.pop();
		if (p.isEmpty()) {
			depthLimitedSearch = new DLSearch(problem, depth++);
			depthLimitedSearch.enqueue(createSearchTreeNode(problem.getInitialState(), null, 0, 0));
		}
		return s;
	}

}