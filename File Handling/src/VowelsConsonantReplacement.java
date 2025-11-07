/*Cindy is working on a text processing program, and she needs your help. The program is designed to replace all vowels in a given text with a specified consonant.

Create a file named file1.txt and prompt the user to input a text. Write the user's input into file1.txt. Then, read the content perform a specific logic (replacing vowels with a consonant provided by the user), and write the modified result into a new file named file2.txt. Lastly, display the modified result obtained from file2.txt.

Input format :
The first line of input consists of a string, representing the text that needs vowel replacement.

The second line is a single character value, representing the consonant to replace the vowels with.

Output format :
The output displays the string representing the modified text after replacing the vowels with the specified consonant.

Refer to the sample output for the formatting specifications.

Code constraints :
The given testcases fall under the following constraints:

The string contains lowercase and uppercase with at most 80 characters.

Sample test cases :
Input 1 :
Hello World
X
Output 1 :
HXllX WXrld
Input 2 :
Programming is fun
y
Output 2 :
Prygrymmyng ys fyn
Input 3 :
Apple
r
Output 3 :
rpplr*/



import java.util.*;
import java.io.*;

public class VowelsConsonantReplacement {
    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        /*-----------------------Creating File----------------------------------*/
        File file=new File("File1.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("Failed to create file.");
        }


        /*-------------------------Writing in File------------------------------*/
        System.out.println("Enter a text: ");
        String str=sc.nextLine();

        try {
            FileWriter writer = new FileWriter("File1.txt");
            writer.write(str);
            writer.close();

            System.out.println("File written successfully.");
        }catch(IOException e){
            System.out.println("Failed to write file.");
        }

        /*------------------------Reading and Replacing Vowels------------------------------------*/
        System.out.println("Enter the consonant to replace the vowels:");
        char ch=sc.next().charAt(0);

        File newFile=new File("File2.txt");

        try{
            if(newFile.createNewFile()){
                System.out.println("New file created successfully.");
            }else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("Failed to create file.");
        }

        FileReader reader=null;
        FileWriter newWriter=null;

        try{
            reader=new FileReader("File1.txt");
            newWriter=new FileWriter("File2.txt");

            int i;
            while((i=reader.read())!=-1){
                char orignalChar=(char)i;
                char charToWrite=orignalChar;

                if(isVowel(orignalChar))
                    charToWrite=ch;

                newWriter.write(charToWrite);
            }

        }catch(FileNotFoundException e){
            System.out.println("Failed to write file.");
        }catch(IOException e){
            System.out.println("Failed to read file.");
        }finally {
            try {
                if (reader != null) reader.close();
                if (newWriter != null) newWriter.close();
            }catch(IOException e){
                System.out.println("Failed to close file.");
            }
        }

        sc.close();
    }
}