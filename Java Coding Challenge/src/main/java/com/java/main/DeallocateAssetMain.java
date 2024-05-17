package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;

public class DeallocateAssetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to deallocate:");
        int assetId = scanner.nextInt();

        try {
            if (assetService.checkAssetExists(assetId)) {
                System.out.println("Enter employee ID:");
                int employeeId = scanner.nextInt();
                System.out.println("Enter return date:");
                String returnDate = scanner.next();
                boolean deallocated = assetService.deallocateAsset(assetId, employeeId, returnDate);
                if (deallocated) {
                    System.out.println("Asset deallocated successfully");
                } 
            } else {
                throw new AssetNotFoundException("Deallocate function cannot be performed... ");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } catch (AssetNotFoundException e) {
            System.out.println("Asset not found "+e.getMessage());
        } 
    }
}
