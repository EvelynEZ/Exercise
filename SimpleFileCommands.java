import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SimpleFileCommands {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        // Process each command
        Set hs = new LinkedHashSet<String>();
        for(int a0 = 0; a0 < q; a0++){
            // Read the first string denoting the command type
            String command = in.next();
            // Write additional code to read the command's file name(s) and process the command
            // Print the output string appropriate to the command
            String word = in.next();
            if (command.equals("crt")){ //create new item 
                int init = 1;
                String original = word;
                while (hs.contains(word)){
                  word = original+ "("+init+")";
                  init++;
                }
                hs.add(word);
                System.out.println("+ " + word); //delete the item
            } else if(command.equals("del")){
               hs.remove(word);
               System.out.println("- " + word);
            } else if (command.equals("rnm")){ //rename the item
               String newName = in.next();
               hs.remove(word);
               int initial = 1;
                String orig = newName;
                while (hs.contains(newName)){
                  newName = orig + "("+initial+")";
                  initial++;
                }
                hs.add(newName);
                System.out.println("r " + word + " -> " + newName);
            } else {
               System.out.println("Invalid command");
            }
        }
    }
}