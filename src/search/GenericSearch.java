package search;

import java.util.Collection;
import problem.State;
public abstract class GenericSearch {

	/*
	 * This collection will be instantiated using either queue/stack/priority queue, in the different 
	 * classes for the search strategies.
	 */
	Collection<SearchTreeNode> queue;
	
	public Solution search(State state, int goalN) {
		//TODO apply all operators to init, using the queuing function, applying the goal test
		// to every node. When goal test succeds, create a solution object.
		SearchTreeNode init = new SearchTreeNode(state);
		
		//enqueue();
		return null;		
	}
	
	public abstract Collection<SearchTreeNode> enqueue();
	
}
