package Week1Assignments;

/*
Exercise 3.2 Write a program that converts a temperature from Celsius to Fahrenheit. 
It should (1) prompt the user for input, (2) read a double value from the keyboard, 
(3) calculate the result, and (4) format the output to one decimal place. 
When it’s finished, it should work like this:

Enter a temperature in Celsius: 24
24.0 C = 75.2 F

Conversion formula:
F = C × 95 + 32

Hint: Be careful not to use integer division!
 */

import java.util.Scanner; 

public class C2F {
    public static void main(String[] args) {
        //Step 1: create scanner object for user input
        Scanner scanner = new Scanner(System.in);

        //Step 2: Prompt user input
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        //Step 3: convert C to F (avoid integer division)
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        
        //Step 4: format output to one decimal place
        System.out.printf("%.1f ºC = %.1f ºF\n", celsius, fahrenheit);

        // Close scanner 
        scanner.close();
}
}
