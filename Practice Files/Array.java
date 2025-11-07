import java.util.Scanner;
public class Array {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            System.out.print("Enter the element in the array: ");
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<=n;i++)
        {
            System.out.print("The element in the array is "+arr[i]);
            System.out.println();
        }

    sc.close();
        }
    }

