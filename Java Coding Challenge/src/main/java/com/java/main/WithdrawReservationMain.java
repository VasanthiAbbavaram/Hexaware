package com.java.AssetManagement.main;

import java.util.Scanner;

import com.java.AssetManagement.dao.AssetManagementService;
import com.java.AssetManagement.dao.AssetManagementServiceImpl;

public class WithdrawReservationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AssetManagementService assetService = new AssetManagementServiceImpl();

        System.out.println("Enter reservation ID to withdraw:");
        int reservationId = scanner.nextInt();

        try {
            boolean withdrawn = assetService.withdrawReservation(reservationId);
            if (withdrawn) {
                System.out.println("Reservation withdrawn successfully");
            } else {
                System.out.println("Failed to withdraw reservation,Invalid ReservationId");
            }
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
