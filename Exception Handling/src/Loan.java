/*
* Jamie is developing a banking application that manages loan repayments and account balances with specific rules and constraints. The application must ensure proper validation and handle various custom exceptions related to loan repayments:

Loan Overdue: If the loan is overdue by more than 60 days, throw LoanOverdueException with the message:
"Loan is overdue by more than 60 days. Immediate payment required."
*
Negative Repayment Amount: If the loan repayment amount is negative, throw NegativeLoanRepaymentAmountException with the message:
"Loan repayment amount cannot be negative."

Insufficient Funds: If the remaining balance after withdrawal is less than the minimum loan repayment amount, throw InsufficientFundsForLoanRepaymentException with the message:
"Insufficient funds to cover loan repayment after withdrawal."

The logic used for the withdrawal is:
Step 1: remainingBalance = balance − amount
Step 2: If remainingBalance < minLoanRepayment, throw exception.
Step 3: Else, update:
balance = balance − amount − minLoanRepayment
loanAmount = loanAmount − minLoanRepayment

Input format :
The first line of input consists of a double value b, representing the initial balance of the bank account.
The second line consists of a double value o, representing the outstanding loan amount.
The third line consists of a double value m, representing the minimum loan repayment amount.
The fourth line consists of an integer n, representing the number of days the loan is overdue.
The fifth line consists of a double value w, representing the amount to withdraw from the bank account.

Output format :
Successful Withdrawal and Repayment:
The first line of output prints: "Remaining Balance: " followed by the balance (rounded to two decimal places)
The second line of output prints: "Remaining Loan Amount: " followed by loanAmount (rounded to two decimal places)

Loan Overdue by More Than 60 Days:

The only line of output prints: "Loan is overdue by more than 60 days. Immediate payment required."

Negative Withdrawal Amount:

The only line of output prints: "Loan repayment amount cannot be negative."
*
Insufficient Funds for Loan Repayment After Withdrawal:
The only line of output prints: "Insufficient funds to cover loan repayment after withdrawal."
Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ balance ≤ 1,000,000 (Initial bank balance must be at least 1)

0 ≤ loanAmount ≤ 1,000,000 (Loan amount can be zero or more)

1 ≤ minLoanRepayment ≤ loanAmount (Minimum loan repayment must be at least 1 and not exceed the loan amount)

0 ≤ daysOverdue ≤ 365 (Overdue days range from 0 to 365)

0 ≤ amount ≤ balance (Withdrawal amount must be non-negative and not exceed the available balance)

Sample test cases :
Input 1 :
5000
2000
300
30
1500
Output 1 :
Remaining Balance: 3200.00
Remaining Loan Amount: 1700.00
Input 2 :
4000
1500
600
10
3500
Output 2 :
Insufficient funds to cover loan repayment after withdrawal.
Input 3 :
6000
2500
500
20
-200
Output 3 :
Loan repayment amount cannot be negative.
Input 4 :
7000
3000
700
65
1500
Output 4 :
Loan is overdue by more than 60 days. Immediate payment required.*/


import java.util.*;

class LoanOverdueException extends Exception{
    public LoanOverdueException(String m){
        super(m);
    }
}

class NegativeLoanRepaymentAmountException extends Exception{
    public NegativeLoanRepaymentAmountException(String m){
        super(m);
    }
}

class InsufficientFundsForLoanRepaymentException extends Exception{
    public InsufficientFundsForLoanRepaymentException(String m){
        super(m);
    }
}

public class Loan {
    private double[] ProcessTransaction(double initialBalance,double outstandingLoanAmount,double minimumLoanRepaymentAmount,int overdueDays,double amountToWithdraw) throws LoanOverdueException, NegativeLoanRepaymentAmountException, InsufficientFundsForLoanRepaymentException{
            if(overdueDays>60){
                throw new LoanOverdueException("Loan is overdue by more than 60 days. Immediate payment required.");
            }

            if(amountToWithdraw<0){
                throw new NegativeLoanRepaymentAmountException("Loan repayment amount cannot be negative.");
            }

            double remainingBalance=initialBalance-amountToWithdraw;

            if(outstandingLoanAmount<minimumLoanRepaymentAmount){
                throw new InsufficientFundsForLoanRepaymentException("Insufficient funds to cover loan repayment after withdrawal.");
            }

            double finalBalance=remainingBalance-minimumLoanRepaymentAmount;
            double loanAmount=outstandingLoanAmount-minimumLoanRepaymentAmount;

            return new double []{finalBalance,loanAmount};
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Loan l=new Loan();

        try {
            System.out.println("Enter the initial balance: ");
            double b = sc.nextDouble();//initial balance
            System.out.println("Enter he outstanding loan amount: ");
            double o = sc.nextDouble();//outstanding loan amount
            System.out.println("Enter the minimum loan repayment amount: ");
            double m = sc.nextDouble();//minimum loan repayment amount
            System.out.println("Enter the number of days overdue amount: ");
            int n = sc.nextInt();//number of days overdue
            System.out.println("Enter the amount to withdraw from bank account: ");
            double w = sc.nextDouble();//amount to withdraw from the bank account

            double[] result=l.ProcessTransaction(b,o,m,n,w);

            System.out.println("Remaining balance: "+result[0]);
            System.out.println("Remaining Loan amount: "+result[1] );
        }catch(LoanOverdueException | NegativeLoanRepaymentAmountException | InsufficientFundsForLoanRepaymentException e){
            System.out.println(e.getMessage());
            return;
        }finally{
            sc.close();
        }
    }
}