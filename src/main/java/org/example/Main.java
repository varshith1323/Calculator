package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1: Square Root (√x)");
            System.out.println("2: Factorial (x!)");
            System.out.println("3: Natural Logarithm (ln(x))");
            System.out.println("4: Power (x^b)");
            System.out.println("0: Exit");

            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter a number: ");
                        double num = scanner.nextDouble();
                        if (num < 0) {
                            logger.error("Attempt to take square root of negative number: " + num);
                            System.out.println("Error: Cannot take square root of negative number.");
                        } else {
                            logger.info("Calculating square root of: " + num);
                            System.out.println("√" + num + " = " + sqrt(num));
                        }
                        break;
                    case 2:
                        System.out.print("Enter an integer: ");
                        int factNum = scanner.nextInt();
                        if (factNum < 0) {
                            logger.error("Attempt to calculate factorial of negative number: " + factNum);
                            System.out.println("Error: Cannot calculate factorial of negative number.");
                        } else {
                            logger.info("Calculating factorial of: " + factNum);
                            System.out.println(factNum + "! = " + factorial(factNum));
                        }
                        break;
                    case 3:
                        System.out.print("Enter a number: ");
                        double logNum = scanner.nextDouble();
                        if (logNum <= 0) {
                            logger.error("Attempt to calculate natural logarithm of non-positive number: " + logNum);
                            System.out.println("Error: Cannot calculate natural logarithm of non-positive number.");
                        } else {
                            logger.info("Calculating natural logarithm of: " + logNum);
                            System.out.println("ln(" + logNum + ") = " + naturalLog(logNum));
                        }
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        logger.info("Calculating " + base + "^" + exponent);
                        System.out.println(base + "^" + exponent + " = " + power(base, exponent));
                        break;
                    case 0:
                        logger.info("Exiting the calculator.");
                        System.exit(0);
                        break;
                    default:
                        logger.warn("Invalid option selected: " + choice);
                        System.out.println("Error: Invalid option. Please try again.");
                }
            } catch (Exception e) {
                logger.error("Exception encountered: " + e.getMessage(), e);
                System.out.println("Error: An unexpected error occurred.");
            }
        }
    }

    // Method for Square Root calculation
    public static double sqrt(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Sqrt is not defined for negative numbers.");
        }
        return Math.sqrt(num);
    }

    // Method for Factorial calculation
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Method for Natural Logarithm calculation
    public static double naturalLog(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Natural logarithm is undefined for non-positive numbers.");
        }
        return Math.log(num);
    }

    // Method for Power calculation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}