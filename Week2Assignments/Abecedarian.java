package Week2Assignments;
/* Exercise 6.4 

A word is said to be “abecedarian” if the letters in the word appear in 
alphabetical order. For example, the following are all six-letter English
abecedarian words:

abdest, acknow, acorsy, adempt, adipsy, agnosy, befist, behint, beknow, 
bijoux, biopsy, cestuy, chintz, deflux, dehors, dehort, deinos, diluvy, dimpsy

Write a method called isAbecedarian that takes a String and returns a boolean
indicating whether the word is abecedarian.
 */
import java.util.Scanner;

public class Abecedarian {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // Test cases
        System.out.println(isAbecedarian("abcdef")); // true
        System.out.println(isAbecedarian("hello")); // false
        
        System.out.print("Enter a word to check if it is 'Abecedarian': ");
        String s = in.nextLine();
        System.out.println(isAbecedarian(s));

        in.close();
    }
    public static boolean isAbecedarian(String word){
        // Convert word to lowercase for easier checking
        word = word.toLowerCase();
        
        // Iterate through string to check each char
        for(int i = 0; i < word.length()-1; i++){
            if(word.charAt(i) > word.charAt(i+1)) {
                return false; // If any letter is greater than the next, the word is not abecedarian
            }
        }
        return true; // else return true
    }
}
