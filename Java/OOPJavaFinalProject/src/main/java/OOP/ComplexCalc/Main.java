package OOP.ComplexCalc;

import OOP.ComplexCalc.ComplexCalculator.CompCalculator;
import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;
import OOP.ComplexCalc.Model.CompLogger;
import OOP.ComplexCalc.Model.OperationGenerator;
import OOP.ComplexCalc.View.ViewComplexCalc;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //iCalculable calculator = new Calculator(0);
//        iCalculable calculator = new CalcDecorator(new Calculator(0),new Logger());
//        ViewCalculator view = new ViewCalculator(calculator);
//        view.run();
        ViewComplexCalc view = new ViewComplexCalc();
        CompCalculator compCalc = new CompCalculator();
        int choice = 0;
        while (choice != 4) {
            view.showMenu();
            choice = view.getMenuChoice();

            switch (choice) {
                case 1:
                    ComplexNumber num1 = view.getComplexNumber();
                    ComplexNumber num2 = view.getComplexNumber();
                    compCalc.setOperation(new CompLogger(OperationGenerator.createOperation("addition")));
                    ComplexNumber sum = compCalc.execute(num1, num2);
                    break;
                case 2:
                    ComplexNumber num3 = view.getComplexNumber();
                    ComplexNumber num4 = view.getComplexNumber();
                    compCalc.setOperation(new CompLogger(OperationGenerator.createOperation("division")));
                    ComplexNumber div = compCalc.execute(num3, num4);
                    break;
                case 3:
                    ComplexNumber num5 = view.getComplexNumber();
                    ComplexNumber num6 = view.getComplexNumber();
                    compCalc.setOperation(new CompLogger(OperationGenerator.createOperation("multiplication")));
                    ComplexNumber product = compCalc.execute(num5, num6);
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

}
