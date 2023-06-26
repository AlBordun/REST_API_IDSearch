package OOP.Solution1;

import java.util.Date;

public class CalCSalary extends Employee {
    public CalCSalary(String name, Date dob, int baseSalary) {
        super(name, dob, baseSalary);
    }

    public int calculateNetSalary() {
        int tax = (int) (getBaseSalary() * 0.25);//calculate in otherway
        return getBaseSalary() - tax;
    }
}
