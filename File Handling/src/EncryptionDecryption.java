/*

Problem Statement

Alice is concerned about the security of her confidential messages and wants to implement a simple encryption and decryption program.

Implement a simple encryption algorithm that increments the ASCII value of each character in the message. Implement a corresponding decryption algorithm that decrements the ASCII value of each character.

Create a program that takes user input for a confidential message, encrypts the message using a basic encryption algorithm, writes the encrypted message to a file named encrypted_data.txt, and then reads the encrypted data from the file to decrypt it. The decrypted message is then displayed to ensure the correctness of the encryption and decryption process.

Assist Alice in this task.

Input format :
The input consists of a string, representing a confidential message entered by the user.

Output format :
The first line of output displays "Encrypted Message: " followed by a string representing the encrypted message after applying the encryption algorithm.

The second line of output displays "Decrypted Message: " followed by a string representing the decrypted message after reading the encrypted data from the file and applying the decryption algorithm.

Refer to the sample output for formatting specifications.

Code constraints :
The given testcases fall under the following constraints:

The string contains lowercase, uppercase and numbers with at most 50 characters.

Sample test cases :
Input 1 :
Hello
Output 1 :
Encrypted Message: Ifmmp
Decrypted Message: Hello

Input 2 :
12345
Output 2 :
Encrypted Message: 23456
Decrypted Message: 12345
---------------------------------------------------------------------------------------------------------*/



import java.util.*;
import java.io.*;

public class EncryptionDecryption {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        /*---------------------Creating encrypted_data.txt and decrypted_data.txt file-------------------*/
        File inputFile=new File("encrypted_data.txt");
        File outputFile=new File("decrypted_data.txt");

        try{
            if(inputFile.createNewFile()){
                System.out.println("Encryption file created.");
            }else{
                System.out.println("Encryption file already present.");
            }
            if(outputFile.createNewFile()){
                System.out.println("Decryption file created.");
            }else{
                System.out.println("Decryption file already present.");
            }
        }catch(IOException e){
            System.out.println("Failed to create encryption file.");
        }

        /*-----------------------------------Encrypting the text-----------------------------------------*/
        System.out.println("Enter the text:");
        String text=sc.nextLine();

        String encrypted_txt="";
        for(int i=0;i<text.length();i++){
            char org=text.charAt(i);
            char enc=(char)(org+1);
            encrypted_txt+=enc;
        }
        System.out.println("Encrypted text - "+encrypted_txt);

        /*-----------------------------Writing the encrypted_data file------------------------------------*/
        try{
            FileWriter writer=new FileWriter("encrypted_data.txt");
            writer.write(encrypted_txt);
            writer.close();
        }catch(IOException e){
            System.out.println("Failed to write encrypted text.");
        }

        /*--------------------Reading and decrypting the encrypted_data.txt and writing the decrypted_data.txt file--------------------------*/
        String decrypted_txt="";
        FileReader reader=null;
        FileWriter newWriter=null;
        try{
            reader=new FileReader("encrypted_data.txt");
            newWriter=new FileWriter("decrypted_data.txt");

            int i;
            while((i= reader.read())!=-1){
                char orgChar=(char)i;
                char decr=(char)(orgChar-1);
                decrypted_txt+=decr;
            }
            System.out.println("Decrypted text - "+decrypted_txt);
            newWriter.write(decrypted_txt);

        }catch (FileNotFoundException e){
            System.out.println("Encrypted File not found.");
        }catch(IOException e){
            System.out.println("Decrypted File could not be written.");
        }finally{
            try {
                if (reader != null) {
                    reader.close();
                }
                if (newWriter != null) {
                    newWriter.close();
                }
            }catch(IOException e){
                System.out.println("Failed to close file.");
            }
        }
        sc.close();
    }
}
