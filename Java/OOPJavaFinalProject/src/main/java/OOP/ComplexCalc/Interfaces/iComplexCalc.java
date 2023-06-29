package OOP.ComplexCalc.Interfaces;

import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;

public interface iComplexCalc {
    ComplexNumber add(ComplexNumber num1, ComplexNumber num2);

    ComplexNumber subtract(ComplexNumber num1, ComplexNumber num2);

    ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2);
}
