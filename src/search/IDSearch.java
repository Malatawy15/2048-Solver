package search;
import java.util.Collection;
import java.util.Stack;

import problem.Problem;

public class IDSearch extends GenericSearch{
	
	public IDSearch(Problem problem){
		super(problem, new Stack<SearchTreeNode>());
	}
	
	public Collection<SearchTreeNode> enqueue(SearchTreeNode s) {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		st.push(s);
		return st;
	}

	public SearchTreeNode dequeue() {
		Stack<SearchTreeNode> st = (Stack<SearchTreeNode>) queue;
		return st.pop();
	}

}