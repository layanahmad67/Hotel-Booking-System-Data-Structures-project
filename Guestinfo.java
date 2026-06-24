/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Guestinfo {

    public static void main(String[] args) {
        DoubleLinkList<Guest> guestList = new DoubleLinkList<>();
        BinaryTree<Booking> booking = new BinaryTree<>();
        BinaryTree<Room> room = new BinaryTree<>();
        Scanner input = new Scanner(System.in);

        int choice = 0;
        do {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Guest");
                System.out.println("2. Find Guest");
                System.out.println("3. Remove Guest");
                System.out.println("4. Print All Guests");
                System.out.println("5. search Booking");
                System.out.println("6. cancel Booking");
                System.out.println("7. Exit");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Guest ID: ");
                        int guestID = input.nextInt();
                        input.nextLine();
                        System.out.print("Enter Guest Name: ");
                        String guestName = input.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = input.nextLine();

                        Guest guest = new Guest(guestID, guestName, phoneNumber);
                        guestList.addGuest(guest);
                        System.out.println("Guest added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Guest ID to find: ");
                        int findID = input.nextInt();
                        Guest foundGuest = guestList.findGuest(findID);
                        if (foundGuest != null) {
                            foundGuest.displayGuest();
                        } else {
                            System.out.println("Guest not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Guest ID to remove: ");
                        int removeID = input.nextInt();
                        guestList.removeGuest(removeID);
                        break;

                    case 4:
                        guestList.printAllGuests();
                        break;

                    case 5:
                        System.out.print("Enter Booking number to serch: ");
                        int num = input.nextInt();
                        booking.searchByBookingNum(num);
                        break;

                    case 6:
                        System.out.print("Enter Booking number to cancel Booking: ");
                        int n = input.nextInt();
                        booking.cancelBooking(n);
                        break;

                    case 7:
                        System.out.println("Exiting program.");
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                input.next();
            }
        } while (choice != 7);

        // full list
        Guest g1 = new Guest(111, "layan", "121212");
        Guest g2 = new Guest(222, "shahad", "343434");
        Guest g3 = new Guest(333, "ghaleh", "565656");
        Guest g4 = new Guest(444, "lujain", "787878");
        Guest g5 = new Guest(555, "raghad", "909090");
        guestList.addLast(g1);
        guestList.addLast(g2);
        guestList.addLast(g3);
        guestList.addLast(g4);
        guestList.addLast(g5);

        Room r1 = new Room("double", 111);
        Room r2 = new Room("individual", 222);
        room.addRoot(r1);
        room.addLeft(r2, r1);

        Booking b1 = new Booking(r1, g1, 4);
        Booking b2 = new Booking(r2, g2, 3);
        booking.addRoot(b1);
        booking.addLeft(b2, b1);
    }

}
