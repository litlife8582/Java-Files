/*
Define a generic interface named Min with a single method findMin() that takes an array of type T as argument and returns the minimum element in the array. Define a class MinFinder that implements the Min interface.

The findMin() method of the MinFinder class should find the minimum element in the array using the Arrays.sort() method and return it.

The program should create an array of integers and an array of doubles, call the findMin() method on each array using an object of the MinFinder class, and print the minimum element returned by the method.

Input format :
The first line of input consists of an integer n, which represents the number of elements in the array.

The second line contains n space-separated integers, which are the elements of the array

Output format :
The output prints the minimum value from the array.*/
//---------------------------------------------------------------------------------------------------------------------

import java.util.*;

interface Min<T>{
    T findMin(T arr[]);
}

class MinFinder<T> implements Min<T>{
    @Override public T findMin(T arr[]){
        if(arr==null || arr.length==0){
            return null;
        }
        Arrays.sort(arr);
        T min=arr[0];
        return min;
    }
}

public class FindingMin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n=sc.nextInt();

        Integer arr1[]=new Integer[n];
        Double arr2[]=new Double[n];

        System.out.println("Enter the elements in integer array: ");
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }

        System.out.println("Enter the elements in double array: ");
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextDouble();
        }

        MinFinder<Integer> intobj=new MinFinder<>();
        MinFinder<Double> doubleobj=new MinFinder<>();

        System.out.println("Minimum element of integer array: "+intobj.findMin(arr1));
        System.out.println("Minimum element of double array: "+doubleobj.findMin(arr2));

    }
}