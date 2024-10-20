package Exercise1;
import javax.swing.JOptionPane;

public class Health extends Insurance {

    //constructor
    public Health() {
        super("Health Insurance");
    }

    @Override
    void setInsuranceCost(double inputFee) {
        monthlyCost = inputFee;
    }

    @Override
    void displayInfo() {
        JOptionPane.showConfirmDialog(null,
                "Your insurance type is: " + getTypeOfInsurance() + "\n" +
                        "Your monthly cost is: $" + getMonthlyCost(),
                "Insurance Info", JOptionPane.DEFAULT_OPTION);
    }
}
