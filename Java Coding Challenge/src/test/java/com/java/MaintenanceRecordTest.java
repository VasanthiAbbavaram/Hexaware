package com.java.AssetManagement;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.java.AssetManagement.model.MaintenanceRecords;

public class MaintenanceRecordTest {

    @Test
    public void testToString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MaintenanceRecords record = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);
        String expected = "MaintenanceRecords [maintenanceId=1, assetId=1, maintenanceDate="+sdf.parse("2024-02-05")+", description=Replaced battery, cost=50.0]";
        assertEquals(expected, record.toString());
    }

    @Test
    public void testEquals() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MaintenanceRecords record1 = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);
        MaintenanceRecords record2 = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);
        MaintenanceRecords record3 = new MaintenanceRecords(2, 1, (sdf.parse("2024-02-06")), "Replaced screen", 100.00);
        assertTrue(record1.equals(record2));
        assertFalse(record1.equals(record3));
    }

    @Test
    public void testHashCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MaintenanceRecords record1 = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);
        MaintenanceRecords record2 = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);
        assertEquals(record1.hashCode(), record2.hashCode());
    }

    @Test
    public void testGettersAndSetters() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        MaintenanceRecords record = new MaintenanceRecords();
        record.setMaintenanceId(1);
        record.setAssetId(1);
        record.setMaintenanceDate((sdf.parse("2024-02-05")));
        record.setDescription("Replaced battery");
        record.setCost(50.00);

        assertEquals(1, record.getMaintenanceId());
        assertEquals(1, record.getAssetId());
        assertEquals((sdf.parse("2024-02-05")), record.getMaintenanceDate());
        assertEquals("Replaced battery", record.getDescription());
        assertEquals(50.00, record.getCost(), 0.001);
    }

    @Test
    public void testConstructors() throws ParseException {
        MaintenanceRecords record = new MaintenanceRecords();
        assertNotNull(record);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
        MaintenanceRecords constructedRecord = new MaintenanceRecords(1, 1, (sdf.parse("2024-02-05")), "Replaced battery", 50.00);

        assertEquals(1, constructedRecord.getMaintenanceId());
        assertEquals(1, constructedRecord.getAssetId());
        assertEquals((sdf.parse("2024-02-05")), constructedRecord.getMaintenanceDate());
        assertEquals("Replaced battery", constructedRecord.getDescription());
        assertEquals(50.00, constructedRecord.getCost(), 0.001);
    }
}
