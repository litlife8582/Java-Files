/*Sophia is developing a matrix analysis tool for a data analytics company. The tool needs to analyze square matrices and extract insights from the matrix diagonals.

To organize the code properly, Sophia creates an interface named Matrix that declares a method for finding the smallest and largest elements along the principal and secondary diagonals of the matrix.

Sophia then creates a class named MatrixAnalyzer that implements the Matrix interface. This class provides the logic to process a given square matrix and print:

The smallest and largest elements in the principal diagonal (from top-left to bottom-right).
The smallest and largest elements in the secondary diagonal (from top-right to bottom-left).

Your task is to implement the Matrix interface and the MatrixAnalyzer class. The main driver program (in the class Main) will read the input matrix, create an instance of MatrixAnalyzer, and invoke its method to display the results.

Input format :
The first line contains an integer n, representing the size of the square matrix.
The next n lines each contain n integers separated by spaces, representing the elements of the matrix.

Output format :
The output prints the four lines:
"Smallest Element - 1: <smallest element in the principal diagonal>" (integer)
"Largest Element - 1: <largest element in the principal diagonal>" (integer)
"Smallest Element - 2: <smallest element in the secondary diagonal>" (integer)
"Largest Element - 2: <largest element in the secondary diagonal>" (integer)

Refer to the sample output for the formatting specifications.
Code constraints :
Only an N x N matrix will be given as input.

Sample test cases :
Input 1 :
5
7 8 9 0 1
2 3 4 5 6
5 4 2 0 8
23 5 6 8 9
12 5 6 7 32
Output 1 :
Smallest Element - 1: 2
Largest Element - 1: 32
Smallest Element - 2: 1
Largest Element - 2: 12
Input 2 :
4
3 4 5 6
3 2 1 0
9 7 6 2
1 7 4 3
Output 2 :
Smallest Element - 1: 2
Largest Element - 1: 6
Smallest Element - 2: 1
Largest Element - 2: 7*/
//----------------------------------------------------------------------------------------------------------------

import java.util.*;

interface Matrix{
    int[] principalDiagonal(int arr[][]);
    int[] secondaryDiagonal(int arr[][]);
}

class MatrixAnalyser implements Matrix{
    @Override public int[] principalDiagonal(int arr[][]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++){
            int j=i;
            if(arr[i][j]>max) max=arr[i][j];
            if(arr[i][j]<min) min=arr[i][j];
        }

        return new int[]{min,max};
    }

    @Override public int[] secondaryDiagonal(int arr[][]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int j= arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i][j]>max) max=arr[i][j];
            if(arr[i][j]<min) min=arr[i][j];
            j--;
        }

        return new int[]{min,max};
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the square matrix: ");
        int n=sc.nextInt();

        int[][] arr=new int[n][n];
        System.out.println("Enter the elements of the matrix: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        MatrixAnalyser ma=new MatrixAnalyser();
        int[] primary=ma.principalDiagonal(arr);
        int[] secondary=ma.secondaryDiagonal(arr);

        System.out.println("Smallest Element - 1: "+primary[0]);
        System.out.println("Largest Element - 1: "+primary[1]);
        System.out.println("Smallest Element - 2: "+secondary[0]);
        System.out.println("Largest Element - 2: "+secondary[1]);

        sc.close();

    }
}

