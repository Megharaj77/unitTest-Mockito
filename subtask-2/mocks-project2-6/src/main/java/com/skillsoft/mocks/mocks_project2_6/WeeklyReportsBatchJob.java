package com.skillsoft.mocks.mocks_project2_6;

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
		
		
         int count = 0;
         for(int i = 0; i<numMachines; i++) {
        	 
        	 if(resourceProvisioner.setupMachine(operatingSystem, framework)) {
        		 count++;
        		 
        	 }else {
        		 break;
        	 }
         }
         
         if(count>0) {
        	 return emailSender.sendEmail(emailRecipients,
        			       String.format("The %s weekly report has been generated", reportType));
         }
         return false;
		
	}
	
	

}



