package com.skillsoft.moks;



public class ResourceProvisioner {

	private String cloudPlatform;
	private String authenticationKey;
	
	public ResourceProvisioner(String cloudPlatform, String authenticationKey) {
		this.cloudPlatform = cloudPlatform;
		this.authenticationKey = authenticationKey;
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
