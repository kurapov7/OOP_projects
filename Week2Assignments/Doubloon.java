package Week2Assignments;

import java.util.Scanner;

/* Exercise 6.5

A word is said to be a “doubloon” if every letter that appears in the word 
appears exactly twice. Here are some example doubloons found in the dictionary:

Abba, Anna, appall, appearer, appeases, arraigning, beriberi, bilabial, boob, 
Caucasus, coco, Dada, deed, Emmett, Hannah, horse- shoer, intestines, Isis, 
mama, Mimi, murmur, noon, Otto, papa, peep, reappear, redder, sees, 
Shanghaiings, Toto

Write a method called isDoubloon that takes a string and checks whether it is
a doubloon. To ignore case, invoke the toLowerCase method before checking.
 */
public class Doubloon {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        // user input
        System.out.print("Enter a word to check if it's a doubloon: ");
        String s = in.nextLine();

        // use isDoubloon method to check if the word is a doubloon
        if(isDoubloon(s)){
            System.out.println(s + " is a doubloon!");
        } else {
            System.out.println(s + " is NOT a doubloon... :(");
        }
        
        in.close();
    }

    public static boolean isDoubloon(String s){
        String l = s.toLowerCase();
        boolean check = true;

        // Use nested for loop to count occurances of each letter
        for(int i = 0; i < l.length(); i++){
            int count = 0;
            
            for(int j = 0; j < l.length(); j++){
                if(l.charAt(i) == l.charAt(j)) count++;
            }
            
            if (count !=2) {
                check = false;
                break;
            }
        }
        return check; // returns true if all letters appear exactly twice 
    }
}
