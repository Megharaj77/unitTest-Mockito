package com.skillsoft.moks;


//public class WeeklyReportsBatchJob {
//    
//	private ResourceProvisioner resourceProvisioner;
//	private DataPreparer dataPreparer;
//	private EmailSender emailSender;
//	
//	
//	
//	public WeeklyReportsBatchJob(ResourceProvisioner resourceProvisioner, DataPreparer dataPreparer,
//			EmailSender emailSender) {
//		this.resourceProvisioner = resourceProvisioner;
//		this.dataPreparer = dataPreparer;
//		this.emailSender = emailSender;
//	}
//
//	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
//		
//		//NOTE: Assume that this runs some kind of batch job to prepare and generate
//		//weekly reports and then send an update to the email recipients that the 
//		//weekly report has been generated
//		
//		if(resourceProvisioner.setupCluster(3, "Linux", "Spark")&&
//				dataPreparer.prepareRawData()) {
//			
//			return emailSender.sendEmail(emailRecipient,
//					String.format("The %s weekly report has been generated", reportType));
//		}
//		
//		return false;
//	}
//	
//public boolean sendWeeklyReport(String reportType, String emailRecipients) {
//		
//		//NOTE: Assume that this runs some kind of batch job to prepare and generate
//		//weekly reports and then send a copy of the weekly report to the multiple email recipients
//		
//	if(resourceProvisioner.setupSingleMachine("Linux", "Java")&&
//			dataPreparer.prepareRawData()) {
//		
//		String reportCopy = "Sales have been going up";
//		
//		return emailSender.sendEmailWithAttachment(emailRecipients,
//				                             String.format("The %s weekly report has been generated", reportType),
//				                             reportCopy.getBytes());
//	}
//		
//	return false;
//	}
//
//
//}



///* setters property injection*/
//
//public class WeeklyReportsBatchJob {
//    
//	private ResourceProvisioner resourceProvisioner;
//	private DataPreparer dataPreparer;
//	private EmailSender emailSender;
//	
//	
//	
//	
//
//
//	public WeeklyReportsBatchJob() {
//		
//	}
//
//
//
//	public void setResourceProvisioner(ResourceProvisioner resourceProvisioner) {
//		this.resourceProvisioner = resourceProvisioner;
//	}
//
//	
//
//	public void setDataPreparer(DataPreparer dataPreparer) {
//		this.dataPreparer = dataPreparer;
//	}
//
//	
//	public void setEmailSender(EmailSender emailSender) {
//		this.emailSender = emailSender;
//	}
//
//	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
//		
//		//NOTE: Assume that this runs some kind of batch job to prepare and generate
//		//weekly reports and then send an update to the email recipients that the 
//		//weekly report has been generated
//		
//		if(resourceProvisioner.setupCluster(3, "Linux", "Spark")&&
//				dataPreparer.prepareRawData()) {
//			
//			return emailSender.sendEmail(emailRecipient,
//					String.format("The %s weekly report has been generated", reportType));
//		}
//		
//		return false;
//	}
//	
//public boolean sendWeeklyReport(String reportType, String emailRecipients) {
//		
//		//NOTE: Assume that this runs some kind of batch job to prepare and generate
//		//weekly reports and then send a copy of the weekly report to the multiple email recipients
//		
//	if(resourceProvisioner.setupSingleMachine("Linux", "Java")&&
//			dataPreparer.prepareRawData()) {
//		
//		String reportCopy = "Sales have been going up";
//		
//		return emailSender.sendEmailWithAttachment(emailRecipients,
//				                             String.format("The %s weekly report has been generated", reportType),
//				                             reportCopy.getBytes());
//	}
//		
//	return false;
//	}
//
//
//}




/*injecting fields into nonparameterized constructor*/


public class WeeklyReportsBatchJob {
    
	private ResourceProvisioner resourceProvisioner;
	private DataPreparer dataPreparer;
	private EmailSender emailSender;
	
	
	public WeeklyReportsBatchJob() {
		
	}

	

	public boolean generateWeeklyReport(String reportType, String emailRecipient) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
		//weekly reports and then send an update to the email recipients that the 
		//weekly report has been generated
		
		if(resourceProvisioner.setupCluster(3, "Linux", "Spark")&&
				dataPreparer.prepareRawData()) {
			
			return emailSender.sendEmail(emailRecipient,
					String.format("The %s weekly report has been generated", reportType));
		}
		
		return false;
	}
	
public boolean sendWeeklyReport(String reportType, String emailRecipients) {
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
		//weekly reports and then send a copy of the weekly report to the multiple email recipients
		
	if(resourceProvisioner.setupSingleMachine("Linux", "Java")&&
			dataPreparer.prepareRawData()) {
		
		String reportCopy = "Sales have been going up";
		
		return emailSender.sendEmailWithAttachment(emailRecipients,
				                             String.format("The %s weekly report has been generated", reportType),
				                             reportCopy.getBytes());
	}
		
	return false;
	}


}
