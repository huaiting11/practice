package linked;

import java.time.Period;

public class Q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return  l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val  < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
      ListNode prevNode = new ListNode(-1);
      ListNode prev = prevNode;
      while (l1 != null && l2 != null){
          if(l1.val < l2.val){
              prev.next = l1;
              l1 = l1.next;
          }else {  //�п�������ȵ�ֵ��
              prev.next  = l2;
              l2 = l2.next;
          }
          prev = prev.next;
      }
      prev.next = l1 == null ? l2 : l1;
      return  prevNode.next;
    }

}
