package com.pluralsight;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculators
{
    public static void main(String[] args)
    {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Choose a Calculator: ");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value");
        System.out.println("3. Present Value");
        System.out.print("Choose from 1-3: ");

        int Decision = scanner.nextInt();
        while (Decision < 1 || Decision > 3)
        {
            System.out.println("Choose between 1 and 3: ");
            Decision = scanner.nextInt();
        }
        if (Decision == 1)
        {
            System.out.println("Enter the principal: ");
            double principal = scanner.nextDouble();
            System.out.println("Enter the Interest Rate: ");
            double InterestRate = scanner.nextDouble();
            System.out.println("Enter the Loan Length: ");
            double LoanLength = scanner.nextDouble();

            double monthlyInterest = InterestRate / 100 / 12;
            double numberofpayments = LoanLength * 12;

            double Power = Math.pow(1 + monthlyInterest, numberofpayments);
            double monthlyPayment = principal * (monthlyInterest * Power / (Power - 1));

            double TotalPayments = monthlyPayment * numberofpayments;
            double totalInterest =  TotalPayments - principal;

            System.out.printf("Your Monthly Payment is: $ %.2f and your total interest is: $ %.2f", monthlyPayment, totalInterest);
        }
        else if (Decision == 2)
        {
            System.out.println("Enter the deposit: ");
            double deposit = scanner.nextDouble();
            System.out.println("Enter the Interest Rate: ");
            double InterestRate = scanner.nextDouble();
            System.out.println("Enter the Number of Years: ");
            double years = scanner.nextDouble();

            InterestRate = InterestRate / 100;
            double fv = Math.pow((1 + InterestRate), years);
            double endingBalance = deposit * fv;

            double earnedInterest = endingBalance - deposit;

            System.out.printf("Your CD's ending balance will be $%.2f and you would have earned $%.2f in interest.", endingBalance, earnedInterest);
        }
        else if (Decision == 3)
        {
            System.out.println("Enter the Monthly Payout: ");
            double deposit = scanner.nextDouble();
            System.out.println("Enter the Expected Interest Rate: ");
            double userInterestRate = scanner.nextDouble();
            System.out.println("Enter the Years to Pay: ");
            double years = scanner.nextDouble();
            
            double InterestRate = (userInterestRate / 100) / 12;

            double totalToInvest = (deposit * ((1 - (Math.pow((1 + InterestRate), (-12 * years)))) / InterestRate));

            System.out.printf("To fund an annuity that pays %.2f monthly for %.0f years and earns an expected %.2f interest, you will need to invest $%.2f today.", deposit, years, userInterestRate, totalToInvest);

        }


    }
}
