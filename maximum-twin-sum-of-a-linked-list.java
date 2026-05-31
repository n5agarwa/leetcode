import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        System.out.println("MaximumTwinSumOfALinkedList is runnable. Add test cases in main().");
    }
    public int pairSum(ListNode head) {
       ListNode slow = head, fast = head;

       //Middle transition
       while(fast!=null && fast.next!=null)
       {
        slow = slow.next;
        fast = fast.next.next;
       } 

       //Reverse

       ListNode prev = null, next = null;
       while(slow!=null)
       {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
       }

       ListNode first = head, second = prev;
       int maxsum = 0;
       while(second!=null)
       {
        maxsum = Math.max(maxsum, first.val + second.val);
        first = first.next;
        second = second.next;
       }
       return maxsum;
    }
}