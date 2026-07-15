package LinkedList;

// ques: https://neetcode.io/problems/linked-list-cycle-detection/question?list=neetcode250

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null)
            return false;
        ListNode slow = head.next, fast=head.next.next;

        while(true){
            if(fast == null || fast.next == null)
                break;
            if(slow == fast)
                return true;

            slow = slow.next;
            fast=fast.next.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast=head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
