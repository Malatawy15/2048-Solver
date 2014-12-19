package search;

import java.util.Comparator;

public class SearchTreeNodeComparator {
	
	public static Comparator<SearchTreeNode> getComparator(int heuristic, final boolean AS) {
		if (heuristic == 1) {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode s1, SearchTreeNode s2) {
					int fn1 = s1.state.getHeuristic1();
					int fn2 = s2.state.getHeuristic1();
					if(AS){
						fn1+= s1.pathCost;
						fn2+= s2.pathCost;
					}
					return fn2 - fn1;
				}
			};
		} else {
			return new Comparator<SearchTreeNode>() {

				public int compare(SearchTreeNode s1, SearchTreeNode s2) {
					int fn1 = s1.state.getHeuristic2();
					int fn2 = s2.state.getHeuristic2();
					if(AS){
						fn1+= s1.pathCost;
						fn2+= s2.pathCost;
					}
					return fn2 - fn1;
				}
			};
		}
	}

}
