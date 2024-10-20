package Exercise1;
import javax.swing.*;
import java.awt.*;

public class InsuranceDriver {

    public static void main(String[] args) {
        //options
        String[] types = new String[] {"Health", "Life"};
        String userSelect;
        //run 3 times
        final int count = 3;
        //array
        Insurance[] insuranceList = new Insurance[count];
        for(int i = 0; i < count; i++) {
            //create an instance of Insurance
            Insurance insurance;
            //default inputFee
            double inputFee = 0;
            //collecting user selection of insurance type
            userSelect = (String)JOptionPane.showInputDialog((Component) null,
                    "Please select your insurance type: ",
                    "Creating Insurance",
                    JOptionPane.QUESTION_MESSAGE,
                    (Icon)null, types,types[0]);
            //if select Health then instantiate Health insurance
            if(userSelect.equals(types[0])) {
                insurance = new Health();
                //add the insurance into list
                insuranceList[i] = insurance;
            }
            //if select Life then instantiate Life insurance
            else if (userSelect.equals(types[1])) {
                insurance = new Life();
                //add the insurance into list
                insuranceList[i] = insurance;
            }
            //collecting user inputFee
            inputFee = Double.parseDouble(JOptionPane.showInputDialog((Component)null,
                    "Please enter your monthly fee: ",
                    "Monthly Cost",
                    JOptionPane.INFORMATION_MESSAGE));
            //calls
            insuranceList[i].setInsuranceCost(inputFee);
            insuranceList[i].displayInfo();
        }
    }
}
