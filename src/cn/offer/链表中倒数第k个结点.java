package cn.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

import java.util.List;

/**
 *  if(head == null || k <= 0)
 return null;
 ListNode node = head;
 int length = 0;
 while (node != null){
 length++;
 node = node.next;
 }
 if(k > length)
 return null;
 int index = length - k + 1;
 ListNode current = head;
 int i = 1;
 while (i < index && current.next != null){
 i++;
 current = current.next;
 }
 return current;
 */
public class 链表中倒数第k个结点 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
       if(head == null || k == 0)
            return null;
       ListNode front = head;
       ListNode rear = null;
       for(int i = 0; i < k - 1; i++){
           if(front.next != null)
               front = front.next;
           else
               throw new RuntimeException("error");
       }
       rear = head;
       while (front.next != null){
           front = front.next;
           rear = rear.next;
       }
       return rear;
    }

    public static void main(String[] args) {
        链表中倒数第k个结点.ListNode n1 = new ListNode(1);
        链表中倒数第k个结点.ListNode n2 = new ListNode(2);
        链表中倒数第k个结点.ListNode n3 = new ListNode(3);
        链表中倒数第k个结点.ListNode n4 = new ListNode(4);
        链表中倒数第k个结点.ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        ListNode node = n1;
        链表中倒数第k个结点 result = new 链表中倒数第k个结点();
        System.out.println(result.FindKthToTail(n1 , 7).val);
    }
}
