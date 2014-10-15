package search;

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
	
	public Solution search(State state, int goalN) {
		//TODO apply all operators to init, using the queuing function, applying the goal test
		// to every node. When goal test succeds, create a solution object.
		SearchTreeNode init = new SearchTreeNode(state);
		queue.add(init);
		while(!queue.isEmpty()) {
			SearchTreeNode node = dequeue();
			if (node.state.isGoal()) {
				// TODO create solution and return it.
			}
			// TODO expand node and add all its children to the queue.
		}
		//enqueue();
		return null;		
	}
	
	public abstract Collection<SearchTreeNode> enqueue();
	
	public abstract SearchTreeNode dequeue();
	
}
