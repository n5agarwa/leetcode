import java.util.*;

class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println("NumberOfProvinces is runnable. Add test cases in main().");
    }
    int parent[];

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (isConnected[i][j] == 1)
                    union(i, j);

        int provincesCount = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == i)
                provincesCount++;
        }
        return provincesCount;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}