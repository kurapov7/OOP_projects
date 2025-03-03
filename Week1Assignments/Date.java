package Week1Assignments;

/* Following the example in Section 2.4, write a program that creates vari- 
ables named day, date, month, and year. The variable day will contain the 
day of the week (like Friday), and date will contain the day of the month 
(like the 13th). Assign values to those variables that represent today’s date. */

/* Display the value of each variable on a line by itself. This is an interme-
diate step that is useful for checking that everything is working so far. 
Compile and run your program before moving on. */

/* Modify the program so that it displays the date in standard American format; 
for example: Thursday, July 18, 2019. */

/* Modify the program so it also displays the date in European format. 
The final output should be as follows:
American format: Thursday, July 18, 2019
European format: Thursday 18 July 2019 */

public class Date {
    public static void main(String[] args) {
        String day = "Monday";
        int date = 27;
        String month = "January";
        int year = 2024;

        //Check variables
        System.out.println(day);
        System.out.println(date);
        System.out.println(month);
        System.out.println(year);

        // Display
        System.out.println("American format: " + day + ", " + month + " " + date + ", " + year);
        System.out.println("European format: " + day + " " + date + " " + month + " " + year);

    }
}
