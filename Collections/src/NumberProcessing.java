/*Bobby is tasked with processing a sequence of numbers from a monitoring system. He needs to extract a strictly increasing subsequence using an ArrayList. The program should dynamically add numbers to the ArrayList only if they are greater than the last number currently stored in the list. Bobby aims to efficiently utilize the dynamic resizing and indexing features of the ArrayList to solve this problem.

Help Bobby implement this solution.

Input format :
The first line of input consists of an integer N, representing the number of elements.

The second line consists of N space-separated integers, representing the elements.

Output format :
The output prints the list of integers in increasing sequence, ignoring out-of-order elements.*/
//-------------------------------------------------------------------------------------------------------------------4

import java.util.*;

public class NumberProcessing {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> arrlist=new ArrayList<>();
        System.out.println("Enter the number of elements: ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if(arrlist.isEmpty()) arrlist.add(num);
            else if(num>arrlist.get(arrlist.size()-1)) arrlist.add(num);
        }

        for(int arr:arrlist){
            System.out.println(arr+" ");
        }
        sc.close();
    }
}
