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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //중간 노드찾기

        ListNode mid = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode tmpNode = new ListNode(0);
        ListNode prev = tmpNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tmpNode.next = left;
                left = left.next;
            } else {
                tmpNode.next = right;
                right = right.next;
            }
            tmpNode = tmpNode.next;
        }

        if (left != null) {
            tmpNode.next = left;
        }

        if (right != null) {
            tmpNode.next = right;
        }
        return prev.next;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode faster = head.next;
        ListNode slow = head;

        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }
        //연결을 끊어준다.
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
                                                  }