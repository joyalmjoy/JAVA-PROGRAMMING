package Joyaljoy_COMP228Lab3.src.Exercise1;
import java.util.Scanner;

public class InsuranceDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] insurances = new Insurance[2];

        for (int i = 0; i < insurances.length; i++) {
            System.out.println("Enter the type of insurance (health/life): ");
            String type = scanner.nextLine().toLowerCase();

            if (type.equals("health")) {
                insurances[i] = new Health();
            } else if (type.equals("life")) {
                insurances[i] = new Life();
            } else {
                System.out.println("Invalid type. Defaulting to Health Insurance.");
                insurances[i] = new Health();
            }

            System.out.println("Enter the monthly fee for " + insurances[i].getType() + ": ");
            double fee = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            insurances[i].setInsuranceCost(fee);
        }

        System.out.println("Displaying insurance information:");
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
        }

        scanner.close();
    }
}

