class Solution {
    public String removeStars(String s) {
        char stack [] = s.toCharArray();
        int top = 0;

        for(char c : stack){
            if(c == '*')
                top--;
            else
                stack[top++] = c;
        }
        return new String(stack, 0, top);
    }
}