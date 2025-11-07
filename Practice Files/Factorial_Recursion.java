import java.util.*;
public class Factorial_Recursion {
    public int factorial(int num){
        int fac;
        if(num==0 || num==1){  //Base Case
            return 1;
        }
        else{ //Recursive Case
            fac=num*factorial(num-1);
        }
        return fac;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Factorial_Recursion fc=new Factorial_Recursion();
        System.out.println(fc.factorial(num));
    }
}
