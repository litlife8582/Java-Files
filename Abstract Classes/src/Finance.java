/*
In ABC Company, Developers are tasked with developing a robust financial calculator system. The system consists of an abstract class FinancialCalculator with three key abstract methods: calculateCompoundInterest, calculateFutureValue, and calculateMonthlyLoanPayment. The system includes two subclasses, InvestmentCalculator and LoanCalculator.

Users are prompted to input the principal amount, annual interest rate, and duration. Based on their choice between 1. Investment or a 2. loan, the system performs the relevant financial calculations and displays the results.

Note:
Compound Intrest = P(1+Rate/100)n - P
Future Value = P(1+Rate/100)n
Loan/Month = (Loan Amount * Monthly Interest)/(1-(1+Monthly Interest)n
Monthly Loan Payment (EMI) = P×r / (1 − (1+r)-n)
where:
P = Principal / Loan Amount
r = Monthly Interest Rate = Annual Interest Rate / (12×100)
n = Total Number of Months = Years × 12

Input format :
The first line of input consists of a double value, representing the principal amount.
The second line of input consists of a double value, representing the interest rate.
The third line of input consists of an integer, representing the duration in years.
The fourth line of input consists of an integer(1 or 2), representing the Investment Calculator / Loan Calculator.

Output format :
If the choice is the Investment Calculator
The first line of output prints "Compound Interest: " followed by a double value representing the compound interest rounded to 2 decimal places.
The second line of output prints "Future Value: "followed by a double value representing the future value rounded to 2 decimal places.
If the choice is the Loan Calculator
    The output prints "Monthly Loan Payment: " followed by a double value, representing the Monthly loan payments rounded to 2 decimal places.
    If there is a choice other than 1 and 2, the output prints "Invalid choice".

Refer to the sample output for the formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ choice ≤ 2

1 ≤ Principal Amount ≤ 109

1 ≤ Rate of Interest ≤ 99

1 ≤ Duration ≤ 50﻿

Sample test cases :
Input 1 :
10000.0
5.0
3
1
Output 1 :
Compound Interest: 1576.25
Future Value: 11576.25
Input 2 :
25000.9
9.7
1
2
Output 2 :
Monthly Loan Payment: 2194.49
Input 3 :
500000.0
8.7
5
3
Output 3 :
Invalid choice */
//---------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.lang.*;

abstract class FinancialCalculator{


    abstract void calculateCompoundInterest();
    abstract void calculateFutureValue();
    abstract void calculateMonthlyLoanPayment();
}

class InvestmentCalculator extends FinancialCalculator{
    double p;
    double r;
    int t;

    InvestmentCalculator(double p, double r,int t){
        this.p=p;
        this.r=r;
        this.t=t;
    }

    @Override void calculateCompoundInterest(){
        System.out.println("Compound Interest: "+(p*Math.pow((1+r/100),t)-p));
    }

    @Override void calculateFutureValue(){
        System.out.println("Future Value: "+(p*Math.pow((1+r/100),t)));
    }

    @Override void calculateMonthlyLoanPayment(){

    }
}

class LoanCalculator extends FinancialCalculator{
    double p;
    double r;
    int t;

    LoanCalculator(double p, double r,int t){
        this.p=p;
        this.r=r;
        this.t=t*12;
    }

    @Override void calculateCompoundInterest(){

    }

    @Override void calculateFutureValue(){

    }

    @Override void calculateMonthlyLoanPayment(){
        System.out.println("Monthly Loan Payment: "+(p*(r/(12*100))/(1-Math.pow(1+r,-t))));
    }
}

public class Finance {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principal amount: ");
        double principalAmount=sc.nextDouble();
        System.out.println("Enter the interest rate: ");
        double rate=sc.nextDouble();
        System.out.println("Enter the duration in years: ");
        int year=sc.nextInt();
        System.out.println("Enter the choice (1 for Investment Calculator / 2 for Loan Calculator:");
        int c=sc.nextInt();

        FinancialCalculator calc;

        if(c==1){
            calc=new InvestmentCalculator(principalAmount,rate,year);
            calc.calculateCompoundInterest();
            calc.calculateFutureValue();
        }else if(c==2){
            calc=new LoanCalculator(principalAmount,rate,year);
            calc.calculateMonthlyLoanPayment();
        }else{
            System.out.println("Invalid input.");
        }
        sc.close();
    }
}
