package search;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Stack;

import problem.Problem;

public class IDSearch extends GenericSearch{
	
	public IDSearch(Problem problem){
		super(problem, new Stack<SearchTreeNode>());
	}
	
	public void enqueue(SearchTreeNode s) {
		Stack<SearchTreeNode> p = (Stack<SearchTreeNode>) queue;
		p.push(s);
	}

	public SearchTreeNode dequeue() {
		Stack<SearchTreeNode> p = (Stack<SearchTreeNode>) queue;
		return p.pop();
	}

}