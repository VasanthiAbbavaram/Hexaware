package com.java.AssetManagement.model;

import java.util.Date;
import java.util.Objects;

public class Reservations {

	private int reservationId;
	private int assetId;
	private int employeeId;
	private Date reservationDate;
	private Date startDate;
	private Date endDate;
	private String status;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Reservations() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reservations(int reservationId, int assetId, int employeeId, Date reservationDate, Date startDate,
			Date endDate, String status) {
		super();
		this.reservationId = reservationId;
		this.assetId = assetId;
		this.employeeId = employeeId;
		this.reservationDate = reservationDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reservations [reservationId=" + reservationId + ", assetId=" + assetId + ", employeeId=" + employeeId
				+ ", reservationDate=" + reservationDate + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(assetId, employeeId, endDate, reservationDate, reservationId, startDate, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservations other = (Reservations) obj;
		return assetId == other.assetId && employeeId == other.employeeId && Objects.equals(endDate, other.endDate)
				&& Objects.equals(reservationDate, other.reservationDate) && reservationId == other.reservationId
				&& Objects.equals(startDate, other.startDate) && Objects.equals(status, other.status);
	}
	
	
	
}
