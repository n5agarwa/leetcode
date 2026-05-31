import java.util.*;

class StockSpanner {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            System.out.print(stockSpanner.next(price) + " ");
        }
        System.out.println();
    }
    private class Pair {
        int span;
        int price;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    Deque<Pair> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price)
            span += stack.pop().span;
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */