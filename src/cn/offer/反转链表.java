package cn.offer;

import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class 反转链表 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
      ListNode current = head;
      ListNode prev = null;
      ListNode reverseHead = null;
      while (current != null){
          ListNode currentNext = current.next;
          if(currentNext == null)
              reverseHead = current;
          current.next = prev;
          prev = current;
          current = currentNext;
      }
      return reverseHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        反转链表 test = new 反转链表();
        ListNode node = test.ReverseList(n1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
