/* Author name: Chanthuki Kavinihara Fernando
IIT Id: 20221122
UoW Id:W1953817
Date:6th March 2023
SD II Programming Coursework
 */

import java.io.*;
import java.util.Arrays;      //import  packages
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


// Task1
public class Theatre {                 //main class
    static Scanner input = new Scanner(System.in);                     //To get input
    static  ArrayList<Ticket>list = new ArrayList<>();                // for creating the ArrayList
    static Ticket tickets;
    //Task 01
    public static void main(String[] args) {                        //main method
        try{                                                        //for block of code to be tested for errors while it is being executed.

            String[] Row_1_Seats = new String[12]; //array1
            String[] Row_2_Seats = new String[16]; //array2
            String[] Row_3_Seats = new String[20]; //array3

            System.out.println();
            System.out.println("*********** Welcome to the New Theatre!!! ***********");
            System.out.println();


//----------------------------------------------------------------------------------------------

            Arrays.fill(Row_1_Seats,"0");

            Arrays.fill(Row_2_Seats,"0");

            Arrays.fill(Row_3_Seats,"0");


// Task2
//-----------------------------------------------------------------------------------------------------

            System.out.println("\n");
            System.out.print("................................................................................................"); //Menu Bar
            System.out.println("\n");

            String option;
            do {
                System.out.println("Please select an option:");             //Menu
                System.out.println();

                System.out.println("1). Buy a ticket ");
                System.out.println("2). print seating area ");
                System.out.println("3). Cancel ticket ");
                System.out.println("4). List available seats ");
                System.out.println("5). Save to file ");
                System.out.println("6). Load from file ");
                System.out.println("7). Print ticket information and total price ");
                System.out.println("8). Sort ticket by price ");
                System.out.println("0). Quit ");

                System.out.println();
                System.out.println("..................................................................................");
                System.out.println("\n");

                System.out.println("Enter option:");

                option = input.next();

                switch (option) {                                         //switch block has case statement and values must be of the same type of expression.
                    case "1":
                        buy_ticket(Row_1_Seats, Row_2_Seats, Row_3_Seats);
                        break;
                    case "2":
                        print_seating_area(Row_1_Seats, Row_2_Seats, Row_3_Seats);
                        break;
                    case "3":
                        cancel_ticket(Row_1_Seats, Row_2_Seats, Row_3_Seats);
                    case "4":
                        list_available_seats(Row_1_Seats, Row_2_Seats, Row_3_Seats);
                        break;
                    case "5":
                        save_files(Row_1_Seats, Row_2_Seats, Row_3_Seats);
                        break;
                    case "6":
                        load_from_file();
                        break;
                    case "7":
                        show_ticket_information();
                        break;
                    case "8":
                        sort_ticket();
                        break;
                    case "0":
                        System.out.print("Good Bye!!!");
                        break;
                    default:
                        System.out.print("Invalid option, Please try again!!!");
                        break;
                }

            } while (!option.equals("0"));                              //To check option equals 0 or not
        }catch (Exception e){                                           //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

    //Task 3
    public static void buy_ticket(String[] row_1, String[] row_2, String[] row_3) {

        try{                                                            //for block of code to be tested for errors while it is being executed.
            System.out.print("\n----For Buy Tickets----");
            System.out.println();
            char Ticket;

            do {
                int row_no;
                int seat_no;
                double price;

                System.out.print("\nEnter name: ");
                String name = input.next();
                System.out.print("\nEnter surname: ");
                String surname = input.next();
                System.out.print("\nEnter Email: ");
                String email = input.next();
                System.out.print("\nEnter a ticket price:");
                price = input.nextDouble();

                Person person = new Person(name, surname, email);

                do{
                    System.out.println();
                    System.out.print("\n Enter a row no:");
                    row_no = input.nextInt();
                    if (row_no <= 3) {                      // To Check row_no <= 3
                        System.out.println("Valid row_no.");
                    } else {
                        System.out.print("Invalid row_no\nPlease enter a valid Row number");
                    }
                }while(row_no > 3 || row_no <= 0);
                while (true) {
                    System.out.print("\n Enter a seat_no:");
                    seat_no = input.nextInt();

                    if (row_no == 1 && seat_no < 13 && seat_no > 0) {            //To check row_no equals to 1 and seat_no less than 13 and greater than 0
                        System.out.println("valid seat_no \n");
                        tickets = new Ticket(row_no, seat_no, price, person);     //In Task 13: To add information to the  ticket information list
                        if ("1".equals(row_1[seat_no - 1])) {                     // To check seat booked or not
                            System.out.println("\nThis seat has been taken");
                        } else if ("0".equals(row_1[seat_no - 1])) {
                            row_1[seat_no - 1] = "1";
                            list.add(tickets);                                     //add an elements using add method
                            break;
                        }
                    } else if (row_no == 2 && seat_no < 17 && seat_no > 0) {           //To check row_no equals to 2 and seat_no less than 17 and greater than 0
                        tickets = new Ticket(row_no, seat_no, price, person);          // In Task 13: To add information to the  ticket information list
                        System.out.println("valid seat_no \n");
                        if ("1".equals(row_2[seat_no - 1])) {
                            System.out.println("\nThis seat has been taken");
                        } else if ("0".equals(row_2[seat_no - 1])) {
                            row_2[seat_no - 1] = "1";
                            list.add(tickets);                                          //add an elements using add method
                            break;
                        }
                    } else if (row_no == 3 && seat_no < 21 && seat_no > 0) {            //To check row_no equals to 3 and seat_no less than 21 and greater than 0
                        tickets = new Ticket(row_no, seat_no, price, person);            //In Task 13: To add information to the  ticket information list
                        System.out.println("valid seat_no \n");
                        if ("1".equals(row_3[seat_no - 1])) {
                            System.out.println("\nThis seat has been taken");
                        } else if ("0".equals(row_3[seat_no - 1])) {
                            row_3[seat_no - 1] = "1";
                            list.add(tickets);                                         //add an elements using add method
                            break;
                        }
                    } else {
                        System.out.println("Invalid seat_no\n");
                        System.out.println("\nPlease enter valid seat number");
                    }
                }
                System.out.println("\n------------- Purchased Completed!!!!---------------");
                System.out.print("\nYou have successfully purchased Seat number" + ""+ seat_no + "in Row" +""+ row_no);
                System.out.print("\nIf you want another ticket enter 'y' for yes otherwise enter 'n': ");

                Ticket = input.next().charAt(0);

            } while((Ticket == 'y') || (Ticket == 'Y'));                            //use this for both capital and simple letter
            System.out.println("\nThank you for buy tickets!!!!------");
            System.out.println("\n-----------------------------------------------------------");

        }catch (Exception e) {
            System.out.println("Something went wrong.");                            //if an error occurs in the try block allows to define a block of code to be executed
        }
    }

    //Task4
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3) {
        try{
            System.out.println("\n For Print Seating area!!!---");
            System.out.println();
//Stage pattern
            System.out.println();
            System.out.println("  ******************");
            System.out.println("  *     STAGE      *");
            System.out.println("  ******************");

//----------------------------------Row1-------------------------------------------------------------------
            System.out.print("    ");
            for (int i = 0; i < row_1.length / 2; i++) {                //for Row_1 first 6 seats
                if ("0".equals(row_1[i])) {
                    System.out.print("0");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print(" ");
            for (int i = row_1.length / 2; i < row_1.length; i++) {        //for Row_1 second 6 seats
                if ("0".equals(row_1[i])) {
                    System.out.print("0");
                } else if ("1".equals(row_1[i])) {
                    System.out.print("X");
                }
            }
            System.out.println();

//---------------------------------Row 2------------------------------------------------------------------------

            System.out.print("  ");
            for (int i = 0; i < row_2.length / 2; i++) {                //Row_2 first 8 seats
                if ("0".equals(row_2[i])) {
                    System.out.print("0");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print(" ");
            for (int i = row_2.length / 2; i < row_2.length; i++) {                //Row_2 second 8 seats
                if ("0".equals(row_2[i])) {
                    System.out.print("0");
                } else if ("1".equals(row_2[i])) {
                    System.out.print("X");
                }
            }
            System.out.println();

//-----------------------------Row 3----------------------------------------------------

            for (int i = 0; i < row_3.length / 2; i++) {                       //Row_3 first 10 seats
                if ("0".equals(row_3[i])) {
                    System.out.print("0");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print(" ");
            for (int i = row_3.length / 2; i < row_3.length; i++) {                // Row_3 second 10 seats
                if ("0".equals(row_3[i])) {
                    System.out.print("0");
                } else if ("1".equals(row_3[i])) {
                    System.out.print("X");
                }
            }
            System.out.println();
            System.out.println("\n");
            System.out.println("--------------------------------------------------------------------------");
        }catch (Exception e) {                                                 //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

    //Task 5

    public static void cancel_ticket(String[] row_1, String[] row_2, String[] row_3) {

        try{                                                       //for block of code to be tested for errors while it is being executed.
            System.out.print("\nFor Cancel ticket!!----");
            System.out.println();
            char Ticket;
            do {
                int row_no;
                int seat_no;
                boolean x = true;
                do{
                    System.out.print("\n Enter a row no:");
                    row_no = input.nextInt();
                    if (row_no <= 3 && row_no > 0) {                      //To check row_no less than or equals to 3
                        System.out.println("Valid Row number");
                        x = false;
                    } else {
                        System.out.print("Please enter valid row number");
                    }
                } while (x);
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.print("\n Enter a seat_no:");          //If row_no is valid, get a seat_no
                    seat_no = input.nextInt();
                    if (row_no == 1 && (seat_no < 13 && seat_no > 0)) {           //To check whether in row no 1, seat_no less than 13 or more than 0,the ticket which is to  be cancelled
                        System.out.println("Valid seat number");
                        if ("0".equals(row_1[seat_no - 1])) {
                            System.out.println("\nThis seat is not booked");
                            break;
                        } else if ("1".equals(row_1[seat_no - 1])) {
                            row_1[seat_no - 1] = "0";
                            for (int i = 0; i < list.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also(task 13 & task 14)
                                if (list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no) {
                                    list.remove(list.get(i));                                                 //remove an element
                                    break;
                                }
                            }
                            System.out.print("This seat has been cancelled");
                            break;
                        }
                    } else if (row_no == 2 && (seat_no < 17 && seat_no > 0)) {       //check whether the ticket to be canceled is in row number 2, 0 <= seat number < 17
                        System.out.println("Valid seat number");
                        if ("0".equals(row_2[seat_no - 1])) {
                            System.out.println("This seat has been canceled");
                            break;
                        } else if ("1".equals(row_2[seat_no - 1])) {
                            row_2[seat_no - 1] = "0";
                            for (int i = 0; i < list.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also
                                if (list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no) {
                                    list.remove(list.get(i));                                                  //remove an element
                                    break;
                                }
                            }
                            System.out.println("\ncanceled");
                            break;
                        }
                    } else if (row_no == 3 && (seat_no < 21 && seat_no > 0)) {                  // check whether the ticket to be canceled is in row number 3, 0 <= seat number < 21
                        if ("0".equals(row_3[seat_no - 1])) {
                            System.out.println("This seat has been canceled");
                            break;
                        } else if ("1".equals(row_3[seat_no - 1])) {
                            row_3[seat_no - 1] = "0";
                            for (int i = 0; i < list.size(); i++) {                                           //cancel tickets information from sort tickets and show ticket info part also
                                if (list.get(i).getRow() == row_no && list.get(i).getSeat() == seat_no) {
                                    list.remove(list.get(i));                                                   //remove element by remove method
                                    break;
                                }
                            }
                            System.out.println("\ncanceled");
                            break;
                        }
                    }else {
                        System.out.println("Invalid Seat number");
                    }
                }
                System.out.println("----------------Successfully cancelled------------------------------");
                System.out.println("\nYou have successfully cancelled seat "+ seat_no + "in Row" + row_no );
                System.out.print("\nIf you want to cancel another ticket enter 'y' for yes otherwise enter 'n':");  //for continue cancel tickets

                Ticket = input.next().charAt(0);
            } while((Ticket == 'y') || (Ticket == 'Y'));
            System.out.println("\nThank you for buy tickets!!!");
            System.out.println(" ");
            System.out.println("\n------------------------------------------------------------------------");
        }catch (Exception e) {                                                         //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

    //Task 6
    public static void list_available_seats(String[] row_1, String[] row_2, String[] row_3) {
        try{                                                                       //for block of code to be tested for errors while it is being executed.
            int seat_no;
            System.out.print("\nFor List available seats!!----");
            System.out.print("\n");
            System.out.print("\nSeats available in row_1: ");
            for (seat_no = 1; seat_no <= 12; seat_no++) {
                if ("0".equals(row_1[seat_no - 1])) {
                    System.out.print(seat_no + " ");
                }
            }
            System.out.print("\n");
            System.out.print("\nSeats available in row_2: ");
            for (seat_no = 1; seat_no <= 16; seat_no++) {
                if ("0".equals(row_2[seat_no - 1])) {
                    System.out.print(seat_no + " ");
                }
            }
            System.out.print("\n");
            System.out.print("\nSeats available in row_3: ");
            for (seat_no = 1; seat_no <= 20; seat_no++) {
                if ("0".equals(row_3[seat_no - 1])) {
                    System.out.print(seat_no + " ");
                }
            }
            System.out.println("\n");
            System.out.println();
            System.out.println("\n------------------------------------------------------------------------------");
        }catch (Exception e) {                                                                                          //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

    //Task 07
    public static void save_files(String[] row_1, String[] row_2, String[] row_3) {
        try{                                                                             //for block of code to be tested for errors while it is being executed.
            System.out.print("\n------------This is for the save to file!!!----------\n");
            try {
                FileWriter fileWrite = new FileWriter("arr.txt");     //File name

                fileWrite.write("\nrow 1" + " " + "seats = 12 " + " \t\t\tnow available seats ");
                fileWrite.write(Arrays.toString(row_1));

                fileWrite.write("\nrow 2" + " " + "seats = 16 " + " \t\t\tnow available seats ");
                fileWrite.write(Arrays.toString(row_2));

                fileWrite.write("\nrow 2" + " " + "seats = 16 " + " \t\t\tnow available seats ");
                fileWrite.write(Arrays.toString(row_3));

                fileWrite.close();                                               //always close file connection
                System.out.println("\nSuccessfully wrote to the file.( arr.text )");
            } catch (IOException ex) {
                System.err.println("The file wasn't found");
            }
            System.out.println();
            System.out.println("\n------------------------------------------------------");
        }catch (Exception e) {                                                       //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

    //Task 08
    public static void load_from_file() {
        try{                                                                        //for block of code to be tested for errors while it is being executed.
            System.out.print("\nThis is for the load from file!----------------------\n");
            System.out.print("\n                   Available Seats......\n");
            try {
                File myObj = new File("arr.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {                                   //if an error occurs in the try block allows to define a block of code to be executed
                System.out.println("An error occurred");
                e.printStackTrace();
                System.out.print("\n");
            }
            System.out.print("\n");
            System.out.println();
            System.out.println("\n-------------------------------------------------------------------------");
        }catch (Exception e) {                                                         //if an error occurs in the try block allows to define a block of code to be executed
            System.out.println("Something went wrong.");
        }
    }

//Task 11 Person.java (new class)
//Task 12 Ticket.java (new class)
    //-------------------------------------------------------------------------------------------------------------
//Task 13

    public static void show_ticket_information() {
        System.out.print("\n----For print ticket information!!---");
        double total = 0;
        for (Ticket value : list) {
            total += value.getPrice();
            value.print();
            System.out.println("\n");
        }
        System.out.println("\ntotal:" + total); // print total price
        System.out.println();
        System.out.println("\n-------------------------------------------------------------------");
    }

    //Task 14
    public static void sort_ticket(){
        System.out.print("This is for sort ticket information!!-------------------");
        int len = list.size();
        Ticket sort;

        for(int i = 0; i<len-1; i++){                                           //outer loop
            for(int j =0; j<len-i-1; j++){                                      //inner nested loop point 1 index
                if(list.get(j).getPrice() > list.get(j+1).getPrice()){    //checking elements
                    sort = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,sort);
                }
            }
        }
        System.out.println("\n");
        System.out.println("Sorted prices:");
        for (Ticket value : list)
            value.print();                                         // To print sorted array elements
        System.out.println();
        System.out.println("\n------------------------------------------------------------------------------------------"); //sort ticket info border
    }
}

