/*In ABC Company, Developers are tasked with developing a robust financial calculator system. The system consists of an abstract class FinancialCalculator with three key abstract methods: calculateCompoundInterest, calculateFutureValue, and calculateMonthlyLoanPayment. The system includes two subclasses, InvestmentCalculator and LoanCalculator. 

Users are prompted to input the principal amount, annual interest rate, and duration. Based on their choice between 1. Investment or a 2. loan, the system performs the relevant financial calculations and displays the results. 
Note:
Compound Interest = P(1+Rate/100)n - P
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
If there is a choice other than 1 and 2, the output prints "Invalid choice".*/


import java.util.*;

abstract class FinancialCalculator{
    abstract double calculateCompoundInterest();
    abstract double calculateFutureValue();
    abstract double calculateMonthlyLoanPayment();
}

class InvestmentCalculator extends FinancialCalculator{
    double p;
    double r;
    int t;

    InvestmentCalculator(double p,double r, int t){
        this.p=p;
        this.r=r;
        this.t=t;
    }
    
    @Override
    double calculateCompoundInterest(){
        return  p*Math.pow((1+r/100),t) - p;
    }

    @Override
    double calculateFutureValue(){
        return p*Math.pow((1+r/100),t);
    }

    @Override
    double calculateMonthlyLoanPayment(){return 0;};
}

class LoanCalculator extends FinancialCalculator{
    double p;
    double r;
    int t;

    LoanCalculator(double p, double r, int t){
        this.p=p;
        this.r=r;
        this.t=t;
    }

    @Override
    double calculateCompoundInterest(){
        return 0;
    }

    @Override
    double calculateFutureValue() {
        return 0;
    }

    @Override
    double calculateMonthlyLoanPayment(){
        return (p*(r/(12*100)))/(1-Math.pow(1+(r/(12*100)),-t*12));
    }
}

public class Financial_Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double p,r;
        int t,c;
        System.out.println("Enter the principal amount: ");
        p=sc.nextDouble();
        System.out.println("Enter the interest rate: ");
        r=sc.nextDouble();
        System.out.println("Enter the time in years: ");
        t=sc.nextInt();
        System.out.println("Options:\n 1. Investement \n 2.Loan\n Choice:");
        c=sc.nextInt();
        if(c==1){
            FinancialCalculator investment=new InvestmentCalculator(p,r,t);
            System.out.printf("Compound Interest: %.2f\n",investment.calculateCompoundInterest());
            System.out.printf("Future Value: %.2f",investment.calculateFutureValue());
        }else if(c==2){
            FinancialCalculator loan=new LoanCalculator(p, r, t);
            System.out.printf("Monthly Loan Payment: %.2f",loan.calculateMonthlyLoanPayment());
        }
        sc.close();
    }   
}
