import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Array_List
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> array=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            array.add(a);
        }
        if(array.size()>2){
        array.remove(2);
        }
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
        sc.close();
    }
}
/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        
        // Read n elements
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            array.add(a);
        }
        
        // Remove the element at index 2 if it exists
        if (array.size() > 2) {
            array.remove(2);
        }
        
        // Print the elements of the list
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        
        sc.close();
    }
}*/
