// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []

import DataStructures.ListNode;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (true) {
            ListNode min = null;
            int minIndex = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;

                if (min == null || min.val > lists[i].val) {
                    min = lists[i];
                    minIndex = i;
                }
            }

            if (min == null)
                break;

            lists[minIndex] = lists[minIndex].next;

            curr.next = min;
            curr = curr.next;
        }
        return head.next;
    }
}
