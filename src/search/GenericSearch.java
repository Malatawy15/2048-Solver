package search;

import java.util.ArrayList;
import java.util.Collection;

import problem.Problem;
import problem.State;
import problem.State2048;

public abstract class GenericSearch {

	Problem problem;
	/*
	 * This collection will be instantiated using either queue/stack/priority
	 * queue, in the different classes for the search strategies.
	 */
	Collection<SearchTreeNode> queue;
	int numNodes;

	public GenericSearch(Problem problem, Collection<SearchTreeNode> queue) {
		this.problem = problem;
		this.queue = queue;
		numNodes = 0;
	}
	
	public GenericSearch(Problem problem) {
		this.problem = problem;
		numNodes = 0;
	}

	public void setQueue(Collection<SearchTreeNode> queue) {
		this.queue = queue;
	}

	public SearchTreeNode createSearchTreeNode(State state,
			SearchTreeNode parentNode, int depth, int pathCost) {
		return new SearchTreeNode(state, parentNode, depth, pathCost);
	}
	
	public SearchTreeNode createSearchTreeNode(State state,
			SearchTreeNode parentNode) {
		return new SearchTreeNode(state, parentNode, parentNode.getDepth()+1, problem.pathCost(state));
	}

	public Collection<SearchTreeNode> createSearchTreeNodes(SearchTreeNode parentNode,
			Collection<State> childrenStates) {
		Collection<SearchTreeNode> childNodes = new ArrayList<SearchTreeNode>();
		for (State childState : childrenStates) {
			childNodes.add(createSearchTreeNode(childState, parentNode));
		}
		return childNodes;
	}

	public Solution search(State state, int goalN) {
		SearchTreeNode init = createSearchTreeNode(state, null, 0, 0);
		queue.add(init);
		while (!queue.isEmpty()) {
			SearchTreeNode node = dequeue();
			System.out.println(node.toString());
			if (node.state.isGoal()) {
				return new Solution(node, problem.pathCost(node.state),
						numNodes);
			}
			// Expand node and add all its children to the queue.
			numNodes++;
			Collection<SearchTreeNode> childrenNodes = createSearchTreeNodes(
					node, node.state.getChildrenStates(problem));
			for (SearchTreeNode childNode : childrenNodes) {
				enqueue(childNode);
			}
		}
		return null;
	}

	public abstract void enqueue(SearchTreeNode node);

	public abstract SearchTreeNode dequeue();

}
