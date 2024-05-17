package com.java.AssetManagement.dao;

import java.sql.SQLException;

import com.java.AssetManagement.model.Assets;
import com.java.AssetManagement.myexceptions.AssetNotFoundException;
import com.java.AssetManagement.myexceptions.AssetNotMaintainException;

public interface AssetManagementService {

	 boolean addAsset(Assets asset) throws ClassNotFoundException;
	 boolean updateAsset(Assets asset) throws ClassNotFoundException,AssetNotFoundException;
	 boolean deleteAsset(int assetId) throws ClassNotFoundException,AssetNotFoundException;
	 boolean allocateAsset(int assetId, int employeeId, String allocationDate) throws ClassNotFoundException,AssetNotFoundException;
	 boolean deallocateAsset(int assetId, int employeeId, String returnDate) throws ClassNotFoundException,AssetNotFoundException;
	 boolean performMaintenance(int assetId, String maintenanceDate, String description, double cost) throws ClassNotFoundException, SQLException, AssetNotFoundException;
	 boolean reserveAsset(int assetId, int employeeId, String reservationDate, String startDate, String endDate) throws ClassNotFoundException,AssetNotFoundException;
	 boolean withdrawReservation(int reservationId) throws ClassNotFoundException;
	 boolean checkAssetExists(int assetId) throws ClassNotFoundException, SQLException,ClassNotFoundException;
	 boolean checkAssetMaintenance(int assetId) throws ClassNotFoundException, SQLException,ClassNotFoundException;

}
