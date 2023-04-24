package Class1DZ;

import java.util.Random;
import java.util.Scanner;

//Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
public class Lesson1Solution2 {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = input.nextInt();

//        int[] array =new int[]{10, 11, 88, 2, 12, 120};
        int[] array = RandomArr(n);
//        int min = FindMin(array);
        printArrayInConsole(array);
        FindMin(array);
//        System.out.println("Minimum Value is: "+min);
    }

    public static int[] RandomArr(int n) {

        Random rd = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(10);
        }
        return arr;
    }

    public static void FindMin(int[] inputArray) {

        int minValue = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < minValue );
            {
                minValue = inputArray[i];
            }
        }
        System.out.println("Minimum Value is:"+minValue);

    }


    public static int[] printArrayInConsole(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
        return inputArray;
    }
}
