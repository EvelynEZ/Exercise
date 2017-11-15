
import java.io.*;
import java.util.*;

public class mergeLists {

   public static void main(String[] args) {
      //System.out.println(isValid("({}[])"));
   }
    
   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null && l2 == null){
         return null;
      }
      ListNode cur = new ListNode((l1==null)?0:l1.val + (l2==null)?0:l2.val);
      cur.next = mergeTwoLists((l1==null)?null:l1.next + (l2==null)?null:l2.next);
      return cur;
   }
   
}