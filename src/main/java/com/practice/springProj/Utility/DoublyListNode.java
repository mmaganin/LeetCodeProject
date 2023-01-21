package com.practice.springProj.Utility;

public class DoublyListNode {
    public int val;
    public DoublyListNode next;
    public DoublyListNode prev;
    public DoublyListNode() {}
    public DoublyListNode(int val) { this.val = val; }
    public DoublyListNode(int val, DoublyListNode next, DoublyListNode prev) { this.val = val; this.next = next; this.prev = prev; }

    public ListNode intArrToListNode(int[] nums){
        if(nums == null || nums.length == 0) return null;
        else if(nums.length == 1) return new ListNode(nums[0]);
        ListNode head = new ListNode();
        ListNode node = head;

        for(int i = 0; i < nums.length - 1; i++){
            node.val = nums[i];
            node.next = new ListNode(nums[i + 1]);
            node = node.next;
        }

        return head;
    }

    public int[] listNodeToIntArr(ListNode head){
        if(head == null) return null;
        int[] nums;
        int listLen = 0;
        int i = 0;

        ListNode node = head;
        while(node != null){
            listLen++;
            node = node.next;
        }

        nums = new int[listLen];
        node = head;
        while(node != null){
            nums[i] = node.val;
            node = node.next;
            i++;
        }

        return nums;
    }

    public boolean isListNodesEqual(ListNode head1, ListNode head2){
        ListNode node1 = head1;
        ListNode node2 = head2;

        while(node1 != null){
            if(node2 == null) return false;
            else if(node1.val != node2.val) return false;
            node2 = node2.next;
            node1 = node1.next;
        }

        return node2 == null;
    }
}
