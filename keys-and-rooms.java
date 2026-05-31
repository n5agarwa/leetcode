import java.util.*;

class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Collections.<Integer>emptyList()
        );
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
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