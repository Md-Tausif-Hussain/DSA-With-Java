import java.util.Scanner;
public class EMICalculator {
    // Method to calculate EMI
    public static double calculateEMI(double principal, double annualRate, int tenure) {
        double monthlyRate = annualRate / (12 * 100); // Converting annual interest rate to monthly and in decimal
        int numberOfMonths = tenure * 12; // Converting tenure in years to months
        // EMI formula
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfMonths)) / 
                     (Math.pow(1 + monthlyRate, numberOfMonths) - 1);
        
        return emi;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for principal, annual interest rate and tenure
        System.out.print("Enter the loan amount (Principal): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the tenure of loan (in years): ");
        int tenure = scanner.nextInt();

        // Calculating EMI
        double emi = calculateEMI(principal, annualRate, tenure);

        // Displaying the EMI
        System.out.printf("The monthly EMI is: %.2f\n", emi);

        scanner.close();
    }
}
