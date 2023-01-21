package com.practice.springProj.Utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    static ListNode listNode1;
    static int[] intArr1;

    static{
        listNode1 = new ListNode(1);
        ListNode node = listNode1;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);

        intArr1 = new int[]{1,2,3,4,5};
    }

    @Test
    void testIntArrToListNode() {
        ListNode actual = listNode1.intArrToListNode(intArr1);
        assertTrue(listNode1.isListNodesEqual(listNode1, actual));
    }

    @Test
    void testListNodeToIntArr() {
        int[] actual = listNode1.listNodeToIntArr(listNode1);
        assertArrayEquals(intArr1, actual);
    }

    @Test
    void testIsListNodesEqual_TrueCase() {
        assertTrue(listNode1.isListNodesEqual(listNode1, listNode1));
    }

    @Test
    void testIsListNodesEqual_FalseCase() {
        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(6);

        assertFalse(listNode1.isListNodesEqual(listNode1, listNode2));
    }
}