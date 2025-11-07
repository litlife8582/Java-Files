/*Create an Employee class with members empNo, name, department, and salary. Use a one-dimensional array of Employee objects (size 10) to read the data for 5 employees from command line arguments. Display the data and determine which employee has the highest salary. */

import java.util.*;

class Employee{
    int empNo;
    String name;
    String department;
    double salary;

    Employee(int empNo,String name,String department,double salary){
        this.empNo=empNo;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    void display(){
        System.out.println("Employee no.: "+empNo);
        System.out.println("Name: "+name);
        System.out.println("Department: "+department);
        System.out.println("Salary: "+salary);
        System.out.println("------------------------");
    }
}

public class EmployeeManager {
    static int higestSalary(Employee obj[]){
        double max=Double.MIN_VALUE;
        int index=-1;
        for(int i=0;i<5;i++){
            if(obj[i].salary>max){
                max=obj[i].salary;
                index=i;
            }
        }
        return index;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Employee[] obj=new Employee[10];
        for(int i=0;i<5;i++){
            System.out.print("Employee No.:"+(i+1));
            System.out.print("Enter the employee id: ");
            int empNo=sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the name if the employee: ");
            String name=sc.nextLine();

            System.out.print("Enter the department of the employee: ");
            String department=sc.nextLine();

            System.out.print("Enter the salary of the employee: ");
            double salary=sc.nextDouble();

            obj[i]=new Employee(empNo,name,department,salary);
        }

        for(int i=0;i<5;i++){
            obj[i].display();
        }

        int index=higestSalary(obj);

        System.out.println("The Employee with highest salary is: "+obj[index].name);
        sc.close();
    }
}
