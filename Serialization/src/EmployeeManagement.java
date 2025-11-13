/*Riya is working on an HR management system that needs to store and retrieve employee records using object serialization. The system should allow storing multiple employees' details and later retrieve only those earning above a given salary threshold.

Your task is to implement a Java program that:

Takes multiple employee records as input, where each employee has:
employee_id (Integer)
name (String)
department (String)
salary (Double)
Serializes the employee records into a file named "employees.ser".
Deserializes the records from the file and prints employees' earnings above a given threshold.
Input format :
The first line consists of an integer n, representing the number of employees.

The next n lines contain the employee details: each line contains an integer employee_id, a string name, a string department, and a double salary.

The last line contains a double value X, the salary threshold.

Output format :
If an employee’s salary is greater than X, print: "employee_id name department salary"

If no employees meet the criteria, print: "No employees found above threshold"*/

import java.io.*;
import java.util.*;

class Employee implements Serializable{
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id,String name,String dept,double salary){
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }
}

public class EmployeeManagement {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        List<Employee> serEmp=new ArrayList<>();
        List<Employee> deserEmp=new ArrayList<>();


        System.out.print("Enter the number of employee: ");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("Employee "+(i+1));
            System.out.print("Enter the employee id: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the employee name: ");
            String name=sc.nextLine();
            System.out.print("Enter the department: ");
            String dept=sc.nextLine();
            System.out.print("Enter the salary: ");
            double salary=sc.nextDouble();

            serEmp.add(new Employee(id,name,dept,salary));
        }

        //serialization
        try(FileOutputStream fout=new FileOutputStream("employeeFile.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout)){
            out.writeObject(serEmp);
        }catch(IOException e){
            System.out.println("File does not exists.");
        }

        //deserialization
        try(FileInputStream fin=new FileInputStream("employeeFile.txt");
            ObjectInputStream in=new ObjectInputStream(fin)){
            deserEmp=(List<Employee>) in.readObject();
        }catch(IOException e){
            System.out.println("File not found.");
        }catch(ClassNotFoundException e){
            System.out.println("Class not found.");
        }

        System.out.print("Enter the salary threshold: ");
        double x=sc.nextDouble();

        System.out.println("Employee details with salary greater than threshold: ");
        for(Employee emp: deserEmp){
            if(emp.salary>x){
                System.out.println("ID: "+emp.id+" Name: "+emp.name+" Salary: "+emp.salary+" Department: "+ emp.dept);
            }
        }

        sc.close();
    }
}
