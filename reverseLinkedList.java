import java.io.*;
import java.util.*;

public class reverseLinkedList{
   public static void main(String [] args) {
      ListNode head = new ListNode(1);
      ListNode ptr = head;
      ptr.next = new ListNode(2);
      ptr = ptr.next;
      ptr.next = new ListNode(3);
      ptr = ptr.next;
      ptr.next = new ListNode(4);
      ptr = ptr.next;
      ptr.next = new ListNode(5);
      ptr = ptr.next;
      ptr.next = new ListNode(6);
      ptr = ptr.next;
      ptr.next = new ListNode(7);
      ListNode result  = reverseBetween(head, 1, 2);
      while(result != null){
         System.out.println(result.val);
         result = result.next;
      }
      
   }
   
   public static ListNode reverseBetween(ListNode head, int m, int n) {
      if(head == null || head.next == null) 
         return head;
      if(m == n) 
         return head;
      ListNode before = head;
        
        //locate begin node
      int count = 1;
      while(count < m - 1){
         before = before.next;
         count++;
      }
      
      //ListNode begin = before.next;
      //ListNode end = begin;
      
      ListNode begin= before;
      if(m > 1){
         begin = begin.next;
      }
      ListNode end = begin;
      if(m ==1){
      end = end.next;
      }
        //locate end node
      while (count < n - 1){
         end = end.next;
         count++;
      }
      ListNode after = end.next;
      ListNode newHead  = null;
      while(begin != after){
         ListNode next = begin.next;
         begin.next = newHead;
         newHead = begin;
         begin = next;
      }
      if(m == 1){
      head.next = after;
      return newHead;
      } else {
      before.next.next = after;
      before.next = newHead;
      return head;
      }
   }
      
}