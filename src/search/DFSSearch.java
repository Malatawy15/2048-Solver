package search;

import java.util.Collection;
import java.util.Stack;

import problem.Problem;

public class DFSSearch extends GenericSearch{
	
	public DFSSearch(Problem problem){
		super(problem, new Stack<SearchTreeNode>());
	}
	
	public void enqueue(SearchTreeNode s) {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		st.push(s);
	}

	public SearchTreeNode dequeue() {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		return st.pop();
	}

}
