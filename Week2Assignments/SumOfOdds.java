package Week2Assignments;

import java.util.Scanner;

/* Exercise 8.2 

Write a recursive method named oddSum that takes a positive odd integer n and 
returns the sum of odd integers from 1 to n. Start with a base case, and use 
temporary variables to debug your solution. You might find it helpful to print 
the value of n each time oddSum is invoked.

*/
public class SumOfOdds {
    public static int oddSum(int n){
        //base case
        if(n == 1) return 1;

        // print n at each step:
        System.out.println("Calling oddSum("+n+")");

        return n + oddSum(n-2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 2;
        do{
            System.out.println("Enter a positive odd integer 'n': ");
            n = in.nextInt();
        }while(n%2 != 1);
        
        in.close();
        System.out.println("The sum of all odd integers up to "+n+" = " +oddSum(n));
    }
}
