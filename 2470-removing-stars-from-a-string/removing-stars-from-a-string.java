class Solution {
    public String removeStars(String s) {
        StringBuilder stack = new StringBuilder();
        int length = 0;
        for (char c : s.toCharArray()) {
            length = stack.length();
            if (c == '*')
                stack.deleteCharAt(length - 1);
            else
                stack.append(c);

        }
        return stack.toString();
    }
}