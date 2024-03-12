package com.smsService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class GenerateOTP {
	// Your Twilio Account SID and Auth Token
	public static final String ACCOUNT_SID = "your_account_sid";
	public static final String AUTH_TOKEN = "your_auth_token";

	public static void main(String[] args) {
		// Initialize Twilio with your Account SID and Auth Token
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		// Your Twilio phone number and recipient's phone number
		String fromPhoneNumber = "8979213254"; // Replace with your Twilio phone number
		String toPhoneNumber = "7983974422"; // Replace with recipient's phone number

		// The message you want to send
		String messageBody = "This is a test message from Twilio.";

		// Send the message using Twilio's API
		Message message = Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), messageBody)
				.create();

		// Print the message SID to confirm the message was sent
		System.out.println("Message SID: " + message.getSid());
	}

	public static int generateOTP() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void sendOTP(String mobileNumber, int otp) {
		// TODO Auto-generated method stub
		
	}

}
