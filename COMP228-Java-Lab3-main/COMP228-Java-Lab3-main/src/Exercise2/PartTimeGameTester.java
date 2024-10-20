package Exercise2;

public class PartTimeGameTester extends GameTester{
    //declare
    public double rate = 20;
    public int hours;
    //constructor
    public PartTimeGameTester(int hours) {
        super("");
        this.hours = hours;
    }
    //method
    @Override
    void setSalary(boolean isFullTime) {
        if(!isFullTime) {
            monthlyPay = hours * rate;
        }
    }
}
