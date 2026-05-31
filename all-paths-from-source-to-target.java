import java.util.*;

class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resultpath = new ArrayList<>();
        if (graph == null || graph.length == 0)
            return resultpath;

        List<Integer> currentPath = new ArrayList<>();

        dfs(graph, 0, currentPath, resultpath);

        return resultpath;
    }

    private void dfs(int[][] graph, int node, List<Integer> currentPath, List<List<Integer>> resultPath) {
        currentPath.add(node); //Add source before neighbours

        if (node == graph.length - 1)//reached end -> store the path
            resultPath.add(new ArrayList<>(currentPath));
        else {
            //get all neighbours
            for (int neighbour : graph[node])
                //further recursive to neighbour
                dfs(graph, neighbour, currentPath, resultPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}