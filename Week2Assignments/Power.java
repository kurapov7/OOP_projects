package Week2Assignments;

/* Exercise 8.5 
Write a recursive method called power that takes a double x and an integer n and returns xn.

Hint: A recursive definition of this operation is x^n = x · x^(n−1). 
Also, remember that anything raised to the zeroth power is 1.

*/
public class Power {
    public static double power(double x, int n){
        //base case: if n = 0
        if(n==0) return 1.0;
        // handle negative exponents
        if(n<0){
            return 1.0 / power(x,-n);
        }
        System.out.println("Calling power("+x+","+n+")");
        return x * power(x, n-1); // x^n = x · x^(n−1)
    }
    public static void main(String[] args) {
        double x = 4.0;
        int n = 2;

        System.out.println(power(x,n));
    }
}
