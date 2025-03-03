package Week2Assignments;

/*
Exercise 5.7 
If you are given three sticks, you may or may not be able to arrange 
them in a triangle. For example, if one of the sticks is 12 inches long
and the other two are 1 inch long, you will not be able to get the short
sticks to meet in the middle. For any three lengths, there is a simple 
test to see if it is possible to form a triangle:

If any of the three lengths is greater than the sum of the other two, 
you cannot form a triangle.

Write a program named Triangle.java that inputs three integers, and 
then outputs whether you can (or cannot) form a triangle from the 
given lengths. Reuse your code from the previous exercise to validate
the inputs. Display an error if any of the lengths are negative or zero.
 */
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = validateLength(in, "Enter the first stick length: ");
        int b = validateLength(in, "Enter the second stick length: ");
        int c = validateLength(in, "Enter the third stick length: ");

        // Check if the three lengths can form a triangle using isTriangle method
        if (isTriangle(a, b, c)) {
            System.out.println("Yes, you can form a triangle.");
        } else {
            System.out.println("No, these lengths cannot form a triangle.");
        }

        in.close();
    }

    // Method to validate user input - must be positive integer
    public static int validateLength(Scanner in, String prompt) {
        int length = -1;
        while (length <= 0) {
            System.out.print(prompt);
            if (!in.hasNextInt()) {
                System.err.println(in.next() + " is not a valid number.");
                continue;
            }
            length = in.nextInt();
            if (length <= 0) {
                System.err.println("Error: Length must be a positive integer.");
            }
        }
        return length;
    }

    // Method to check if a triangle can be formed
    // If any of the three lengths is greater than the sum of the other two, you cannot form a triangle.
    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}