import java.io.*;
import java.util.*;
public class MagicDictionaryTest {
   public static void main(String[] args){
      MagicDictionary md = new MagicDictionary();
      String[] dict = {"hello","leetcode"};
      md.buildDict(dict);
      System.out.println(md.search("hello"));
      System.out.println(md.search("hhllo"));
   }
}