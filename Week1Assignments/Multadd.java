package Week1Assignments;
/*Exercise 4.6 
Many computations can be expressed more concisely using the “multadd” operation, 
which takes three operands and computes a * b + c. Some processors even provide a 
hardware implementation of this operation for floating-point numbers.

1. Create a new program called Multadd.java.
2. Write a method called multadd that takes three doubles as parameters
andreturnsa * b + c.
3. Write a main method that tests multadd by invoking it with a few simple
parameters, like 1.0, 2.0, 3.0.
4. Also in main, use multadd to compute the following values:
sin π + cos π4 42
log10+log20
5. Write a method called expSum that takes a double as a parameter and
uses multadd to calculate:
xe−x + √1 − e−x

Hint: The method for raising e to a power is Math.exp.
In the last part of this exercise, you need to write a method that invokes another method you wrote. 
Whenever you do that, it is a good idea to test the first method carefully before working on the second. 
Otherwise, you might find yourself debugging two methods at the same time, which can be difficult.
One of the purposes of this exercise is to practice pattern-matching: the ability to recognize a 
specific problem as an instance of a general category of problems.
 */
public class Multadd {
    // 2. multadd method
    public static double multadd(double a, double b, double c) {
        return a * b + c;
    }
    
    public static void main(String[] args) {
        // 3. Test multadd with simple parameters
        double result1 = multadd(1.0, 2.0, 3.0);
        System.out.println("1.0 * 2.0 + 3.0 = " + result1);

        // 4. Use multadd for sin(π/4) + cos(π/4)*0.5
        double result2 = multadd(Math.cos(Math.PI / 4), 0.5, Math.sin(Math.PI / 4));
        System.out.println("sin(π/4) + (cos(π/4) * 0.5) = " + result2);

        // multadd for log(10) + log(20)
        double result3 = multadd(Math.log10(10), 1, Math.log10(20));
        System.out.println("log(10) + log(20) = " + result3);

        // 5. Implement and test expSum method, with x = 1.0
        System.out.println("When x = 1, x(e^-x) + sqrt(1-(e^-x)) = " + expSum(1.0));
    }
    
    // 5. expSum method uses multadd to compute the expression x(e^-x) + sqrt(1-(e^-x))
    public static double expSum(double x) {
        return multadd(x, Math.exp(-x), Math.sqrt(1 - Math.exp(-x)));
    }
}
