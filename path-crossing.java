class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<Long> seen = new HashSet<>();
        seen.add(encode(x, y));

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 'N')
                y++;
            else if (c == 'S')
                y--;
            else if (c == 'E')
                x++;
            else
                x--; // 'W'

            long key = encode(x, y);
            if (seen.contains(key))
                return true;
            seen.add(key);
        }
        return false;
    }

    // Pack (x,y) into one long. Offset to safely handle negatives.
    private long encode(int x, int y) {
        long ox = (long) x + 100_000L;
        long oy = (long) y + 100_000L;
        return (ox << 20) ^ oy; // 20 bits enough for typical constraints
    }
}