/*Anu is developing a program that represents a book and ensures the validity of its attributes upon creation. The program should handle exceptions for invalid book details and provide informative error messages.



Implement a Book class with the following attributes: title (String), author (String), publicationYear (int).
Create a constructor for the Book class that initializes the book's attributes (title, author, publication year).
Implement private validation methods (validateTitle, validateAuthor, validatePublicationYear) to ensure that the title is not empty, the author is not empty, and the publication year is a positive integer.
Throw IllegalArgumentException with appropriate error messages if validation fails.
Implement a method addBook in the Book class that prints "Book added successfully" to the console.


Help Anu to design the program.

Input format :
The first line of input consists of a string, representing the title of the book.

The second line consists of a string, representing the author of the book.

The third line consists of an integer, representing the publication year of the book.

Output format :
If the book is added, print "Book added successfully"

If the title is an empty string, print "Invalid title: Title should not be empty"

If the author is an empty string, print "Invalid author: Author should not be empty"

If the publication year is not a positive integer, print "Invalid publication year: Publication year should be a positive integer". */

import java.util.*;

class Book {
    String title;
    String author;
    int year;

    private void validateTitle(String title){
        if(title==null){
            throw new IllegalArgumentException("Invalid Title: Title should not be empty");
        }
    }

    private void validateAuthor(String author){
        if(author==null){
            throw new IllegalArgumentException("Invalid Author: Author should not be empty");
        }
    }

    private void validatePublicationYear(int year){
        if(year<0){
            throw new IllegalArgumentException("Invalid Year: Year should not be negative");
        }
    }

    Book(String title,String author, int year){
        validateTitle(title);
        validateAuthor(author);
        validatePublicationYear(year);
        this.title=title;
        this.author=author;
        this.year=year;
    }

    public void addBook(){
        System.out.println("Book successfully added");
    }
   
}

class Book_main{
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
            String title=sc.nextLine();
            String author=sc.nextLine();
            int year=sc.nextInt();

            Book book=new Book(title,author,year);
            book.addBook();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
            sc.close();
        }
    }
}
