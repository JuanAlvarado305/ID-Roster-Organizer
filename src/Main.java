
/*
  Program written by: Juan Alvarado
  Purpose:  Program for storing the personal information of students and teachers including their name, id and phone numbers.
            The program will output the data to a .csv file. Each entry consists of the first name and last name written together,
            separated by a comma and followed by a whitespace. This is then followed by either a 5 digit student or teacher ID number, a zero
            for the latter, and finally a 10-digit phone number.
 */

// import all the necessary packages that we will need for this program
import java.io.*;import java.util.ArrayList;import java.util.List;import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create an arraylist
        List<CSVPrintable> individuals = new ArrayList<>();

        /* This part will pick out the integer inputted by the user as a String and parse it to an
        actual integer, so we can use it for the amount of times the for-loop initiates. */
        System.out.println("Enter the number of individuals:");
        int n = Integer.parseInt(scanner.nextLine());

        //Once the User inputs the amount of people, it will loop n amount of times.
        for (int i = 0; i < n; i++) {
            //Within the same for-loop you ask the user
            System.out.println("Please enter information in this format: Position Name StudentID# TeacherID# Phone#");
            String input = scanner.nextLine();
            //Split the string input everytime a whitespace is encountered by the compiler
            //Store those strings into 5 separate array elements and assign them to an appropriate variable
            //That is why the user uses a comma instead of a space to separate their
            //first and last name instead, so that "input.split" doesn't store the first & last
            //names into separate elements of the array.
            String[] parts = input.split(" ");
            // In this case the delimiter that triggers the split is a whitespace contained between two double quotations

            //If the length of the input isn't 5 separate elements, then tell the user to retype input
            if (parts.length != 5) {
                System.out.println("Incorrect input format. Please re-enter.");
                i--;
                continue;
            }
                            //String Position Array//
               //  [0]      [1]      [2]          [3]        [4]
              //    1        2        3            4          5     <-------------Five array elements
             // Position | Name | StudentID# | TeacherID# | Phone#
            //        split   split        split        split
            String position = parts[0];
            String name = parts[1];
            int studentID = Integer.parseInt(parts[2]);
            int teacherID = Integer.parseInt(parts[3]);
            long phone = Long.parseLong(parts[4]);

            String studentIDString = String.valueOf(studentID);
            String teacherIDString = String.valueOf(teacherID);
            String phoneString = String.valueOf(phone);

            //Exception handling portion of code, try block
            try {
                switch (position.toLowerCase()) {
                    case "student":
                        // check student input: make sure teacher ID is 0 and student ID is 5 digits and phone number is 10
                        if (teacherID != 0 || studentIDString.length() !=5 || phoneString.length() !=10) throw new IllegalArgumentException("Invalid Input for student. Teacher ID must be 0 and Student ID must be 5 digits in length. Phone # must be 10 digits in length.");
                        individuals.add(new Student(name, studentID, phone));
                        break;
                    case "teacher":
                        // check teacher input: make sure student is 0 and teacher is 5 digits and phone number is 10
                        if (studentID != 0 || teacherIDString.length() != 5 || phoneString.length() !=10) throw new IllegalArgumentException("Invalid Input for teacher. Student ID must be 0 and Teacher ID must be 5 digits in length. Phone # must be 10 digits in length.");
                        individuals.add(new Teacher(name, teacherID, (int) phone));
                        break;
                    case "ta":
                        //if user inputs a zero value for either student or teacher, throw an exception
                        if (studentID == 0 || teacherID == 0)
                            throw new IllegalArgumentException("Both IDs must be non-zero for TA.");
                        individuals.add(new TA(name, studentID, teacherID, phone));
                        break;
                    default:
                        //If user inputs anything else besides Teacher or student for position, throw an exception
                        throw new IllegalArgumentException("Unknown position: " + position);
                }
                //catch all IllegalArgumentExceptions thrown by the try block above
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                i--;
            }
            //Exception handling when writing to .csv file
            try (PrintWriter out = new PrintWriter(new FileWriter("out.csv"))) {
                for (CSVPrintable individual : individuals) {
                    individual.csvPrintln(out);
                }
                //catch io exception
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }

}

/* Sample Code Block:
-----------------------
Enter the number of individuals:
2
Please enter information in this format: Position Name StudentID# TeacherID# Phone#
student john,doe 12345 0 3051111111
Please enter information in this format: Position Name StudentID# TeacherID# Phone#
teacher alex,smith 0 11121 7861111111

Process finished with exit code 0
 */



















