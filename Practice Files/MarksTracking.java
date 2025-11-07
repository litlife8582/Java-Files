/*Kavi, a student, is preparing for his exams and needs to track his marks across multiple subjects. He has a method for adding marks for individual subjects and another method to add marks for two subjects at once. He also needs to calculate his average marks and includes a bonus in the calculation. Based on his marks, he wants to know his grade. Help Kavi implement a solution to track and compute his results.

Help him to implement the task.

Methods Specification:
addMarks: This method should be overloaded to support both adding a single mark for a subject (addMarks(int marks)) and adding marks for two subjects (addMarks(int marks1, int marks2)).

calculateAverage: This method should be overloaded to support calculating the average marks, both without a bonus (calculateAverage()) and with a bonus (calculateAverage(int bonus)).

calculateGrade: This method takes the marks for a subject and calculates the grade based on the following conditions:
If marks are 90 or above, return "Excellent".
If marks are between 80 and 89, return "Good".
If marks are between 70 and 79, return "Average".
If marks are between 60 and 69, return "Below Average".
If marks are below 60, return "Fail".

Formulas:
Average:
average = totalMarks / subjects
Bonus Average:
bonusAverage = (totalMarks + bonus) / subjects

Input format :
The first line of input consists of a String name, representing the name of the student (in this case, Kavi).

The second line of input consists of an Integer marks1, representing the marks for the first subject.

The third line of input consists of an Integer marks2, representing the marks for the second subject.

The fourth line of input consists of an Integer marks3, representing the marks for the third subject.

The fifth line of input consists of an Integer bonus, representing the bonus marks to be added to the total marks for calculating the bonus average.

Output format :
The first line of output prints: "Basic Average: " followed by the value of average1 (average without bonus).

The second line of output prints: "Bonus Average: " followed by the value of average2 (average with bonus).

The third line of output prints: "Word Grade: " followed by the grade for marks1. */

import java.util.*;

class Marks{
    String name;
    int totalMarks;
    int subjects;

    Marks(String name){
        this.name=name;
        this.totalMarks=0;
        this.subjects=0;
    }

    void addMarks(int marks){
        totalMarks+=marks;
        subjects++;
    }

    void addMarks(int marks1, int marks2){
        totalMarks+=marks1;
        totalMarks+=marks2;
        subjects+=2;
    }

    double CalculateAverage(){
        if(subjects==0){
            return 0.0;
        }
        return totalMarks/subjects;
    }

    double CalculateAverage(int bonus){
        return (totalMarks+bonus)/subjects;
    }

    String CalculateGrade(int marks){
        if(marks>90) return "Excellent";
        else if(marks>80) return "Good";
        else if(marks>70) return "Average";
        else if(marks>60) return "Below Average";
        else return "Fail";
    }
}

public class MarksTracking {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the name: ");
        String name=sc.nextLine();

        System.out.println("Enter the marks of subject 1: ");
        int marks1=sc.nextInt();

        System.out.println("Enter the marks of subject 2: ");
        int marks2=sc.nextInt();

        System.out.println("Enter the marks of subject 3: ");
        int marks3=sc.nextInt();

        System.out.println("Enter the bonus: ");
        int bonus=sc.nextInt();

        Marks m=new Marks(name);
        m.addMarks(marks1);
        m.addMarks(marks2,marks3);

        System.out.println("Calculated average: "+m.CalculateAverage());

        System.out.println("Calculated bonus average: "+ m.CalculateAverage(bonus));

        System.out.println(m.CalculateGrade(marks1));
        sc.close();
    }
}