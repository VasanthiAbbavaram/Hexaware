package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;

public class PerformMaintenanceMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Perform Maintenance:");
        System.out.println("Enter asset ID:");
        int assetId = scanner.nextInt();
        scanner.nextLine();
        try {
        if(assetService.checkAssetExists(assetId)) {
        System.out.println("Enter maintenance date :");
        String maintenanceDate = scanner.nextLine().trim();
        
        System.out.println("Enter maintenance description:");
        String description = scanner.nextLine().trim();
        
        System.out.println("Enter maintenance cost:");
        double cost = scanner.nextDouble();
        scanner.nextLine();
            boolean maintenancePerformed = assetService.performMaintenance(assetId, maintenanceDate, description, cost);
            if (maintenancePerformed) {
                System.out.println("Maintenance recorded successfully.");
            } else {
                System.out.println("Failed to record maintenance.");
            }
        }
        else {
        	 throw new AssetNotFoundException("Maintenance function cannot be performed... "); 
        }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error performing maintenance: " + e.getMessage());
        }
        catch (AssetNotFoundException e) {
        	System.out.println("Asset is not Found. "+e.getMessage());
        }
        
    }
}
