import java.util.*;

public class Permutation {
    static int calculatePermutation(int n){
        if(n<0){
            throw new IllegalArgumentException("Error: Negative value of n");
        }
        int p=1;
        for(int i=1;i<=n;i++){
            p*=i;
        }
        return p;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            int n=sc.nextInt();
            System.out.println("Permutation is: "+calculatePermutation(n));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }    
}
