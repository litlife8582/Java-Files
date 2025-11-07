import java.util.*;
public class TowersOfHanoi {
    public void towersOfHanoi(int n,char frompeg,char topeg,char auxpeg){
        if (n==0){
            return;
        }
        else {
            towersOfHanoi(n-1, frompeg, topeg, auxpeg);
            System.out.println("Move " + n + " from rod " + frompeg + " to rod " + auxpeg);
            towersOfHanoi(n-1, auxpeg, topeg, frompeg);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        TowersOfHanoi toh=new TowersOfHanoi();
        int n=sc.nextInt();
        char frompeg='A',auxpeg='B',topeg='C';
        toh.towersOfHanoi(n,frompeg,topeg,auxpeg);
    }
}
