import java.util.*;
import java.io.*;

class Java_Loop_II{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int multiply=0;
             for(double j=0;j<=n;j++){
                     multiply=(int)(a+(Math.pow(2,j))*b)+multiply;

                    System.out.print(multiply+" ");
             }             
        }
        in.close();
    }
}