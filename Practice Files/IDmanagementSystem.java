import java.util.*;
public class IDmanagementSystem {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
            int n=sc.nextInt();
            if(n<1 || n>500) throw new IllegalArgumentException("Error: Number of user IDs must be between 1 and 500");
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int i=sc.nextInt();
            int s=sc.nextInt();

            System.out.println(arr[i]);
            arr[i]=s;
            System.out.println(arr[i]);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Invalid index. Please select a valid index from the list");
        }catch(InputMismatchException e){
            System.out.println("Error: Please enter valid integer values for user IDs");
        }finally{
            sc.close();
        }
    }    
}
