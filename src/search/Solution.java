package search;

public class Solution {

	SearchTreeNode goalNode;
	int cost;
	int numNodes;
	
	/**
	 * @param goalNode
	 * @param cost
	 * @param numNodes
	 */
	public Solution(SearchTreeNode goalNode, int cost, int numNodes) {
		this.goalNode = goalNode;
		this.cost = cost;
		this.numNodes = numNodes;
	}

	public SearchTreeNode getGoalNode() {
		return goalNode;
	}

	public void setGoalNode(SearchTreeNode goalNode) {
		this.goalNode = goalNode;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumNodes() {
		return numNodes;
	}

	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}
}
