import java.util.*;

public class Target {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter target:");
        int target=sc.nextInt();
        System.out.println("Enter length of array:");
        int len=sc.nextInt();
        int[] arr=new int[len];
        System.out.println("Enter array elements:");
        for(int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }   

        int flag=0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i;j<arr.length;j++) {
                if(i==j)
                continue;

                if(arr[i]+arr[j]==target) {
                    flag++;
                    System.out.println("Match at indices "+i+" and "+j);
                    break;
                }
            }
        }
        if(flag==0)
        System.out.println("Not found");
    }
}