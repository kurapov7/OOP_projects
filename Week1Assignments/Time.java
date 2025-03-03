package Week1Assignments;

/* 1. Create a new program called Time.java. From now on, we won’t remind you 
to start with a small, working program, but you should.
2. Following the example program in Section 2.4, create variables named hour, 
minute, and second. Assign values that are roughly the current time. Use a 
24-hour clock so that at 2:00 PM the value of hour is 14.
3. Make the program calculate and display the number of seconds since midnight.
4. Calculate and display the number of seconds remaining in the day.
5. Calculate and display the percentage of the day that has passed. You might 
run into problems when computing percentages with integers, so consider using floating-point. */

public class Time {
    public static void main(String[] args) {
       // Step 1 & 2: Declare and assign values (24-hour format)
       int hour = 14;    // 2 PM
       int minute = 30;  // 30 minutes
       int second = 45;  // 45 seconds

       // Step 3: Calculate seconds since midnight
       int secondsSinceMidnight = (hour * 3600) + (minute * 60) + second;
       System.out.println("Seconds since midnight: " + secondsSinceMidnight);

       // Step 4: Calculate seconds remaining in the day
       int totalSecondsInDay = 24 * 3600;
       int secondsRemaining = totalSecondsInDay - secondsSinceMidnight;
       System.out.println("Seconds remaining in the day: " + secondsRemaining);

       // Step 5: Calculate percentage of the day that has passed
       double percentagePassed = (secondsSinceMidnight / (double) totalSecondsInDay) * 100;
       System.out.println("Percentage of the day passed: " + percentagePassed + "%");
    }
}
