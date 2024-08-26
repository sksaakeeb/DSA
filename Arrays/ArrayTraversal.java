package Arrays;

import java.util.Scanner;
public class ArrayTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int[] numbers = new int[size];

        //input
        System.out.println("Enter the elements:");
        for (int i=0; i<size; i++) {
            numbers[i] = sc.nextInt();
        }

        //output
        System.out.println("Array elements: ");
        for (int i=0; i<size; i++) {
            System.out.println(numbers[i]);
        }
    }
}
