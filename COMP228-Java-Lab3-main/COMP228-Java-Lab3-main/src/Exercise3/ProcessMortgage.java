package Exercise3;

import javax.swing.*;

public class ProcessMortgage {

    public static void main(String[] args) {
        //create an array of 3 mortgages
        Mortgage[] loan = new Mortgage[3];
        String[] loanType = new String[]{"Personal", "Business"};
        String[] termType = new String[]{"1","2","3","4","5","6"};
        String userSelect;
        String name;
        int number;
        double amount;
        double rate;
        int term;
        //collect user input current rate
        rate = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Please enter your interest rate: "));

        for(int i = 0; i < 3; i++) {
            //instantiate a mortgage object
            Mortgage mortgage;
            //select either Personal or Business
            userSelect = (String) JOptionPane.showInputDialog(null,
                    "Choose your loan type: ",
                    "Type options",
                    JOptionPane.INFORMATION_MESSAGE,
                    null, loanType,loanType[0]);
            //mortgage number
            number = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Please enter your mortgage number: "));
            //customer name
            name = JOptionPane.showInputDialog(null,
                    "Please enter your name: ");
            //mortgage amount
            amount = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Please enter your loan amount(max 30k): "));
            //term in years
            term = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                    "Choose your loan term in years: ",
                    "Term options",
                    JOptionPane.INFORMATION_MESSAGE,
                    null, termType, termType[0]));
            //if select Personal
            if (userSelect.equals(loanType[0])) {
                //instantiate a Personal mortgage
                mortgage = new PersonalMortgage(number, name, amount, rate, term);
            }//if select Business
            else {
                //instantiate a Business mortgage
                mortgage = new BusinessMortgage(number, name, amount, rate, term);
            }
            //add to the array list
            loan[i] = mortgage;
            //display the mortgage item
            loan[i].getMortgageInfo();
        }
        //display all mortgages
        JOptionPane.showMessageDialog(null, loan);
//        for (Mortgage m : loan) {
//            m.getMortgageInfo();
//        }
    }
}
