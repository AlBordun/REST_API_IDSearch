package OOP.ComplexCalc.View;

import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;

import java.util.Scanner;

public class ViewComplexCalc {
    /***
     * Class with menu interactions and options
     */
    private Scanner scanner = new Scanner(System.in);


    public void View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("_____________________________");
        System.out.println("Complex Number Calculator");
        System.out.println("1. Summarize");
        System.out.println("2. Division");
        System.out.println("3. Multiplication");
        System.out.println("4. exit");
    }

    public int getMenuChoice() {
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }

    public ComplexNumber getComplexNumber() {
        System.out.print("write a real part: ");
        double realNumber = scanner.nextDouble();
        System.out.print("Write imaginary part: ");
        double imaginaryNumber = scanner.nextDouble();
        return new ComplexNumber(realNumber, imaginaryNumber);
    }

    public void showResult(ComplexNumber result) {
        System.out.println("Result: " + result.toString());
    }

}
