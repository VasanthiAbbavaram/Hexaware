package com.java.AssetManagement.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;


public class DeleteAssetMain {

	public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter asset ID to delete:");
        int assetId = scanner.nextInt();
        scanner.nextLine();
        try {
        	if (assetService.checkAssetExists(assetId)) {
            boolean deleted = assetService.deleteAsset(assetId);
            if (deleted) {
                System.out.println("Asset deleted successfully.");
            } 
          }
        	else {
        		throw new AssetNotFoundException("Delete function cannot be performed...");
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
