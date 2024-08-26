package Arrays;

import java.util.Scanner;

public class Array {

    // Array Traversal
    System.out.println("Array elements: ");
        for (int i=0; i<size; i++) {
            System.out.println(numbers[i]);
        }

    // Find min and max elemeby
int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i<numbers.length; i++) {
            if(numbers[i] < min) {
                min = numbers[i];
            }
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("Max: " + max + " Min: " + min);
}
