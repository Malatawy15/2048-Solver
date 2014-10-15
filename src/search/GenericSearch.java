package search;

import java.util.ArrayList;
import java.util.Collection;

import problem.Problem;
import problem.State;
public abstract class GenericSearch {
	
	Problem problem;
	/*
	 * This collection will be instantiated using either queue/stack/priority queue, in the different 
	 * classes for the search strategies.
	 */
	Collection<SearchTreeNode> queue;
	int numNodes;
	
	public GenericSearch(Problem problem, Collection<SearchTreeNode> queue){
		this.problem = problem;
		this.queue = queue;
		numNodes = 0;
	}
	
	// TODO Fill in those methods to calculate a SearchTreeNode's attributes.
	public SearchTreeNode createSearchTreeNode(State state) {
		return new SearchTreeNode(state);
	}
	
	public SearchTreeNode createSearchTreeNode(State parentState, State childState) {
		return new SearchTreeNode(childState);
	}
	
	public Collection<SearchTreeNode> createSearchTreeNodes(State parentState, Collection<State> childrenStates) {
		Collection<SearchTreeNode> childNodes = new ArrayList<SearchTreeNode>();
		for(State childState : childrenStates) {
			childNodes.add(createSearchTreeNode(parentState, childState));
		}
		return childNodes;
	}
	
	public Solution search(State state, int goalN) {
		SearchTreeNode init = createSearchTreeNode(state);
		queue.add(init);
		while(!queue.isEmpty()) {
			SearchTreeNode node = dequeue();
			// TODO Figure out a way to get the goal number here.
			if (node.state.isGoal(4)) {
				return new Solution(node, problem.pathCost(node.state), numNodes);
			}
			// Expand node and add all its children to the queue.
			numNodes++;
			Collection<SearchTreeNode> childrenNodes = createSearchTreeNodes(node.state, node.state.getChildrenStates(problem));
			for (SearchTreeNode childNode : childrenNodes) {
				enqueue(childNode);
			}
		}
		//enqueue();
		return null;
	}
	
	public abstract void enqueue(SearchTreeNode node);
	
	public abstract SearchTreeNode dequeue();
	
}
