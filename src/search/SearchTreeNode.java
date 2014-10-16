package search;
import problem.Operators;
import problem.State;
public class SearchTreeNode{

	//TODO: Need to find a way to reference the operator
	// 5azoo2 el design
	State state;
	SearchTreeNode parent;
	Operators operator;
	int depth;
	int pathCost;
	
	public SearchTreeNode(State state, SearchTreeNode parent, int depth, int pathCost){
		this.state = state;
		this.parent = parent;
		this.operator = state.getOperator();
		this.depth = depth;
		this.pathCost = pathCost;
	}
	
	public String returnPath() {
		if (parent != null) {
			return String.format("%s -> %s", parent.returnPath(), operator.toString());
		} else {
			if (operator == null) {
				return "Init";
			} else {
				return operator.toString();
			}
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public SearchTreeNode getParent() {
		return parent;
	}

	public void setParent(SearchTreeNode parent) {
		this.parent = parent;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getPathCost() {
		return pathCost;
	}

	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}
	
	@Override
	public String toString() {
		return String.format("Node:\nDepth: %d\tScore: %d\n%s\n", depth, pathCost, state.toString());
	}
	
}
