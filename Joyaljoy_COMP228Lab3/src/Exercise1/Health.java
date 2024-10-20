package Joyaljoy_COMP228Lab3.src.Exercise1;

public class Health extends Insurance {

    public Health() {
        super("Health Insurance");
    }

    @Override
    public void setInsuranceCost(double cost) {
        setMonthlyCost(cost);
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: " + getType() + ", Monthly Cost: $" + getMonthlyCost());
    }
}


