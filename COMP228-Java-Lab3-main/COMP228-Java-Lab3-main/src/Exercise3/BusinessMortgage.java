package Exercise3;

import javax.swing.*;

public class BusinessMortgage extends Mortgage{

    public BusinessMortgage(int mortgageNum, String customerName, double mortgageAmount, double interestRate, int term) {
        super(mortgageNum, customerName, mortgageAmount, interestRate, term);
        setInterestRate(getInterestRate() + 1);
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
                "Business Mortgage",
                JOptionPane.DEFAULT_OPTION);
    }
}
