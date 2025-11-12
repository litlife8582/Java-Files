/*Rajesh, the owner of "Royal Event Halls," manages a collection of event halls available for booking. Each hall has details such as the name, contact number, cost per day, and owner’s name. Rajesh wants to display the list of available halls sorted by their daily cost in a tabular format, making it easier for his clients to choose based on their budget.

Help Rajesh by implementing a program that:

Accepts hall details (name, contact number, cost per day, owner’s name), stores them in a list, and sorts them by the cost per day using the Comparable interface.
Displays the details in a tabular format with columns: Hall Name, Contact Number, Cost Per Day, and Owner Name.

You will implement the Comparable interface in the Hall class. The generic interface method names should include:

getName(), setName(String name)
getContactNumber(), setContactNumber(String contactNumber)
getCostPerDay(), setCostPerDay(double costPerDay)
getOwnerName(), setOwnerName(String ownerName)
Use the compareTo() method to sort the halls, and ensure the program displays the details correctly in tabular form.

Input format :
The first line of input consists of an integer n, representing the number of halls.

The next n × 4 lines each contain hall details:

A String, representing the hall name
A String, representing the contact number
A double, representing the cost per day
A String, representing the owner’s name
Output format :
For each hall, print the following details in a single line, separated by a single space:

Hall Name
Contact Number
Cost Per Day (displayed with one decimal place)
Owner Name
The output should display halls in ascending order based on their cost per day.

*/

import java.util.*;

class Hall implements Comparable<Hall>{
    String name;
    String contactNumber;
    double cost;
    String ownername;

    Hall(String name,String contactNumber,double cost,String ownername){
        this.name=name;
        this.contactNumber=contactNumber;
        this.cost=cost;
        this.ownername=ownername;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getContactNumber(){
        return contactNumber;
    };

    public void setContactNumber(String contactNumber){
        this.contactNumber=contactNumber;
    }

    public double getCostPerDay(){
        return cost;
    }

    public void setCostPerDay(double costPerDay){
        this.cost=costPerDay;
    }

    public String getOwnerName(){
        return ownername;
    }

    public void setOwnerName(String ownerName){
        this.ownername=ownerName;
    }

    public int compareTo(Hall otherhall){
        return Double.compare(this.cost,otherhall.getCostPerDay());
    }
}

public class EventManagement {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of hall: ");
        int n=sc.nextInt();
        sc.nextLine();

        List<Hall> hall=new ArrayList<>();

        for(int i=0;i<n;i++){
            System.out.println("Hall "+(i+1)+":");
            System.out.print("Enter the hall name: ");
            String name=sc.nextLine();
            System.out.println();
            System.out.print("Enter the contact number: ");
            String contactNumber=sc.nextLine();
            System.out.print("Enter cost per day: ");
            double cost=sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter the owner's name: ");
            String ownername=sc.nextLine();

            hall.add(new Hall(name,contactNumber,cost,ownername));
        }

        Collections.sort(hall);

        for(Hall hallList:hall){
            System.out.printf("%s %s %.2f %s\n",hallList.getName(),hallList.getContactNumber(),hallList.getCostPerDay(),hallList.getOwnerName());
        }
    }
}
