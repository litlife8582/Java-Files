import java.util.*;
public class Days {
    public void AcceptDate(){
       
    }
    public int CalculateDays(int d, int m, int y){
        int date=0;
        int arr[]={0,31,0,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<=y-1;i++){
            if(y%4==0){
                if(y%100==0){
                    if(y%400==0) arr[2]=29;
                    else arr[2]=28;
                }
                else arr[2]=28;
            }
            else arr[2]=28;
        }
        for(int i=1;i<m;i++){
            date+=arr[i];
        }
        date+=d;
        return date;
        
    }
    public int CalculateYear(int y){
        int year=0;
        for(int i=0;i<=y-1;i++){
            if(y%4==0){
                if(y%100==0){
                    if(y%400==0) year+=366;
                    else year+=365;
                }
                else year+=365;
            }
            else year+=365;
            }
        return year;
        }
    
    public static void main(String[] args){
        Days days=new Days();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First date in DD/MM/YYYY");
        int d_i=sc.nextInt();
        int m_i=sc.nextInt();
        int y_i=sc.nextInt();
        int date_i=days.CalculateDays(d_i, m_i,y_i);
        int year_i=days.CalculateYear(y_i);
        int finaldays_i=date_i+year_i;

        System.out.println("Enter the Last date in DD/MM/YYYY");
        int d_f=sc.nextInt();
        int m_f=sc.nextInt();
        int y_f=sc.nextInt();
        int date_f=days.CalculateDays(d_f, m_f,y_f);
        int year_f=days.CalculateYear(y_f);
        int finaldays_f=date_f+year_f;

        int finaldays=finaldays_f-finaldays_i;
        System.out.println(finaldays);
        sc.close();


    }
}
