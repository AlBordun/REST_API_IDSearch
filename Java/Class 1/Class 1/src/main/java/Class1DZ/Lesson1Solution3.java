package Class1DZ;

import java.util.Scanner;


//Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
public class Lesson1Solution3 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Number Of Matrix Rows");
        int matrixRow = scan.nextInt();
        System.out.println("Enter The Number Of Matrix Columns");
        int matrixCol = scan.nextInt();
        int[][] matrix = new int[matrixRow][matrixCol];
        printMatrix(matrix, matrixRow, matrixCol);
    }

    public static void printMatrix(int[][] matrix, int matrixRow, int matrixCol) {
        System.out.println("Your Matrix is : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, x = matrix[i].length - 1; j < matrix[i].length; j++, x--) {
                if (i == j || i == x) matrix[i][j] = 1;
                else matrix[i][j] = 0;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}