package com.java.AssetManagement.model;

import java.util.Date;
import java.util.Objects;

public class MaintenanceRecords {

	private int maintenanceId;
	private int assetId;
	private Date maintenanceDate;
	private String description;
	private double cost;
	public int getMaintenanceId() {
		return maintenanceId;
	}
	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public Date getMaintenanceDate() {
		return maintenanceDate;
	}
	public void setMaintenanceDate(Date maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public MaintenanceRecords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MaintenanceRecords(int maintenanceId, int assetId, Date maintenanceDate, String description, double cost) {
		super();
		this.maintenanceId = maintenanceId;
		this.assetId = assetId;
		this.maintenanceDate = maintenanceDate;
		this.description = description;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "MaintenanceRecords [maintenanceId=" + maintenanceId + ", assetId=" + assetId + ", maintenanceDate="
				+ maintenanceDate + ", description=" + description + ", cost=" + cost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(assetId, cost, description, maintenanceDate, maintenanceId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaintenanceRecords other = (MaintenanceRecords) obj;
		return assetId == other.assetId && Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(description, other.description)
				&& Objects.equals(maintenanceDate, other.maintenanceDate) && maintenanceId == other.maintenanceId;
	}
	
	
}
