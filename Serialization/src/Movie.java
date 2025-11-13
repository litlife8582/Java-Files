/*Alex runs a movie ticket booking system that allows users to book tickets for different movies. Alex needs to keep track of the tickets booked, including movie name, seat number, and price, and later check how many tickets are booked for a specific movie. Your task is to help Alex serialize the ticket data and provide a way to count the tickets for any given movie.

Help Alex implement this system to efficiently store and retrieve ticket data.

Input format :
The first line consists of an integer n, representing the number of tickets booked (1 ≤ n ≤ 100).

The next n lines contain the ticket details: each line contains an integer ticketId, a string movieName, a string seatNumber, and a double price.

The last line contains a string searchMovie, which is the movie name for which Alex wants to check the number of tickets booked.

Output format :
The output prints an integer representing the number of tickets booked for the specified movie.

If no tickets are booked for the movie, the output should be: "No tickets booked for this movie".*/


import java.io.*;
import java.util.*;

class Ticket implements Serializable{
    String id;
    String name;
    String seatnumber;
    double price;

    Ticket(String id,String name,String seatnumber,double price){
        this.id=id;
        this.name=name;
        this.seatnumber=seatnumber;
        this.price=price;
    }
}


public class Movie {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Ticket> serializedTicket=new ArrayList<>();
        System.out.println("Enter the number of tickets booked: ");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.println("Ticket ID: ");
            String id= sc.nextLine();
            System.out.println("Enter name of Movie: ");
            String name=sc.nextLine();
            System.out.println("Enter seat number: ");
            String seatnumber=sc.nextLine();
            System.out.println("Enter the price: ");
            double price=sc.nextDouble();
            sc.nextLine();
            serializedTicket.add(new Ticket(id,name,seatnumber,price));
        }

        //serialization
        try(FileOutputStream fout=new FileOutputStream("file.txt");
            ObjectOutputStream out=new ObjectOutputStream(fout)){
            out.writeObject(serializedTicket);
            out.close();
            fout.close();
            System.out.println("File successfully serialized");
        }catch (IOException e){
            System.out.println("File does not exist.");
        }

        //deserialization
        List<Ticket> deserializedTicket=new ArrayList<>();
        try(
            FileInputStream fin=new FileInputStream("file.txt");
            ObjectInputStream in=new ObjectInputStream(fin)){

            deserializedTicket=(List<Ticket>) in.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File does not exists.");
        }catch (IOException e){
            System.out.println("File not found.");
        }catch(ClassNotFoundException e){
            System.out.println("Class not found.");
        }



        System.out.println("Enter the name of the movie: ");
        String movieName=sc.nextLine();

        int count=0;
        for(Ticket ticket: deserializedTicket){
            if(ticket.name.equals(movieName)){
                count++;
            }
        }

        if(count>0){
            System.out.println(count);
        }else{
            System.out.println("Book not found.");
        }

        sc.close();
    }
}