package OOP.ComplexCalc.ComplexCalculator;

import OOP.ComplexCalc.Interfaces.iRunOperation;

public class CompCalculator {

    private iRunOperation operation;

    /**
     * @param operation operation for execution;
     */
    public void setOperation(iRunOperation operation) {
        this.operation = operation;
    }

    /**
     * method for operation on two comp numbers
     * @param a first comp number
     * @param b second comp number
     * @return operation result
     */
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        if (operation == null) {
            throw new IllegalStateException("Operation is not set");
        }
        return operation.run(a, b);
    }

}
