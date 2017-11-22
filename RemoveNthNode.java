import java.io.*;
import java.util.*;
public class RemoveNthNode{
   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode p = head;
      p.next = new ListNode(2);
      p = p.next;
      p.next = new ListNode(3);
      p = p.next;
      p.next = new ListNode(4);
      p = p.next;
      p.next = new ListNode(5);
      p = p.next;
      head = removeNthFromEnd(head,4);
      while(head != null) {
         System.out.print(head.val + " ");
         head = head.next;
      }
   }
   public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int count = 0;
        while(p!= null){
            p = p.next;
            count++;
        }
        if(n>count) return head;
        if(n == count) return head.next;
        ListNode[] array = new ListNode[count];
        for(int i = 0; i < count; i++){
            array[i] = new ListNode(0);
            array[i].next = head;
            head = head.next;
        }
        array[count-n-1].next.next = array[count-n].next.next;
        return array[0].next;    
    }
}