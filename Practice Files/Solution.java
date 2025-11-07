import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result{
    public static String findDay(int day, int month, int year){
        Calendar calendar=new GregorianCalendar(day,month-1,year);
        int daysOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
        String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday",};
        return days[daysOfWeek-1];
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter date:");
        int day=sc.nextInt();
        int month=sc.nextInt();
        int year=sc.nextInt();
        System.out.println();
        System.out.println(findDay(day,month,year));

    }

}