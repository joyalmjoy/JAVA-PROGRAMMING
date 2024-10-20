package Exercise3;

public abstract class Mortgage implements MortgageConstants{

    //declare
    private int mortgageNum;
    private String customerName;
    private double mortgageAmount;
    private double interestRate;
    private int term;
    //getters
    public int getMortgageNum() { return mortgageNum; }
    public String getCustomerName() { return customerName; }
    public double getInterestRate() { return interestRate; }
    //Don’t allow mortgage amounts over $300,000
    public double getMortgageAmount() {
        return Math.min(mortgageAmount, MAXAMOUNT);
    }
    //All terms that not defined => short-term
    public int getTerm() {
        if(term != MEDIUMTERM & term != LONGTERM){
            return SHORTTERM;
        }
        else {
            return term;
        }
    }
    //setters
    public void setMortgageNum(int mortgageNum) { this.mortgageNum = mortgageNum; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setMortgageAmount(double mortgageAmount) { this.mortgageAmount = mortgageAmount; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void setTerm(int term) { this.term = term; }
    //constructor
    public Mortgage (int mortgageNum, String customerName, double mortgageAmount, double interestRate, int term){
        this.mortgageNum = mortgageNum;
        this.customerName = customerName;
        this.mortgageAmount = mortgageAmount;
        this.interestRate = interestRate;
        this.term = term;
    }
    //display all mortgage data
    public abstract void getMortgageInfo();
    public String toString() {
        return "Bank Name: " + BANKNAME +
                ", Mortgage Number: " + getMortgageNum() +
                ", Customer Name: " + getCustomerName() +
                ", Mortgage Amount: $" + getMortgageAmount() +
                ", Interest Rate: " + getInterestRate() + "%" +
                ", Term: " + getTerm() + " Years" + "\n";

    }
}
