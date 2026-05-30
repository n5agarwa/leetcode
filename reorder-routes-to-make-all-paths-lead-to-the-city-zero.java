class Solution {
    int idx = 0;

    public int minReorder(int n, int[][] connections) {
        int[] head = new int[n];
        Arrays.fill(head, -1);

        int m = connections.length;
        int[] to = new int[2 * m];
        int[] next = new int[2 * m];
        int[] cost = new int[2 * m];

        for (int[] e : connections) {
            add(e[0], e[1], 1, head, to, next, cost);
            add(e[1], e[0], 0, head, to, next, cost);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, head, to, next, cost, visited);
    }

    private void add(int from, int dest, int c,
                     int[] head, int[] to, int[] next, int[] cost) {
        to[idx] = dest;
        cost[idx] = c;
        next[idx] = head[from];
        head[from] = idx++;
    }

    private int dfs(int city, int[] head, int[] to, int[] next,
                    int[] cost, boolean[] visited) {
        visited[city] = true;

        int ans = 0;

        for (int edge = head[city]; edge != -1; edge = next[edge]) {
            int nextCity = to[edge];

            if (!visited[nextCity]) {
                ans += cost[edge];
                ans += dfs(nextCity, head, to, next, cost, visited);
            }
        }

        return ans;
    }
}