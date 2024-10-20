package Exercise2;

import javax.swing.*;

public class TesterDriver {

    public static void main(String[] args) {
        //declare
        String[] jobType = new String[] {"Full-time","Part-time"};
        String testerName;
        String userSelects;
        GameTester tester;
        int hours;
        //collecting user input tester name
        testerName = JOptionPane.showInputDialog(null,
                "Please enter your name: ");
        //collecting user input tester type
        userSelects = (String) JOptionPane.showInputDialog(null,
                "Choose your job type: ",
                "Type",
                JOptionPane.INFORMATION_MESSAGE,
                null,jobType,jobType[0]);
        //if the tester is full-time
        if (userSelects.equals("Full-time")) {
            //instantiate a full time tester instance
            tester = new FullTimeGameTester();
            //is full time boolean turns true
            tester.isFullTime = true;
            //sign testerName to tester instance
            tester.testerName = testerName;
            //setSalary when tester.isFullTime is true
            tester.setSalary(true);
        }
        //if the tester is part-time
        else {
            //collecting how many hours
            hours = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "How many hours worked within the month?"));
            //instantiate a part time tester instance
            tester = new PartTimeGameTester(hours);
            //is full time boolean turns false
            tester.isFullTime = false;
            //sign testerName to tester instance
            tester.testerName = testerName;
            //setSalary when tester.isFullTime is false
            tester.setSalary(false);
        }
        //display tester info
        JOptionPane.showConfirmDialog(null,
                "Tester Name: " + tester.getTesterName() + "\n" +
                        "Tester Monthly Pay: $" + tester.getMonthlyPay(),
                "Tester Info", JOptionPane.DEFAULT_OPTION);

    }
}
