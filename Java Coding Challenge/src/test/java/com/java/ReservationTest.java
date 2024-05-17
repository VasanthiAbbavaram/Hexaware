package com.java.AssetManagement;

import static org.junit.Assert.*;
import org.junit.Test;

import com.java.AssetManagement.model.Reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;



public class ReservationTest {

    @Test
    public void testToString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Reservations reservation = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");
        String expected = "Reservations [reservationId=1, assetId=1, employeeId=1, reservationDate="+sdf.parse("2024-01-05")+ ", startDate="+sdf.parse("2024-01-10")+", endDate="+sdf.parse("2024-01-15") +", status=Confirmed]";
        assertEquals(expected, reservation.toString());
    }

    @Test
    public void testEquals() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Reservations reservation1 = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");
        Reservations reservation2 = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");
        Reservations reservation3 = new Reservations(2, 1, 1, (sdf.parse("2024-01-06")), (sdf.parse("2024-01-11")), (sdf.parse("2024-01-16")), "Pending");
        assertTrue(reservation1.equals(reservation2));
        assertFalse(reservation1.equals(reservation3));
    }

    @Test
    public void testHashCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Reservations reservation1 = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");
        Reservations reservation2 = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");
        assertEquals(reservation1.hashCode(), reservation2.hashCode());
    }

    @Test
    public void testGettersAndSetters() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Reservations reservation = new Reservations();
        reservation.setReservationId(1);
        reservation.setAssetId(1);
        reservation.setEmployeeId(1);
        reservation.setReservationDate((sdf.parse("2024-01-05")));
        reservation.setStartDate((sdf.parse("2024-01-10")));
        reservation.setEndDate((sdf.parse("2024-01-15")));
        reservation.setStatus("Confirmed");

        assertEquals(1, reservation.getReservationId());
        assertEquals(1, reservation.getAssetId());
        assertEquals(1, reservation.getEmployeeId());
        assertEquals((sdf.parse("2024-01-05")), reservation.getReservationDate());
        assertEquals((sdf.parse("2024-01-10")), reservation.getStartDate());
        assertEquals((sdf.parse("2024-01-15")), reservation.getEndDate());
        assertEquals("Confirmed", reservation.getStatus());
    }

    @Test
    public void testConstructors() throws ParseException {
        Reservations reservation = new Reservations();
        assertNotNull(reservation);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
        Reservations constructedReservation = new Reservations(1, 1, 1, (sdf.parse("2024-01-05")), (sdf.parse("2024-01-10")), (sdf.parse("2024-01-15")), "Confirmed");

        assertEquals(1, constructedReservation.getReservationId());
        assertEquals(1, constructedReservation.getAssetId());
        assertEquals(1, constructedReservation.getEmployeeId());
        assertEquals((sdf.parse("2024-01-05")), constructedReservation.getReservationDate());
        assertEquals((sdf.parse("2024-01-10")), constructedReservation.getStartDate());
        assertEquals((sdf.parse("2024-01-15")), constructedReservation.getEndDate());
        assertEquals("Confirmed", constructedReservation.getStatus());
    }
}
