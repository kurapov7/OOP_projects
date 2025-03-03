package Week2Assignments;
/* Exercise 7.3

Write a method called indexOfMax that takes an array of integers and 
returns the index of the largest element. 

Can you write this method by using an enhanced for loop? Why or why not?

No, you cannot use an enhanced for loop for this method because we need to track
both the maximum and value and its index. We cannot access the index using an enhanced for loop.
 */
public class FindMax {
    public static int indexOfMax(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("Array cannot be empty or null.");
        }

        int maxIndex = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void main(String[] args) {
        int[] numbers = {2, 3, 7, 4, 9, 5, 4, 8, 6, 5};
        System.out.println("Index of max element in array: " + indexOfMax(numbers));
    }
}
