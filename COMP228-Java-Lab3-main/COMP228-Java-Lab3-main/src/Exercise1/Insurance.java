package Exercise1;

public abstract class Insurance {

    //declare instance variable
    public String typeOfInsurance;
    public double monthlyCost;

    //constructor
    public Insurance(String type) {
        typeOfInsurance = type;
    }

    //get methods
    public String getTypeOfInsurance() {
        return typeOfInsurance;
    }
    public double getMonthlyCost() {
        return monthlyCost;
    }

    //abstract methods
    abstract void setInsuranceCost(double inputFee);
    abstract void displayInfo();

}
