package OOP.ComplexCalc.Model;

import OOP.ComplexCalc.Interfaces.iRunOperation;
import OOP.ComplexCalc.Model.OperationDivision;
import OOP.ComplexCalc.Model.OperationMulti;
import OOP.ComplexCalc.Model.OperationSum;

public abstract class OperationGenerator {

    public static iRunOperation createOperation(String type) {
        switch (type) {
            case "addition":
                return new OperationSum();
            case "multiplication":
                return new OperationMulti();
            case "division":
                return new OperationDivision();
            default:
                throw new IllegalArgumentException("Invalid operation: " + type);
        }
    }

}
