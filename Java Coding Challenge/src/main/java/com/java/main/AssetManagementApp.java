package com.java.AssetManagement.main;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AssetManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Asset Management App");

        boolean exit = false;
        while (!exit) {
        	
            
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Asset");
            System.out.println("2. Update Asset");
            System.out.println("3. Delete Asset");
            System.out.println("4. Allocate Asset");
            System.out.println("5. Deallocate Asset");
            System.out.println("6. Perform Maintenance");
            System.out.println("7. Reserve Asset");
            System.out.println("8. Withdraw Reservation");
            System.out.println("9. Exit");
           
            System.out.print("Enter your choice: ");
            
            try {
            	
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        AddAssetMain.main(args);
                        break;
                    case 2:
                        UpdateAssetMain.main(args);
                        break;
                    case 3:
                        DeleteAssetMain.main(args);
                        break;
                    case 4:
                        AllocateAssetMain.main(args);
                        break;
                    case 5:
                        DeallocateAssetMain.main(args);
                        break;
                    case 6:
                        PerformMaintenanceMain.main(args);
                        break;
                    case 7:
                        ReserveAssetMain.main(args);
                        break;
                    case 8:
                        WithdrawReservationMain.main(args);
                        break;
                    case 9:
                        exit = true;
                        System.out.println("Exiting Asset Management App... Thank You!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
            
        }

        scanner.close();
    }
}
