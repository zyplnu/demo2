package cn.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    //1、根据节点N创建N’，并链接到原始节点之后
    public  RandomListNode Link(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode current = pHead;
        while (pHead != null){
            RandomListNode pNext = pHead.next;
            RandomListNode newNode = new RandomListNode(pHead.label);
            pHead.next = newNode;
            newNode.next = pNext;
            pHead = pNext;
        }
        return current;
    }

    //2、设置复制出来的节点的random
    public  RandomListNode SetRandom(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode current = pHead;
        while (pHead != null){
            if(pHead.random != null){
                pHead.next.random = pHead.random.next;
            }
            pHead = pHead.next.next;
        }
        return current;
    }

    //3、拆分链表
    public  RandomListNode Separate(RandomListNode pHead){
        if(pHead == null)
            return null;
        RandomListNode pCur = pHead;
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        //拆分链表
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }

    public  RandomListNode Clone(RandomListNode pHead){
        Link(pHead);
        SetRandom(pHead);
        return Separate(pHead);
    }

    public static void main(String[] args) {
        RandomListNode pHead = null;
        RandomListNode l1 = new RandomListNode(1);
        RandomListNode l2 = new RandomListNode(2);
        RandomListNode l3 = new RandomListNode(3);
        RandomListNode l4 = new RandomListNode(4);
        RandomListNode l5 = new RandomListNode(5);
        pHead = l1;
        l1.next = l2;
        l1.random = l3;
        l2.next = l3;
        l2.random = l5;
        l3.next = l4;
        l4.next = l5;
        l4.random = l2;
        l4.next = l5;
        //Clone(pHead);
        复杂链表的复制 test = new 复杂链表的复制();

        RandomListNode result = test.Clone(pHead);
        while (result != null){
            System.out.println(result.label);
            result = result.next;
        }
    }
}
