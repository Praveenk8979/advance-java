package com.smsService;

public class SendOTP {
	public static void main(String[] args) {
        String mobileNumber = "7983974422"; // Replace with the desired mobile number
        int otp = GenerateOTP.generateOTP();
        GenerateOTP.sendOTP(mobileNumber, otp);
        System.out.println("OTP sent successfully.");
    }
}
