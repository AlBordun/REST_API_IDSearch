package Class1DZ;

//Написать метод, принимающий на вход два аргумента: len и initialValue,
//и возвращающий одномерный массив типа int длиной len,
//каждая ячейка которого равна initialValue;
public class Main {
    public static void main(String args[]) {
        printArrayInConsole(retLenArr(10,1));}

    public static int[] retLenArr (int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }
    public static void printArrayInConsole(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}
