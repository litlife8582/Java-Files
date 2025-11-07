import java.util.*;

public class Random_Number_Game {
    public int max(int x, int y, int m,int n){
        int w=(n>m?n:m)>(x>y?x:y)?(n>m?n:m):(x>y?x:y);
        return w;
    }
    public static void main(String args[]){
        int totalM=0,totalR=0,totalKala=0,totalKim=0;//declaring variable
        Random_Number_Game ss=new Random_Number_Game();
        String name;
        Random randNum=new Random();
        for(int j=1;j<3;j++)//Only two game allowed
        {
            System.out.println("Game: "+j);
            for(int i=1;i<5;i++){
                System.out.print("Enter the name of the player: ");
                Scanner scanin=new Scanner(System.in);
                name=scanin.next();

                switch(name){
                    case("Mohan"):
                        int scoreM=(1+(Math.abs(randNum.nextInt( )))%100);
                        totalM+=scoreM;
                        System.out.println("Present score= "+scoreM+" TotalM= "+totalM);
                        break;
                    case("Ram"):
                        int scoreR=(1+(Math.abs(randNum.nextInt(20)))%100);
                        totalM+=scoreR;
                        System.out.println("Present score= "+scoreR+" TotalR= "+totalR);
                        break;
                    case("Kala"):
                        int scoreKala=(1+(Math.abs(randNum.nextInt( )))%100);
                        totalKala+=scoreKala;
                        System.out.println("Present score= "+scoreKala+" TotalKala= "+totalKala);
                        break;
                    case("Kim"):
                        int scoreKim=(1+(Math.abs(randNum.nextInt( )))%100);
                        totalKim+=scoreKim;
                        System.out.println("Present score= "+scoreKim+" TotalKim= "+totalKim);
                        break;
                    default:
                        System.out.println("Sorry! Try again");
                }
            }
            int winner=ss.max(totalM,totalR,totalKala,totalKim);
            if(winner == totalM)
                System.out.println("The winner is: "+"Mohan");
            else if (winner==totalR)
                System.out.println("The winner is: "+"Ram");
            else if(winner == totalKala)
                System.out.println("THe winner is: "+"Kala");
            else if(winner == totalKim)
                System.out.println("The winner is: "+"Kim");
        }
    }
}
