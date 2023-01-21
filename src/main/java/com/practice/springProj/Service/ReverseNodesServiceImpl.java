package com.practice.springProj.Service;

import com.practice.springProj.Service.Interfaces.ReverseNodesService;
import com.practice.springProj.Utility.ListNode;
import org.springframework.stereotype.Service;

import java.util.Stack;

//number 25
@Service
public class ReverseNodesServiceImpl implements ReverseNodesService {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLenLinkedList(head);
        ListNode node = head;
        ListNode prevNode = node;
        if(k > len || head.next == null || k == 1){
            return head;
        }

        for(int i = 0; i < len; i++){
            if(i + k > len) break;
            if(i == 0) {
                head = flipNodes(node, k);
                node = head;
            } else {
                prevNode.next = flipNodes(node, k);
                node = prevNode.next;
            }

            prevNode = getNextPrevNode(node, k);
            i += k - 1;
            node = prevNode.next;
        }

        return head;
    }

    public ListNode getNextPrevNode(ListNode head, int i){
        ListNode node = head;
        ListNode prevNode = node;
        while(node != null && i > 0){
            prevNode = node;
            node = node.next;
            i--;
        }
        return prevNode;
    }

    public int getLenLinkedList(ListNode head){
        int i = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            i++;
        }
        return i;
    }

    public ListNode flipNodes(ListNode node, int k){
        Stack<ListNode> nodeStack = new Stack<>();
        ListNode newList;
        ListNode prevNode;
        ListNode output;
        ListNode nodeAfter;

        while(node != null && k > 0){
            nodeStack.push(node);
            node = node.next;
            k--;
        }
        newList = nodeStack.pop();
        nodeAfter = newList.next;
        output = newList;
        while(!nodeStack.isEmpty()){
            prevNode = newList;
            newList = nodeStack.pop();
            prevNode.next = newList;
        }
        newList.next = nodeAfter;

        return output;
    }
}
