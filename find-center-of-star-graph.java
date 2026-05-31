import java.util.*;

class FindCenterOfStarGraph {
    public static void main(String[] args) {
        System.out.println("FindCenterOfStarGraph is runnable. Add test cases in main().");
    }
    public int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
}