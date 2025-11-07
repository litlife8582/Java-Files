import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Static_Initializer_Block {
static int B;
static int H;
public static void InitializeStaticVariable(){
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter the value of the Length and Breadth:");
 B=sc.nextInt();
 H=sc.nextInt();
 System.out.println();
}
public static void main(String[] args){
    InitializeStaticVariable();
		if(B>0 && H>0){
			int area=B*H;
			System.out.print(area);
		}
        else{
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
		
	}//end of main

}//end of class

