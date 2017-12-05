import java.io.*;
import java.util.*;
public class FraudDetect{
   public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int val) {
         this.val = val;
         this.next = null;
      }
   }
   public static void main(String[] args){
      String[] ex1 = {"Alice;START",
                        "Bob;START",
                        "Bob;1",
                        "Carson;START",
                        "Alice;15",
                        "Carson;6",
                        "David;START",
                        "David;24",
                        "Evil;START",
                        "Evil;24",
                        "Evil;START",
                        "Evil;18",
                        "Fiona;START"};
      String[] ex2 = {"Tom;START",
                        "Jeremy;START",
                        "David;START",
                        "Jeremy;4",
                        "David;3",
                        "James;START",
                        "Matt;START",
                        "James;6",
                        "Nick;START",
                        "Tom;2",
                        "Matt;5",
                        "Nick;7"};
      String[] ex3 = {"Nick;START",
                        "Jeremy;START",
                        "Leah;START",
                        "Nick;10",
                        "Jeremy;START",
                        "Jeremy;START",
                        "Leah;15",
                        "Jeremy;8,9,14"};
      String[] ex4 = {"Tom;START",
                        "Jeremy;START",
                        "Dana;START",
                        "Jeremy;4",
                        "Dana;2",
                        "James;START",
                        "Leah;START",
                        "James;5",
                        "Nick;START",
                        "Tom;1",
                        "Nick;6",
                        "Leah;3"};
      String[] res = detectFraud(ex3);
      for(String r : res) {
         System.out.println(r);
      }               
   }
   
   public static String[] detectFraud(String[] lines){
      if(lines.length < 4) 
         return new String[0];
      List<String> result = new ArrayList<>();
      //Map for contractor name with start line.
      Map<String, ListNode> map = new HashMap<>();
      
      //inv[i] = line i's invoice number.
      //-1 for START events.
      int[] inv = new int[lines.length + 1];
      Arrays.fill(inv, -1);
      
      //Keep track of the maximum invoice filled so far.
      int[] maxInvoices = new int[inv.length];
      Arrays.fill(maxInvoices, -1);
      
      for(int i = 0; i < lines.length; i++){
         String[] info = lines[i].split(";");
         String name = info[0];
         int line =  i+1;
         if(info[1].equals("START")) {
            if(!map.containsKey(name)){
               ListNode currLine = new ListNode(line);
               map.put(name, currLine);
            } else {
               //if there is more than one START for this contractor.
               ListNode currLine = map.get(name);
               while(currLine.next != null){
                  currLine = currLine.next;
               }
               currLine.next = new ListNode(line);
            }
            maxInvoices[line] = maxInvoices[line-1];
         } else {
            String batches = info[1];
            String[] batch = batches.split(",");
            int maxInv = Integer.parseInt(batch[0]);
            if(batch.length == 1) {
               checkShortInv(map, name, inv, maxInv, maxInvoices, line, result);
            } else {
               //check if the min inv is greater than max - if yes, no problem
               //if no: check if max inv is smaller than max = if yes, all shortened
               //if no: suspicisous
               int[] limit = getMaxMin(batch);            
               maxInv = limit[0];
               int minInv = limit[1];
               //check if the min inv is greater than max
               if(!checkShortInv(map, name, inv, minInv, maxInvoices, line, result)){
                  continue;
               } else {
                  if(!checkShortInv(map, name, inv, maxInv, maxInvoices, line, result)){
                     //suspiscious batch
                     String sus = line + ";" + name + ";SUSPICIOUS_BATCH";
                     result.add(sus);
                  } else {
                     //all invoices ae shortened.
                     for(String invs : batch){
                        int shortInv = Integer.parseInt(invs);
                        if(shortInv == maxInv) 
                           continue; //maxInv is already added.
                        checkShortInv(map, name, inv, shortInv, maxInvoices, line, result);
                     }  
                     
                  }
               }
            }
            maxInvoices[line] = Math.max(maxInvoices[line-1], maxInv);
         }
      }
      String[] res = new String[result.size()];
      for(int i = 0; i < res.length; i++){
         res[i] = result.get(i);
      }
      return res;
   }
   private static boolean checkShortInv(Map<String, ListNode> map, String name, 
                                    int[] inv, int maxInv, int[] maxInvoices, 
                                    int line, List<String> result){
      //guanranteed to have a START event for the contractor.
      ListNode startLines = map.get(name); 
      //get the last un-invoiced START
      int maxStartLine = getMax(startLines, inv);;
      //check if the invoice id is smaller than any of the ones submitted before start
      if(maxInv < maxInvoices[maxStartLine-1]){
         //shortened job
         String violation = maxStartLine + ";" + name + ";SHORTENED_JOB";
         result.add(violation);
         return true;
      }
      return false;                       
   }

   
   private static int getMax(ListNode node, int[] inv){
      int max = 0;
      while(node != null){
         if(inv[node.val] == -1) {
            max = Math.max(max, node.val);
         }
         node = node.next;
      }
      return max;
   }
   
   private static int[] getMaxMin(String[] batch){
      int[] res = new int[2];
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      for(String inv : batch){
         int num = Integer.parseInt(inv);
         max = Math.max(max, num);
         min = Math.min(min, num);
      }
      res[0] = max;
      res[1] = min;
      return res;
   }
}