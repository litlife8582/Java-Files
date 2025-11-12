/*
Problem Statement
You are tasked with developing a loan management system for a financial institution. The system should include a LoanCalculator class to calculate monthly loan payments, track the total interest paid, and monitor the remaining balance for various loan accounts.

To enhance this system, you need to implement an AdvancedLoanCalculator subclass that offers additional features and benefits for loan management. For each month, it will provide monthly payments, principal payments, interest payments, and the remaining balance. At the end, the total interest paid and the monthly payment should be displayed.

Your goal is to design and implement the AdvancedLoanCalculator to extend the capabilities of the LoanCalculator in a way that provides more comprehensive insights into loan management.

Formula:
The monthly loan payment (EMI) should be calculated using the standard amortization formula:
Where:
P = Principal (loan amount)
r = Monthly interest rate (Annual rate ÷ 12 ÷ 100)
n = Loan term in months

Interest Payment for a month ( Interest Payment = Remaining Principal × r )
Principal Payment ( Principal Payment = Monthly Payment − Interest Payment )
Remaining Balance after each month ( Remaining Balance = Previous Balance − Principal Payment )
Total Interest Paid ( Total Interest Paid = ∑ Interest Payment over all months )

Input format :
The first line of the input is a double value 'a', representing the Principal amount (loan amount) with two decimal places.
The second line of the input is a double value 'b', representing the Annual interest rate as a percentage with two decimal places.
The third line of the input is an integer value 'c', representing the Loan term in months.

Output format :
For each month of the loan term, the program will display the following details:
The first line of the output displays, the "Month " and is followed by the number (e.g., "Month 1:").
The second line of the output displays, the "Monthly Payment: " and is followed by the amount (formatted to two decimal places).
The third line of the output displays, the "Principal Payment: " and is followed by the amount (formatted to two decimal places).
The fourth line of the output displays, the "Interest Payment: " amount (formatted to two decimal places).
The fifth line of the output displays, the "Remaining Balance: " (formatted to two decimal places).
(between each month a blank line should be left)

At the end of all monthly outputs, display:
The output prints "Total Interest Paid: " followed by the total interest amount paid over the loan term, formatted to two decimal places.
The last line of output prints "Monthly Payment: " repeated again with the same monthly payment value (formatted to two decimal places) for summary.*/
//---------------------------------------------------------------------------------------------------------------------

import java.util.*;

class LoanCalculator{
    double p;
    double r;
    int t;
}

class AdvancedLoanCalculator extends LoanCalculator{
    AdvancedLoanCalculator(double p, double r,int t){
        this.p=p;
        this.r=r/(12*100);
        this.t=t;
    }

    void LoanManagementFeatures(){

        double rb=p;
        double emi=(p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
        for(int i=0;i<t;i++){
            double ip=rb*r;
            double pp=emi-ip;
            rb=rb-pp;

            System.out.println("Month "+(i+1));
            System.out.println("Monthly Payment: "+emi);
            System.out.println("Principal Payment: "+pp);
            System.out.println("Interest Payment: "+ip);
            if(rb<0) rb=0.00;
            System.out.println("Remaining Balance: "+rb);

        }
    }
}

public class FinanceCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principal amount: ");
        double p=sc.nextDouble();
        System.out.println("Enter the rate: ");
        double r=sc.nextDouble();
        System.out.println("Enter the time: ");
        int t=sc.nextInt();


        AdvancedLoanCalculator lc=new AdvancedLoanCalculator(p,r,t);
        lc.LoanManagementFeatures();
        sc.close();
    }
}