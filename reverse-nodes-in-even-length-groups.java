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
class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head, groupStart, groupEnd, prevGroupEnd = dummy, nextGroupstart;
        int groupSize = 1;

        while (curr != null) {
            int len = 0;
            groupStart = curr;
            groupEnd = curr;

            while (groupEnd != null && len < groupSize) {
                len++;
                if (len == groupSize || groupEnd.next == null)
                    break;
                groupEnd = groupEnd.next;
            }
            nextGroupstart = groupEnd.next;

            if (len % 2 == 0) {
                //Reverse the list
                groupEnd.next = null;
                ListNode reverseHead = reverseList(groupStart);

                //Connect the pointers
                prevGroupEnd.next = reverseHead;
                groupStart.next = nextGroupstart;
                
                //Set pointers
                prevGroupEnd = groupStart;
                curr = nextGroupstart;
            }
            else{
                prevGroupEnd = groupEnd;
                curr = nextGroupstart;
            }
            groupSize++;
        }
    
    return dummy.next;
    }
}
