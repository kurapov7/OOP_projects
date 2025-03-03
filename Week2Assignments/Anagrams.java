package Week2Assignments;

/* Exercise 7.8 

Two words are anagrams if they contain the same letters and the same number of each letter. 
For example, “stop” is an anagram of “pots”, “allen downey” is an anagram of “well annoyed”, 
and “christopher mayfield” is an anagram of “hi prof the camel is dry”. 

Write a method that takes two strings and checks whether they are anagrams of each other.
 */
import java.util.Scanner;

public class Anagrams {
    public static boolean isAnagram(String s1, String s2){
        // Normalize strings - change to lowercase and remove spaces
        s1 = s1.toLowerCase().replaceAll(" ","");
        s2 = s2.toLowerCase().replaceAll(" ","");
        
        // if lengths don't match, they can't be anagrams
        if(s1.length() != s2.length()) return false;

        // Array to count occurrences of letters (a-z)
        int[] counts = new int[26];

        for(int i = 0; i < s1.length(); i++){
            counts[s1.charAt(i) - 'a']++; //increase counts for each letter in s1
            counts[s2.charAt(i) - 'a']--; //decrease counts for each letter in s2
        }
        
        // if all counts are zero, the strings are anagrams
        for(int count : counts){
            if(count != 0) return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // user input
        System.out.print("Enter a string: ");
        String s1 = in.nextLine();
        System.out.print("Enter another string to check if it's a anagram of the first: ");
        String s2 = in.nextLine();
        in.close();
        
        if(isAnagram(s1, s2)){
            System.out.println(s1 +" & "+s2+" are anagrams!");
        }else{
            System.out.println(s1 +" & "+s2+" are NOT anagrams... :(");
        }
    }
}
