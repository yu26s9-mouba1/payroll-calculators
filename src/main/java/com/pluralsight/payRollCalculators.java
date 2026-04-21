package com.pluralsight;
import java.awt.*;
import java.io.*;
import java.util.Scanner;




public class payRollCalculators {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Prompting the user for the file they would like to read
        System.out.println("Enter the name of the file to read and process:");
        String fileName = scanner.nextLine();


        System.out.println("Enter the name of the payroll file to create:");
        String payrollFile = scanner.nextLine();




        //Creating the buffer reader alongside with that will scan the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
            reader.readLine(); //Ensuruing the header is skipped in the file

            //File writer
            FileWriter fw = new FileWriter("employees-payroll.csv");
            fw.write("id|name|grossPay\n");

            String input;


            //Using a while loop to read the line by line
            while ((input = reader.readLine()) != null) {

                // splitting each line using |
                String[] lineSplit = input.split("\\|");

                int employeeId = Integer.parseInt(lineSplit[0]);
                String name = lineSplit[1];
                double hoursWorked = Double.parseDouble(lineSplit[2]);
                double payRate = Double.parseDouble(lineSplit[3]);

                //Creating the employee object
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                //Displaying the result
                //System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                //Setting the header to display the output
                String formattedLine = String.format("%d|%s|$%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                fw.write(formattedLine);


            }


            fw.close();
            reader.close();
            scanner.close();

            System.out.println("Payroll file created successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file");
        }


    }


}

