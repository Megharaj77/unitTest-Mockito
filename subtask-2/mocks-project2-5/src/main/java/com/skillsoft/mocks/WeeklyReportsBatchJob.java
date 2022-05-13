package com.skillsoft.mocks;

import java.util.HashMap;
import java.util.Map;

public class WeeklyReportsBatchJob {
    
	private ResourceProvisioner resourceProvisioner;
	private DataPreparer dataPreparer;
	private EmailSender emailSender;
	
	private final Map<String, String> reportGenerationConfig = new HashMap<>();
	private final Map<String, String> reportSendingConfig = new HashMap<>();
	
	public void WeeklyReportBatchJob() {
		
	}
	
	public void initialize() {
		resourceProvisioner.initialize();
		dataPreparer.initialize();
	}
	
	public void initializeReportGenerationConfig(int numMachines,
			                                      String operatingSystem,
			                                      String framework) {
		
		reportGenerationConfig.put("numMachines", String.valueOf(numMachines));
		reportGenerationConfig.put("operatingSystem", operatingSystem);
		reportGenerationConfig.put("framework", framework);
	}
	
	public void initializeReportSendingConfig(String operatingSystem,
			                                   String framework) {
		
		reportSendingConfig.put("operatingSystem", operatingSystem);
		reportSendingConfig.put("framework", framework);
		
	}
	
	public boolean generateWeeklyReports(String reportType, String emailRecipients) {
		
         initialize();
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
		//weekly reports and then send an update to the email recipients that the 
		//weekly report has been generated
		
		int numMachines = Integer.parseInt(reportGenerationConfig.get("numMachines"));
		String operatingSystem = reportGenerationConfig.get("operatingSystem");
		String framework = reportGenerationConfig.get("framework");
		
//		dataPreparer.prepareRawData();
		
		if (resourceProvisioner.setupCluster(numMachines, operatingSystem, framework)&&
				                    dataPreparer.prepareRawData()) {
			
			return emailSender.sendEmail(emailRecipients,
					                      String.format("The %s weekly report has been generated", reportType));
		}
		
		return false;
		
	}
	
	public boolean sendWeeklyReport(String reportType, String emailRecipient) {
		
		initialize();
		
		//NOTE: Assume that this runs some kind of batch job to prepare and generate
				//weekly reports and then send a copy of the weekly report to the multiple email recipients
		
		String operatingSystem = reportSendingConfig.get("operatingSystem");
		String framework = reportSendingConfig.get("framework");
		
		if(resourceProvisioner.setupSingleMachine(operatingSystem, framework)&&
				                               dataPreparer.prepareRawData()) {
			
			String reportCopy = "Sales have been going up!";
			
			return emailSender.sendEmailWithAttachment(emailRecipient,
					                                     String.format("The %s weekly report has been generated", reportType),
					                                     reportCopy.getBytes());
		}
		
		return false;
	}
	

}



