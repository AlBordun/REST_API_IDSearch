package Class1DZ;

import java.util.Random;
import java.util.Scanner;

//Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
public class Lesson1Solution5 {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int size = input.nextInt();
        System.out.println("Enter shift number: ");
        int shift = input.nextInt();
        int[] array = RandomArr(size);
        printArrayInConsole(array);
        printArrayInConsole(ArrayShift(array,shift));
    }

    public static int[] RandomArr(int size) {

        Random rd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(10);
        }
        return arr;
    }

    public static int[] ArrayShift(int[] inputArray, int shift) {
            if (shift > 0) {
                for (int j = 1; j <= shift; j++) {
                    int elemshift = inputArray[inputArray.length - 1];
                    for (int k = inputArray.length - 2; k >= 0; k--) {
                        inputArray[k + 1] = inputArray[k];
                    }
                    inputArray[0] = elemshift;
                }
        } else if (shift < 0) {
                for (int j = shift; j <= -1; j++) {
                    int elemshift = inputArray[0];
                    for (int k = 1; k < inputArray.length; k++) {
                        inputArray[k - 1] = inputArray[k];
                    }
                    inputArray[inputArray.length - 1] = elemshift;
                }
            }
        return inputArray;
    }




    public static int[] printArrayInConsole(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
        return inputArray;
    }
}
