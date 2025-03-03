package Week2Assignments;
/* Exercise 5.3 

Fermat’s Last Theorem says that there are no integers a, b, c,
and n such that a^n+b^n =c^n, except when n ≤ 2.

Write a program named Fermat.java that inputs four integers (a, b, c, and n)
and checks to see if Fermat’s theorem holds. 

If n is greater than 2 and an + bn = cn, the program should display 
“Holy smokes, Fermat was wrong!” 
Otherwise, the program should display “No, that doesn’t work.”

Hint: You might want to use Math.pow. */

import java.util.Scanner;

public class Fermat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input 4 integers (a,b,c, and n)
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();
        System.out.print("Enter value for n: ");
        int n = scanner.nextInt();

        // Check Fermat’s Theorem
        if (n > 2 && Math.pow(a, n) + Math.pow(b, n) == Math.pow(c, n)) {
            System.out.println("Holy smokes, Fermat was wrong!");
        } else {
            System.out.println("No, that doesn’t work.");
        }

        scanner.close();
    }
}
