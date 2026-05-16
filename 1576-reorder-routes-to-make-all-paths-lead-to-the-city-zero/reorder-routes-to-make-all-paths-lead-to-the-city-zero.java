class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();

        // Create one adjacency list for each city.
        for (int city = 0; city < n; city++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            // Original road goes from "from" to "to".
            // If we travel this same direction while moving away from city 0,
            // this road must be reversed, so mark it with cost 1.
            graph.get(from).add(new int[] { to, 1 });

            // Traveling from "to" back to "from" already points toward city 0,
            // so this direction does not need a reversal and has cost 0.
            graph.get(to).add(new int[] { from, 0 });
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int reorderCount = 0;

        // Start from city 0 and visit every city through the undirected tree.
        visited[0] = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int city = stack.pop();

            for (int[] edge : graph.get(city)) {
                int nextCity = edge[0];
                int reorderCost = edge[1];

                if (visited[nextCity]) {
                    continue;
                }

                // Add 1 only when the original road points away from city 0.
                reorderCount += reorderCost;
                visited[nextCity] = true;
                stack.push(nextCity);
            }
        }

        return reorderCount;
    }

    private int dfs(int city, List<List<int[]>> graph, boolean visited[]) {
        visited[city] = true;
        int cost = 0;

        for (int[] neighbour : graph.get(city)) {
            int nextCity = neighbour[0];
            int needReverse = neighbour[1];

            if (visited[nextCity])
                continue;
            cost += needReverse;
            cost += dfs(nextCity, graph, visited);
        }
        return cost;
    }
}