package search;

import java.util.Collection;
import java.util.Stack;

import problem.Problem;

public class DLSearch extends GenericSearch {
	
	int depthLimit;
	Stack<SearchTreeNode> stack;

	public DLSearch(Problem problem, int depthLimit, Stack<SearchTreeNode> stack) {
		super(problem, stack);
		this.depthLimit = depthLimit;
	}

	@Override
	public void enqueue(SearchTreeNode s) {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		if (s.getDepth() <= depthLimit) {
			st.push(s);	
		}
	}

	@Override
	public SearchTreeNode dequeue() {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		return st.pop();
	}

}
