package com.skillsoft.mocks.mocks_project2_6;


public class EmailSender {

	private String username;
	private String password;
	private String emailServer;
	
	
	public EmailSender(String username, String password, String emailServer) {
		this.username = username;
		this.password = password;
		this.emailServer = emailServer;
	}
	
	public boolean sendEmail(String toAddress, String emailText) {
		
		//NOTE: Assume that you connect to the email server and send your email here
		
		return true;
	}
	
	public boolean sendEmailToMultipleRecipients(String[] toAddresses, String emailText) {
		
		//NOTE: Assume that you connect to the email server and send your email to multiple recipients here
		
		return true;
		
	}
	
	public boolean sendEmailWithAttachment(String toAddress, String emailText, byte[] attachmentBytes) {
		
		//NOTE: Assume that you connect to the email server and send your email along with attachment here
		
		return true;
	}
}