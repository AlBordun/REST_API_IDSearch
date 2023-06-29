package OOP.ComplexCalc.Model;

import OOP.ComplexCalc.ComplexCalculator.ComplexNumber;
import OOP.ComplexCalc.Interfaces.iRunDescription;
import OOP.ComplexCalc.Interfaces.iRunOperation;

public class CompLogger implements iRunDescription {
    private iRunOperation operation;

    public CompLogger(iRunOperation operation) {
        this.operation = operation;
    }

    @Override
    public ComplexNumber run(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = operation.run(a, b);
        System.out.println(
                getDescription() + ": " + operation.getClass().getSimpleName() + " on numbers " + a + " and " + b);
        System.out.println("Operation Result: " + result);
        return result;
    }

    @Override
    public String getDescription() {
        return "Operation Proceed";
    }

}
