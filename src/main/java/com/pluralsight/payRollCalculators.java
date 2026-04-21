package com.pluralsight;
import java.io.*;



public class payRollCalculators {
    public static void main(String[] args) {


        //Creating the buffer reader alongside withthat will scan the file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));

            reader.readLine(); //Ensuruing the header is skipped in the file

            String input ; //The variable that will hold each line

            //Using a while loop to read the line by line
            while ((input = reader.readLine()) != null){

                // splitting each line using |
                String[] lineSplit = input.split("\\|");

                int employeeId = Integer.parseInt(lineSplit[0]);
                String name = lineSplit[1];
                double hoursWorked = Double.parseDouble(lineSplit[2]);
                double payRate = Double.parseDouble(lineSplit[3]);

                //Creating the employee object
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                //Displaying the result
                System.out.printf("ID: %d | Name: %s | Gross Pay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

                reader.close();  //closing the buffer reader



            }

        }catch (IOException e){
            System.out.println("Error reading file");

        }


    }














    }

