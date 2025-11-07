/*Maria, a software developer, is building a grading automation system for Computer Science students. The program calculates the Grade Point Average (GPA) and determines class standing based on the number of credits completed.

The GPA is calculated using the formula:

GPA = 4.0 × (creditsCompleted / 120.0)
Where 120 credits are required for graduation, and the maximum possible GPA is 4.0.

The class standing is determined as follows:

Freshman: 0-29 credits
Sophomore: 30-59 credits
Junior: 60-89 credits
Senior: 90 or more credits

The program consists of three classes:

Student – Stores the student's name and age, and has a method displayInfo() to print these details.

Undergraduate – Inherits from Student, adds creditsCompleted, and includes calculateGPA() to compute the GPA and 
getClassStanding() to determine class standing.


ComputerScienceMajor – Extends Undergraduate, representing a Computer Science major without adding extra functionality.

Help Maria implement this system to calculate the GPA and class standing for Computer Science students.

Input format :
The first line contains the name of the student as a string (at most 20 characters).

The second line contains the age of the student as an integer.

The third line contains the number of credits completed by the student as a double.

Output format :
The first line of output prints: "Name: " followed by student_name (the name of the student).

The second line of output prints: "Age: " followed by student_age (the student's age).

The third line of output prints: "Credits Completed: " followed by credits_completed (the number of credits completed rounded to one decimal place).

The fourth line of output prints: "GPA: " followed by calculated_GPA (the GPA rounded to one decimal place).

The fifth line of output prints: "Class Standing: " followed by class_standing (the determined class standing based on credits completed). */

import java.util.*;

class Student{
    String name;
    int age;
    double creditsCompleted;
    double calculatedGPA;

    Student(String name, int age){
        this.name=name;
        this.age=age;
    }

    void displayResult(){
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
    }
}

class Undergraduate extends Student{
    Undergraduate(String name,int age,double creditsCompleted){
        super(name,age);
        this.creditsCompleted=creditsCompleted;
    }

    @Override
    void displayResult(){
        System.out.println("Name: "+this.name);
        System.out.println("Age: "+this.age);
        System.out.println("Credits Completed: "+this.creditsCompleted);
    }

    double calculateGPA(){
        return 4.0*(this.creditsCompleted / 120.0);
    }

    String getClassStanding(){
        if(this.creditsCompleted<=29) return "Freshers";
        else if(this.creditsCompleted<=59) return "Sophomore";
        else if(this.creditsCompleted<=89) return "Junior";
        else return "Senior";
    }
}

class ComputerScienceMajor extends Undergraduate{
    ComputerScienceMajor(String name,int age, double creditsCompleted){
        super(name,age,creditsCompleted);
    }
}

public class GradingManagementSystem {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the name: ");
        String name=sc.nextLine();

        System.out.println("Enter the age: ");
        int age=sc.nextInt();

        System.out.println("Enter the number of credits completed: ");
        double creditsCompleted=sc.nextDouble();

        ComputerScienceMajor csm=new ComputerScienceMajor(name,age,creditsCompleted);

        csm.displayResult();

        System.out.println("GPA: "+csm.calculateGPA());

        System.out.println("Class Standing: "+csm.getClassStanding());
        
        sc.close();
    }
}