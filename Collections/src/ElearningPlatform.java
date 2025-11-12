/*Tony is an e-learning platform administrator, he oversees the user ratings for various online courses offered in the platform.

To enhance user experience, you should assist him in utilizing a HashMap to store course ratings given by learners. Regularly, he analyzes this data to identify the highest and lowest-rated courses, enabling targeted improvements and ensuring the quality of the educational content. This process assists in maintaining a competitive and engaging online learning environment for the users.

Input format :
The input consists of a string representing the course name, followed by a double value representing the course's rating, in separate lines.

The input is terminated by entering "done".

Output format :
The first line of output prints the string "Highest Rated Course: " followed by the highest-rated course.

The second line prints the string "Lowest Rated Course: " followed by the lowest-rated courses.*/
//---------------------------------------------------------------------------------------------------------------------
import java.util.*;

public class ElearningPlatform {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        HashMap<String,Double> map=new HashMap<>();
        String txt="";
        double rating;
        while(!txt.equals("done")){
            System.out.println("Enter the couse name (type done to exit): ");
            txt=sc.nextLine();
            if(txt.equals("done")) break;
            System.out.println("Enter the rating of the course: ");
            rating=sc.nextDouble();
            sc.nextLine();
            map.put(txt,rating);
        }

        String higestRatedCourse="";
        String lowestRatedCourse="";
        double higestRating=Double.MIN_VALUE;
        double lowestRating=Double.MAX_VALUE;

        for(Map.Entry<String,Double> entry:map.entrySet()){
            if(entry.getValue()>higestRating){
                higestRating= entry.getValue();
                higestRatedCourse= entry.getKey();
            }

            if(entry.getValue()<lowestRating){
                lowestRating= entry.getValue();
                lowestRatedCourse= entry.getKey();
            }
        }

        System.out.println("Highest Rated Course: "+higestRatedCourse);
        System.out.println("Lowest Rated Course: "+lowestRatedCourse);
    }
}
