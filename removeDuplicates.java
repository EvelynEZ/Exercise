import java.io.*;
import java.util.*;
//redundant nums

public class removeDuplicates{
   public static void main(String [] args) {
      ListNode head = new ListNode(1);
      ListNode ptr = head;
      ptr.next = new ListNode(1);
      ptr = ptr.next;
      ptr.next = new ListNode(1);
      ptr = ptr.next;
      ptr.next = new ListNode(1);
      head = deleteDuplicates(head);
      while(head != null) {
         System.out.print(head.val + " ");
         head = head.next;
      }
   }

   
   public static ListNode deleteDuplicates(ListNode head) {
      ListNode ptr = head;
      while(ptr != null){
         while(ptr.next != null && ptr.val == ptr.next.val){
            ptr.next = ptr.next.next;
         }
         ptr = ptr.next;
      }
      return head;
   }
}