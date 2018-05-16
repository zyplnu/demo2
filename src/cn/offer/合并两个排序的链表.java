package cn.offer;
/**
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
       if(list1 == null)
           return list2;
       if(list2 == null)
           return list1;
       ListNode merge = null;
       ListNode current = null;
       while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(merge == null){
                    merge = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(merge == null){
                    merge = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
       }
       if(list1 == null)
           current.next = list2;
       if(list2 == null)
           current.next = list1;
       return merge;
    }

}
