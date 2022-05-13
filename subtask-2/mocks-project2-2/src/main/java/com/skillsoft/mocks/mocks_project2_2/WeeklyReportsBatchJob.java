package com.skillsoft.mocks.mocks_project2_2;


public class WeeklyReportsBatchJob {

	private EmailSender emailSender;
	
	public WeeklyReportsBatchJob(EmailSender emailSender) {
		
		this.emailSender = emailSender;
	}
	
	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
		//weekly reports and then send an update to the email recipients that the 
		//weekly report has been generated
		
		return emailSender.sendEmail(emailRecipient,
				String.format("The %s weekly report has been generated", reportType));
	}
	
public boolean generateWeeklyReport(String reportType, String[] emailRecipients) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
		//weekly reports and then send a copy of the weekly report to the multiple email recipients
		
	
	    String reportCopy = "Sales have been going up";
		
		return emailSender.sendEmailToMultipleRecipients(emailRecipients,
				String.format("The %s weekly report has been generated", reportType));
	}

public boolean sendWeeklyReport(String reportType, String emailRecipient) {
	
//	/NOTE: Assume that this runs some kind of batch job to prepare and generate
	//weekly reports and then send a copy of the weekly report to the email recipients
	
	 String reportCopy = "Sales have been going up"; 
	 
	return emailSender.sendEmailWithAttachment(emailRecipient,
			String.format("The %s weekly report has been generated", reportType),
			reportCopy.getBytes());
}
}
