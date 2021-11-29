package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
// dont have a global scanner
public class Main {
    private static File bookInfo = new File("BookInfo.txt");
    private static Scanner input = new Scanner(System.in);
    private static String[] bookInformation = new String[4];

    public static void main(String[] args) {

        CreateFile();

        WriteToFile();

        ReadFile();


    }

    public static void CreateFile() {
        try {
            if (bookInfo.createNewFile()) {
                System.out.println("File created: " + bookInfo.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter(bookInfo.getName(), true); //True means append to file contents, False means overwrite
            addBookInfo();
            System.out.println("This is the contents of the file:");

            myWriter.write(Arrays.toString(bookInformation)); // Overwrites everything in the file
            myWriter.close();
            bookInformation = null;
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void addBookInfo() {
        System.out.println("How many books do you want to store the information of?");
        int numOfBooks = input.nextInt();
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println("Please type in your books title!");
            String usersBookTitle = input.next();
            usersBookTitle = bookInformation[0];
            System.out.println("Please type in your books ISBN!");
            int usersBookISBN = input.nextInt();
            usersBookTitle = bookInformation[1];
            System.out.println("Please type in your books Author!");
            String usersBookAuthor = input.next();
            usersBookTitle = bookInformation[2];
            System.out.println("Please type in your books Genre!");
            String usersBookGenre = input.next();
            usersBookTitle = bookInformation[3];


        }
    }
        public static void ReadFile() {
            try {
                Scanner myReader = new Scanner(bookInfo);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

