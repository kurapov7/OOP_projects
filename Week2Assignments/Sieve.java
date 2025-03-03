package Week2Assignments;
/* Exercise 7.4
The Sieve of Eratosthenes is “a simple, ancient algorithm for finding all
 prime numbers up to any given limit” 
 (https://en.wikipedia. org/wiki/Sieve_of_Eratosthenes).

Write a method called sieve that takes an integer parameter, n, and returns
a boolean array that indicates, for each number from 0 to n - 1, 
whether the number is prime.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Sieve {
    public static boolean[] sieve(int n){
        boolean[] isPrime = new boolean[n]; // array from 0 to n storing prime status
        Arrays.fill(isPrime, true); // initially assume all numbers are prime
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime, start from 2

        for(int p = 2; p*p < n; p++){ // loop from 2 to sqrt(n)
            if(isPrime[p]){         // if p is still prime
                for(int i = p*p; i < n; i+=p){ // mark all multiples of p as false
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer 'n' to find all primes up to 'n': ");
        int n = in.nextInt();
        in.close();

        boolean[] primes = sieve(n);
        System.out.println("Prime numbers up to " +n+": ");
        for (int i = 2; i<n; i++){
            if(primes[i]){
                System.out.print(i+ ", ");
        }
        }
    }
}
