package Week2Assignments;

/* Exercise 7.5

Write a method named areFactors that takes an integer n and an array of integers, 
and returns true if the numbers in the array are all factors of n 
(which is to say that n is divisible by all of them).

*/

public class CheckFactors {
    public static boolean areFactors(int n, int[] nums){
        for(int num : nums){
            if(n % num != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 30;
        int[] factors1 = {1, 2, 3, 5, 6, 10, 15}; // will return true (all are factors)
        int[] factors2 = {1, 2, 3, 5, 6, 7, 10, 15}; // will return false (7 is not a factor)

        System.out.println(areFactors(n, factors1)); // true
        System.out.println(areFactors(n, factors2)); // false
    }
}
