/*Create a class Customer with name, address, and phone as attributes. Implement polymorphism by overriding methods in a subclass VIPCustomer to apply discounts for VIP customers. */

import java.util.*;

class Customer{
    int id;
    String name;
    String address;
    int ph;

    Customer(int id,String name, String address, int ph){
        this.id=id;
        this.name=name;
        this.address=address;
        this.ph=ph;
    }

    void display(String name,String address, int ph){
        System.out.println("Name of the customer: "+name);
        System.out.println("Address of the customer: "+address);
        System.out.println("Phone number: "+ph);
    }

    void discounts(int id,double bill){
        double discountedValue=bill-(bill*5.0/100);
        System.out.println("Discounted value(5%): "+discountedValue);
    }
}

class VIPCustomer extends Customer{
    VIPCustomer(int id,String name, String address, int ph){
        super(id,name,address,ph);
    }

    @Override void discounts(int id,double bill){
        double discountedValue=bill-(bill*12.0/100);
        System.out.println("Discounted value(12%): "+discountedValue);
    }
}

public class CustomerManager{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Customer customer;
        
        System.out.println("Enter the customer id:");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name of the Customer: ");
        String name=sc.nextLine();

        System.out.println("Enter the Address: ");
        String address=sc.nextLine();

        System.out.println("Enter the Phone no.");;
        int ph=sc.nextInt();

        System.out.println("Enter total bill: ");
        double bill=sc.nextDouble();

        if(id>10){
            customer=new Customer(id, name, address, ph);
            customer.display(name, address, ph);
            customer.discounts(id, bill);
        }else{
            customer=new VIPCustomer(id, name, address, ph);
            customer.display(name, address, ph);
            customer.discounts(id, bill);
        }
        sc.close();
    }
}
