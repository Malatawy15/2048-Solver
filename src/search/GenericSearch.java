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
		//TODO apply all operators to init, using the queuing function, applying the goal test
		// to every node. When goal test succeds, create a solution object.
		SearchTreeNode init = createSearchTreeNode(state);
		queue.add(init);
		while(!queue.isEmpty()) {
			SearchTreeNode node = dequeue();
			if (node.state.isGoal()) {
				// TODO create solution and return it.
			}
			// Expand node and add all its children to the queue.
			Collection<SearchTreeNode> childrenNodes = createSearchTreeNodes(node.state, node.state.getChildrenStates(problem));
			for (SearchTreeNode childNode : childrenNodes) {
				enqueue(childNode);
			}
		}
		//enqueue();
		return null;
	}
	
	public abstract void enqueue(SearchTreeNode s);
	
	public abstract SearchTreeNode dequeue();
	
}
