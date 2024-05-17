package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;
import com.java.AssetManagement.myexceptions.AssetNotMaintainException;

public class AllocateAssetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to allocate:");
        int assetId = scanner.nextInt();
        scanner.nextLine();

        try {
            if (assetService.checkAssetExists(assetId)) {
            	if (!assetService.checkAssetMaintenance(assetId)) {
                    throw new AssetNotMaintainException("Asset with ID " + assetId + " requires maintenance but has not been maintained for two years.");
                }
            	System.out.println("Enter employee ID to allocate:");
                int employeeId = scanner.nextInt();
                System.out.println("Enter allocation date :");
                String allocationDate = scanner.next();
                boolean allocated = assetService.allocateAsset(assetId, employeeId, allocationDate);
                if (allocated) {
                    System.out.println("Asset allocated successfully");
                } 
            }
            else {
            	throw new AssetNotFoundException("Allocate assetS function cannot be performed...");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found.");
        }
        catch (SQLException e) {
            System.out.println("Error executing SQL query");
        }
        catch (AssetNotFoundException e) {
        	System.out.println("Asset is not Found. "+e.getMessage());
        }
        catch (AssetNotMaintainException e) {
        	System.out.println("Asset is not Maintained. "+e.getMessage());
        }
        
    }
}

