import java.util.*;
public class Sorting_Array {
    public boolean isSorted(int[] arr, int index) {
        if (index <= 1) {
            return true;
        }
        if (arr[index - 1] < arr[index - 2]) {
            return false;
        }
        return isSorted(arr,index - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        boolean flag = new Sorting_Array().isSorted(arr, n);
        if (flag) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted");
        }
    }
}