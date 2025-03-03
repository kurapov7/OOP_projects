package Week1Assignments;

/* Exercise 3.3 
Write a program that converts a total number of seconds to hours, minutes, and seconds. 
It should (1) prompt the user for input, (2) read an integer from the keyboard, 
(3) calculate the result, and (4) use printf to display the output. 

For example, "5000 seconds = 1 hours, 23 minutes, and 20 seconds".

Hint: Use the remainder operator.
 */

import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //prompt user input
        System.out.print("Enter the total number of seconds: ");
        int totalSeconds = scanner.nextInt();  // Read integer value

        //Calculate hours, minutes, and remaining seconds
        int hours = totalSeconds / 3600;  // 1 hour = 3600 seconds
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;  // 1 minute = 60 seconds
        int seconds = remainingSeconds % 60;  // Remaining seconds

        //Display the output using printf
        System.out.printf("%d seconds = %d hours, %d minutes, and %d seconds\n",
                totalSeconds, hours, minutes, seconds);

        scanner.close();
    }
}