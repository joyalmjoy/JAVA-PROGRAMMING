package Joyaljoy_COMP228Lab3.src.Exercise2;

public class FullTimeGameTester extends GameTester{
    //constructor
    public FullTimeGameTester() {
        super("");
    }
    //method
    @Override
    void setSalary(boolean isFullTime) {
        if (isFullTime){
            monthlyPay = 3000;
        }
    }
}