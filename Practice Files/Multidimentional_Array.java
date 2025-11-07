import java.util.Scanner;
public class Multidimentional_Array {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows in the array:");
        int r=sc.nextInt();
        System.out.println("Enter the number of columns in the array:");
        int c=sc.nextInt();
        int[][] arr=new int[r][c];
        for(int i=0,j=0;i<=r && j<=c;i++,j++)
        {
            System.out.print("Enter value for element [" + i + "][" + j + "]: ");
            arr[i][j]=sc.nextInt();
        }
        System.out.println();
        for(int i=0,j=0;i<=r && j<=c;i++,j++)
        {
            System.out.println(arr[i][j]);
        }
    }
    
}
