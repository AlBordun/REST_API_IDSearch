package OOP.ComplexCalc.Model;

import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;
import OOP.ComplexCalc.Interfaces.iRunOperation;

public class OperationSum implements iRunOperation {

    /**
     * z = x + iy
     * Z = z+z = ( x + x ) +(y + y) * i
     */

    @Override
    public ComplexNumber run(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.getRealNumber() + b.getRealNumber(),a.getImaginaryNumber() + b.getImaginaryNumber());
    }
}
