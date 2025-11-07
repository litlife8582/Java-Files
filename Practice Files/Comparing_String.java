import java.util.*;

public class Comparing_String
{

    public static void main(String[] args) 
    {
        
        Scanner sc=new Scanner(System.in);
        String C=sc.next();
        String D=sc.next();
        /*Enter your code here. Print output to STDOUT. */
                String A=C.toUpperCase();
                String B=D.toUpperCase();
                int lenA=C.length();
                int lenB=D.length();
                int sum=lenA+lenB;
                System.out.println(sum);
                int len;
                if(lenA>lenB)
                {
                    len=lenA;
                    for(int i=0; i<(lenA-lenB);i++)
                    {
                        A=A+" ";
                    }
                } 
                else
                {
                    len=lenB;
                    for(int i=0; i<(lenB-lenA);i++)
                    {
                        B=B+" ";
                    }
                }
                for(int i=0; i<len;i++)
                {
                    int letterA=A.charAt(i);
                    int letterB=B.charAt(i);
                    int AsciiA=(int)letterA;
                    int AsciiB=(int)letterB;
                    if(AsciiA != AsciiB)
                    {
                    if(AsciiA>AsciiB)
                    {
                        System.out.println("Yes");
                        break;
                    }
                    else
                    {
                        System.out.println("No");
                        break;
                    }
                    }
                    
                }
                char UC=C.charAt(0);
                char UD=D.charAt(0);
                String c=Character.toString(UC);
                String d=Character.toString(UD);
                c=c.toUpperCase();
                d=d.toUpperCase();
                String FC=C.substring(1,lenA);
                String FD=D.substring(1,lenB);
                FC=c+FC;
                FD=d+FD;
                System.out.print(FC+" ");
                System.out.println(FD);
                sc.close();

    }
}




