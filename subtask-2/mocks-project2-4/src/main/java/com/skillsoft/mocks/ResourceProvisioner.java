package com.skillsoft.mocks;



public class ResourceProvisioner {

	private String cloudPlatform;
	private String authenticationKey;
	
	public ResourceProvisioner(String cloudPlatform, String authenticationKey) {
		this.cloudPlatform = cloudPlatform;
		this.authenticationKey = authenticationKey;
	}
	
	public void initialize() {
		
		//NOTE: Assume this method does some initialization for this class
	}
	
	public boolean setupSingleMachine(String operationSystem,
			                            String framework) {
		
		//NOTE: Assume this makes the right calls to set Up a single machine, installs the 
		//operating system, and installs the software pacakage on the machine
		
		return true;
	}
	
	public boolean setupCluster(int numMachines, String operatingSystem,
			                                 String framework) {
		
		//NOTE: Assume this makes the right calls to set Up a cluster machine, configures networking, installs the 
		//operating system, and installs the software pacakage on the machine
		
		return true;
	}
	
}
