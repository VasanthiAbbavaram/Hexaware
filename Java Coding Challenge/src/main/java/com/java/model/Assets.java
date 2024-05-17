package com.java.AssetManagement.model;

import java.util.Date;
import java.util.Objects;

public class Assets {

	private int assetId;
	private String name;
	private String type;
	private int serialNumber;
	private Date purchaseDate;
	private String location;
	private String status;
	private int ownerId;
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	public Assets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Assets(int assetId, String name, String type, int serialNumber, Date purchaseDate, String location,
			String status, int ownerId) {
		super();
		this.assetId = assetId;
		this.name = name;
		this.type = type;
		this.serialNumber = serialNumber;
		this.purchaseDate = purchaseDate;
		this.location = location;
		this.status = status;
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return "Assets [assetId=" + assetId + ", name=" + name + ", type=" + type + ", serialNumber=" + serialNumber
				+ ", purchaseDate=" + purchaseDate + ", location=" + location + ", status=" + status + ", ownerId="
				+ ownerId + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(assetId, location, name, ownerId, purchaseDate, serialNumber, status, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assets other = (Assets) obj;
		return assetId == other.assetId && Objects.equals(location, other.location) && Objects.equals(name, other.name)
				&& ownerId == other.ownerId && Objects.equals(purchaseDate, other.purchaseDate)
				&& serialNumber == other.serialNumber && Objects.equals(status, other.status)
				&& Objects.equals(type, other.type);
	}
	
	
}
