package Exercise3;

import javax.swing.*;

public class PersonalMortgage extends Mortgage{

    public PersonalMortgage(int mortgageNum, String customerName, double mortgageAmount, double interestRate, int term) {
        super(mortgageNum, customerName, mortgageAmount, interestRate, term);
        setInterestRate(getInterestRate() + 2);
    }

    @Override
    public void getMortgageInfo() {
        String morInfo = "Bank: " + BANKNAME + "\n" +
                "Mortgage Number: " + getMortgageNum() + "\n" +
                "Customer Name: " + getCustomerName() + "\n" +
                "Mortgage Amount: $" + getMortgageAmount() + "\n" +
                "Interest Rate: " + getInterestRate() + "%" + "\n" +
                "Term: " + getTerm() + " Years";
        JOptionPane.showConfirmDialog(null,
                morInfo,
                "Personal Mortgage",
                JOptionPane.DEFAULT_OPTION);
    }
}
