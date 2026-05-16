class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        //build a graph

        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(new int[] { to, 1 });
            graph.get(to).add(new int[] { from, 0 });
        }
        return dfs(0, graph, visited);
    }

    private int dfs(int city, List<List<int[]>> graph, boolean visited[]) {
        visited[city] = true;
        int cost = 0;

        for(int [] neighbour : graph.get(city)){
            int nextCity = neighbour[0];
            int needReverse = neighbour[1];

            if(visited[nextCity])
                continue;
            cost+=needReverse;
            cost+=dfs(nextCity, graph, visited);
        }
        return cost;
    }
}