package com.java.AssetManagement;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.AssetManagement.model.Assets;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AssetTest {

    @Test
    public void testToString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Assets asset = new Assets(1, "Laptop", "Electronics", 12345, sdf.parse("2024-01-15"), "Office A", "Active", 1);
        String expected = "Assets [assetId=1, name=Laptop, type=Electronics, serialNumber=12345, purchaseDate=" +sdf.parse("2024-01-15") + ", location=Office A, status=Active, ownerId=1]";
        assertEquals(expected, asset.toString());
    }

    @Test
    public void testEquals() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Assets asset1 = new Assets(1, "Laptop", "Electronics", 12345, sdf.parse("2024-01-15"), "Office A", "Active", 1);
        Assets asset2 = new Assets(1, "Laptop", "Electronics", 12345,sdf.parse("2024-01-15"), "Office A", "Active", 1);
        Assets asset3 = new Assets(2, "Monitor", "Electronics", 67890, sdf.parse("2024-01-15"), "Office A", "Active", 2);
        assertTrue(asset1.equals(asset2));
        assertFalse(asset1.equals(asset3));
    }

    @Test
    public void testHashCode() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Assets asset1 = new Assets(1, "Laptop", "Electronics", 12345, sdf.parse("2024-01-15"), "Office A", "Active", 1);
        Assets asset2 = new Assets(1, "Laptop", "Electronics", 12345,sdf.parse("2024-01-15"), "Office A", "Active", 1);
        assertEquals(asset1.hashCode(), asset2.hashCode());
    }

    @Test
    public void testGettersAndSetters() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Assets asset = new Assets();
        asset.setAssetId(1);
        asset.setName("Laptop");
        asset.setType("Electronics");
        asset.setSerialNumber(12345);
        asset.setPurchaseDate(sdf.parse("2024-01-15"));
        asset.setLocation("Office A");
        asset.setStatus("Active");
        asset.setOwnerId(1);

        assertEquals(1, asset.getAssetId());
        assertEquals("Laptop", asset.getName());
        assertEquals("Electronics", asset.getType());
        assertEquals(12345, asset.getSerialNumber());
        assertEquals(sdf.parse("2024-01-15"), asset.getPurchaseDate());
        assertEquals("Office A", asset.getLocation());
        assertEquals("Active", asset.getStatus());
        assertEquals(1, asset.getOwnerId());
    }

    @Test
    public void testConstructors() throws ParseException {
        Assets asset = new Assets();
        assertNotNull(asset);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
        Assets constructedAsset = new Assets(1, "Laptop", "Electronics", 12345, sdf.parse("2024-01-15"), "Office A", "Active", 1);

        assertEquals(1, constructedAsset.getAssetId());
        assertEquals("Laptop", constructedAsset.getName());
        assertEquals("Electronics", constructedAsset.getType());
        assertEquals(12345, constructedAsset.getSerialNumber());
        assertEquals(sdf.parse("2024-01-15"), constructedAsset.getPurchaseDate());
        assertEquals("Office A", constructedAsset.getLocation());
        assertEquals("Active", constructedAsset.getStatus());
        assertEquals(1, constructedAsset.getOwnerId());
    }
}
