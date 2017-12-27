import java.io.*;
import java.util.*;
public class TinyURL {
    public static Map<Integer, String> stol;
    public static Map<String, Integer> stonum;
    public static int counter;
    public static String elements;
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl/description/";
        stol = new HashMap<>();
        stonum = new HashMap<>();
        counter = 1;
        elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shortURL = longToShort(url);
        System.out.println("Short URL: " + shortURL);
        System.out.println("Long URL: " + shortToLong(shortURL));
    }
    
    public static String longToShort(String url){
        String shortURL = base10to62(counter);
        stol.put(counter, url);
        stonum.put(shortURL, counter);
        counter++;
        return shortURL;
    }
    
    private static String base10to62(int counter){
        StringBuilder sb = new StringBuilder();
        while(counter != 0){
            sb.insert(0, counter % 62);
            counter /= 62;
        }
        while(sb.length() < 6){
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    
    public static String shortToLong(String url){
        return stol.get(stonum.get(url));
    }
    
}