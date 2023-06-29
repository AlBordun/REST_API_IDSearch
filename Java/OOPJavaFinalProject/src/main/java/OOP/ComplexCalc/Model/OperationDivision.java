package OOP.ComplexCalc.Model;

import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;
import OOP.ComplexCalc.Interfaces.iRunOperation;

public class OperationDivision implements iRunOperation {

    /**
     * Z= z1/z2=((x1*x2)+(y1*y2)+ i*(x2y1- x1y2))/(x2*x2 + y2*y2)
     */
    @Override
    public ComplexNumber run(ComplexNumber a, ComplexNumber b) {
        double denominator = b.getRealNumber() * b.getRealNumber() + b.getImaginaryNumber() * b.getImaginaryNumber();
        // Count real part
        double real = (a.getRealNumber() * b.getRealNumber() + a.getImaginaryNumber() * b.getImaginaryNumber()) / denominator;
        // Count imaginary part
        double imaginary = (a.getImaginaryNumber() * b.getRealNumber() - a.getRealNumber() * b.getImaginaryNumber()) / denominator;
        // return new comp. number
        return new ComplexNumber(real, imaginary);
    }
}
