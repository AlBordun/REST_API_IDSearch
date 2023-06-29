package OOP.ComplexCalc.ComplexCalculator;

public class ComplexNumber {
    private double realNumber;

    private double imaginaryNumber;


    public ComplexNumber(double realNumber, double imaginaryNumber) {
        this.realNumber = realNumber;
        this.imaginaryNumber = imaginaryNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public double getImaginaryNumber() {
        return imaginaryNumber;
    }
    @Override
    public String toString() {
        return String.format("( %.4f + i * %.4f)", getRealNumber(), getImaginaryNumber() );
    }
}
