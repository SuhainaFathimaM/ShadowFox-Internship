import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    basicArithmetic(scanner);
                    break;
                case 2:
                    scientificCalculations(scanner);
                    break;
                case 3:
                    unitConversions(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the calculator. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void basicArithmetic(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double result = 0;
        switch (choice) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Result: " + result);
    }

    private static void scientificCalculations(Scanner scanner) {
        System.out.print("Enter the number: ");
        double num = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("\nChoose an operation:");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double result = 0;
        switch (choice) {
            case 1:
                if (num < 0) {
                    System.out.println("Error: Square root of a negative number is not defined.");
                    return;
                }
                result = Math.sqrt(num);
                break;
            case 2:
                System.out.print("Enter the exponent: ");
                double exponent = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                result = Math.pow(num, exponent);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("Result: " + result);
    }

    private static void unitConversions(Scanner scanner) {
        System.out.println("\nChoose a conversion type:");
        System.out.println("1. Temperature (Celsius to Fahrenheit/Fahrenheit to Celsius)");
        System.out.println("2. Currency (USD to EUR/EUR to USD)");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                temperatureConversion(scanner);
                break;
            case 2:
                currencyConversion(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void temperatureConversion(Scanner scanner) {
        System.out.println("\nChoose conversion direction:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        double result = 0;
        if (choice == 1) {
            result = (temperature * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + result);
        } else if (choice == 2) {
            result = (temperature - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + result);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void currencyConversion(Scanner scanner) {
        System.out.println("\nChoose conversion direction:");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        double result = 0;
        // Assuming a fixed exchange rate for simplicity
        if (choice == 1) {
            result = amount * 0.9; // 1 USD = 0.9 EUR (approximation)
            System.out.println("Amount in EUR: " + result);
        } else if (choice == 2) {
            result = amount / 0.9; // 1 EUR = 1.11 USD (approximation)
            System.out.println("Amount in USD: " + result);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}