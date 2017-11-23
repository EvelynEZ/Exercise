//rehasing
import java.io.*;
import java.util.*;
public class Rehashing{
   public static void main(String[] args){
      ListNode[] hashTable = new ListNode[20];
      hashTable[0] = new ListNode(80);
      hashTable[7] = new ListNode(187);
      hashTable[9] = new ListNode(49);
      hashTable[9].next = new ListNode(109);
      hashTable[10] = new ListNode(10);
      hashTable[10].next = new ListNode(50);
      hashTable[10].next.next = new ListNode(-10);
      hashTable[12] = new ListNode(12);
      hashTable[13] = new ListNode(53);
      hashTable[13].next = new ListNode(133);
      hashTable[13].next.next = new ListNode(153);
      hashTable[13].next.next = new ListNode(93);
      hashTable[15] = new ListNode(15);
      hashTable[16] = new ListNode(36);
      hashTable[17] = new ListNode(-3);
      hashTable[18] = new ListNode(118);
      hashTable[19] = new ListNode(159);
      hashTable[19].next = new ListNode(139);
      
      ListNode[] newTable = rehashing(hashTable);
      for(ListNode node: newTable){
         while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
         }
         System.out.println();  
      }
      
   }
    public static ListNode[] rehashing(ListNode[] hashTable) {
        int newSize = hashTable.length * 2;
        ListNode[] newTable = new ListNode[newSize];
        for(ListNode node:hashTable){
            while(node != null){
                int index = hashcode(node.val, newSize);
                ListNode current = new ListNode(node.val);
                if(newTable[index] == null){
                    newTable[index] = current;
                } else {
                     ListNode existingNode = newTable[index];
                    while(existingNode.next!=null){
                        existingNode = existingNode.next;
                    }
                    existingNode.next = current;
                }
                node = node.next;
            }
        }
        return newTable;
    }
    public static int hashcode(int key, int capacity) {
        int code  = key % capacity;
        if(code < 0) code += capacity;
        return code;
    }
}