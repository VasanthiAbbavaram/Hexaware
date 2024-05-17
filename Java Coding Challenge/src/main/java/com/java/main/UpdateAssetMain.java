package com.java.AssetManagement.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.model.Assets;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;

public class UpdateAssetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset details to update:");
        System.out.print("Asset ID: ");
        int assetId = scanner.nextInt();
        scanner.nextLine();
        
        try {
        	if (assetService.checkAssetExists(assetId)) {
        		System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Type: ");
                String type = scanner.nextLine();
                System.out.print("Serial Number: ");
                int serialNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Purchase Date:");
                String purchaseDate = scanner.nextLine();
                System.out.print("Location: ");
                String location = scanner.nextLine();
                System.out.print("Status: ");
                String status = scanner.nextLine();
                System.out.print("Owner ID: ");
                int ownerId = scanner.nextInt();
                Assets asset = new Assets(assetId, name, type, serialNumber, Date.valueOf(purchaseDate), location, status, ownerId);
                boolean updated = assetService.updateAsset(asset);
            if (updated) {
                System.out.println("Asset updated successfully.");
            }
          }
            else {
            	throw new AssetNotFoundException("Update function cannot be performed...");
            }
          
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        catch (SQLException e) {
            System.out.println("Error executing SQL query");
        }
        catch (AssetNotFoundException e) {
        	System.out.println("Asset is not Found. "+e.getMessage());
        }
       
    }
}


