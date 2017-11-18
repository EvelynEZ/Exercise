//1-2-2-1 or 1-2-3-2-1 odd/even number of nodes must both be considered.
import java.io.*;
import java.util.*;
public class PalindromeLinkedList{
   public static void main(String[] args) {
      ListNode head = new ListNode(1);
      ListNode p = head;
    //  p.next = new ListNode(2);
   //   p = p.next;
  //    p.next = new ListNode(3);
  //    p = p.next;
   //   p.next = new ListNode(2);
   //   p = p.next;
      p.next = new ListNode(1);
      System.out.println(isPalindrome(head));
   }
   
   public static boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null) 
         return true;
        //get mid, 2 pointers
      ListNode mid = head;
      ListNode faster = head;
      int length = 1;
      while(faster != null && faster.next!=null){
         mid = mid.next;
         faster = faster.next.next;
         if(faster == null) length++;
         else length+= 2;
      }
        //get mid-1th ListNode
      ListNode l1 = head;
      while(l1.next != mid){
         l1 = l1.next;
      }
        //reverse 1 to mid-1
      ListNode prev = null;
      ListNode cur = head;
      while(cur != mid){
         ListNode tmp = cur.next;
         cur.next = prev;
         prev = cur;
         cur = tmp;
      }
      ListNode l2 = mid;
      if(length % 2 == 1){
         l2 = l2.next;
      }
        // compare 1 to (mid-1) with (mid+1) to end
      while(l1 != null){
         if(l1.val != l2.val) 
            return false;
         l1 = l1.next;
         l2 = l2.next;
      }
      return true;
        
   }
}