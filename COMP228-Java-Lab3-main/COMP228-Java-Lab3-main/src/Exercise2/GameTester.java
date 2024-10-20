package Exercise2;

public abstract class GameTester {
    //declare
    public String testerName;
    public boolean isFullTime;
    public double monthlyPay;
    //constructor
    public GameTester(String name){
        testerName = name;
    };
    //getters
    public String getTesterName() { return testerName; }
    public double getMonthlyPay() { return monthlyPay; }
    //abstract method
    abstract void setSalary(boolean isFullTime);
}
