package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;
import com.java.AssetManagement.myexceptions.AssetNotMaintainException;

public class ReserveAssetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to reserve:");
        int assetId = scanner.nextInt();

        try {
            if (assetService.checkAssetExists(assetId)) {
            	if (!assetService.checkAssetMaintenance(assetId)) {
                    throw new AssetNotMaintainException("Asset with ID " + assetId + " requires maintenance but has not been maintained for two years.");
                }
                System.out.println("Enter employee ID to reserve:");
                int employeeId = scanner.nextInt();
                scanner.nextLine(); 
                
                System.out.println("Enter reservation date:");
                String reservationDate = scanner.nextLine().trim();

                System.out.println("Enter start date :");
                String startDate = scanner.nextLine().trim();

                System.out.println("Enter end date :");
                String endDate = scanner.nextLine().trim();

                boolean reserved = assetService.reserveAsset(assetId, employeeId, reservationDate, startDate, endDate);
                if (reserved) {
                    System.out.println("Asset reserved successfully");
                } else {
                    System.out.println("Failed to reserve asset");
                }
            } else {
            	throw new AssetNotFoundException("Reserve function cannot be performed... ");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        } 
        catch (AssetNotFoundException e) {
            System.out.println("Asset not found. "+e.getMessage());
        }
        catch (AssetNotMaintainException e) {
        	System.out.println("Asset is not Maintained. "+e.getMessage());
        }
    }
}
