import java.util.Scanner;
// Define the Person class
class Person {
    private double weight; // in kilograms
    private double height; // in meters
    // Constructor
    public Person(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    // Getter for weight
    public double getWeight() {
        return weight;
    }
    // Getter for height
    public double getHeight() {
        return height;
    }
    // Method to calculate BMI
    public double calculateBMI() {
        return weight / (height * height);
    }
    // Method to get BMI category
    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
// Define the BMICalculator class
public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter weight
        System.out.print("Enter weight in kilograms: ");
        double weight = scanner.nextDouble();

        // Prompt the user to enter height
        System.out.print("Enter height in meters: ");
        double height = scanner.nextDouble();

        // Create a Person object with user inputs
        Person person = new Person(weight, height);

        // Calculate BMI and get BMI category
        double bmi = person.calculateBMI();
        String category = person.getBMICategory();

        // Display the results
        System.out.println("BMI: " + bmi);
        System.out.println("BMI Category: " + category);

        // Close the scanner
        scanner.close();
    }
}
