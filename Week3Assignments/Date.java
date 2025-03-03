package Week3Assignments;
/* Exercise 11.3 
Write a class definition for Date, an object type that contains three integers: 
year, month, and day. This class should provide two constructors. 

The first should take no parameters and initialize a default date. 

The second should take parameters named year, month and day, and use them to 
initialize the instance variables.


*/
public class Date {
    private int year;
    private int month;
    private int day;
    
    // default constructor 
    public Date() {
        this.year = 1990;
        this.month = 1;
        this.day = 1;
    }
    // constructor with parameters
    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String toString(){
        return year+"/"+month+"/"+day;
    }
    // Write a main method that creates a new Date object named birthday. 
    // The new object should contain your birth date. You can use either constructor.
    public static void main(String[] args) {
        Date birthday = new Date(1999, 9, 9);
        System.out.println("My birthday is "+birthday);
    }
}
