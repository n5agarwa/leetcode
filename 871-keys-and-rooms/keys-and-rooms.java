class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        int visitedCount = 0;

        // Room 0 is unlocked at the start.
        visited[0] = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            visitedCount++;

            // Every number in this room is a key to another room.
            for (int key : rooms.get(room)) {
                if (visited[key]) {
                    continue;
                }

                // Once we find a new key, mark that room as reachable
                // and explore the keys inside it later.
                visited[key] = true;
                stack.push(key);
            }
        }

        // If DFS reached every room, then every room can be visited.
        return visitedCount == rooms.size();
    }
}