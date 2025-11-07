/*Create a class “Vehicle” with a method “start()” that prints “Vehicle started”.
Create a subclass “Car” that extends “Vehicle” and overrides the “start()” method to print “Car started”.
Create an object of the “Vehicle” class and call the “start()” method.
Create an object of the “Car” class and call the “start()” method.*/


class Vehicle{
    void start(){
        System.out.println("Vehicle Started");
    }
}

class Car extends Vehicle{
    @Override
    void start(){
        System.out.println("Car started");
    }
}

public class VehicleTest{
    public static void main(String args[]){
        Vehicle v=new Vehicle();
        v.start();

        Car c=new Car();
        c.start();
    }
}
