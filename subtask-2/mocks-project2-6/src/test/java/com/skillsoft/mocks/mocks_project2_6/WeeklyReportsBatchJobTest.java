package com.skillsoft.mocks.mocks_project2_6;



import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



/*order of method invocation*/



//@ExtendWith(MockitoExtension.class)
//public class WeeklyReportsBatchJobTest {
//
//	@Mock
//	private EmailSender emailSenderMock;
//	
//	@Mock
//	private ResourceProvisioner resourceProvisionerMock;
//	
//	@Mock
//	private DataPreparer dataPreparerMock;
//	
//	@InjectMocks
//	WeeklyReportsBatchJob batchJob;
//	
//	@Test
//	public void testInitialize() {
//		batchJob.initialize();
//		
//		verify(resourceProvisionerMock).initialize();
//		verify(dataPreparerMock).initialize();
//		

//		
//		verifyNoInteractions(emailSenderMock);
//	}
//	
//	@Test
//	public void testGenerateWeeklyReport() {
//		when(resourceProvisionerMock.setupCluster(4, "Linux", "Spark")).thenReturn(true);
//		
//		when(dataPreparerMock.prepareRawData()).thenReturn(true);
//		
//		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
//		
//	
//		batchJob.initializeReportGenerationConfig(4, "Linux", "Spark");
//		batchJob.generateWeeklyReports("Sales", "john@infomoto.com");
//		
//		InOrder inOrderResourceProvisionerMock = inOrder(resourceProvisionerMock);
//		inOrderResourceProvisionerMock.verify(resourceProvisionerMock).initialize();
//		inOrderResourceProvisionerMock.verify(resourceProvisionerMock).setupCluster(anyInt(), anyString(), anyString());
//		
//		verifyNoMoreInteractions(resourceProvisionerMock);
//		
//		InOrder inOrderDataPreparerMock = inOrder(dataPreparerMock);
//		
//		inOrderDataPreparerMock.verify(dataPreparerMock).initialize();
//		
//		inOrderDataPreparerMock.verify(dataPreparerMock).prepareRawData();
//		
//		verifyNoMoreInteractions(dataPreparerMock);
//		
//		verify(emailSenderMock).sendEmail("john@infomoto.com", "The Sales weekly report has been generated");
//		
//		verifyNoMoreInteractions(emailSenderMock);
//	}
//	
//	@Test
//	public void sendWeeklyReport_withAttachment() {
//		when(resourceProvisionerMock.setupSingleMachine("Linux", "Java")).thenReturn(true);
//		
//		when(dataPreparerMock.prepareRawData()).thenReturn(true);
//		
//		when(emailSenderMock.sendEmailWithAttachment("john@infomoto.com",
//				                                  "The Profits weekly report has been generated",
//				                                  "Sales have been going up!".getBytes())).thenReturn(true);
//		
//		
//		batchJob.initializeReportSendingConfig("Linux", "Java");
//		batchJob.sendWeeklyReport("Profits", "john@infomoto.com");
//		
//		InOrder inOrderResourceProvisionerMock = inOrder(resourceProvisionerMock);
//		
//		inOrderResourceProvisionerMock.verify(resourceProvisionerMock).initialize();
//		
//		inOrderResourceProvisionerMock.verify(resourceProvisionerMock).setupSingleMachine(anyString(), anyString());
//		
//		verifyNoMoreInteractions(resourceProvisionerMock);
//		
//		InOrder inOrderDataPreparerMock = inOrder(dataPreparerMock);
//		
//		inOrderDataPreparerMock.verify(dataPreparerMock).initialize();
//		inOrderDataPreparerMock.verify(dataPreparerMock).prepareRawData();
//		
//		verifyNoMoreInteractions(dataPreparerMock);
//		
//		verify(emailSenderMock).sendEmailWithAttachment("john@infomoto.com", "The Profits weekly report has been generated",
//				                                          "Sales have been going up!".getBytes());
//	}
//}









@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobTest {

	@Mock
	private EmailSender emailSenderMock;
	
	@Mock
	private ResourceProvisioner resourceProvisionerMock;
	
	@Mock
	private DataPreparer dataPreparerMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testInitialize() {
		batchJob.initialize();
		
		verify(resourceProvisionerMock).initialize();
		verify(dataPreparerMock).initialize();
	
		
		verifyNoInteractions(emailSenderMock);
	}
	
//	@Test
//	public void testGenerateWeeklyReport() {
//		when(resourceProvisionerMock.setupMachine("Linux", "Spark")).thenReturn(false);
//		
//		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
//		
//	
//		batchJob.initializeReportGenerationConfig(4, "Linux", "Spark");
//		batchJob.generateWeeklyReports("Sales", "john@infomoto.com");
//		
//		verify(resourceProvisionerMock, times(4)).setupMachine("Linux", "Spark");
//
//		verify(emailSenderMock, only()).sendEmail("john@infomoto.com", "The Sales weekly report has been generated");
	
	
	
	
	
	@Test
	public void testGenerateWeeklyReport() {
		when(resourceProvisionerMock.setupMachine("Linux", "Spark")).thenReturn(true).thenReturn(true).thenReturn(false);
		
		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
		
	
		batchJob.initializeReportGenerationConfig(4, "Linux", "Spark");
		batchJob.generateWeeklyReports("Sales", "john@infomoto.com");
		
		verify(resourceProvisionerMock, atLeast(2)).setupMachine("Linux", "Spark");
		verify(resourceProvisionerMock, atMost(4)).setupMachine("Linux", "Spark");
		verify(emailSenderMock, only()).sendEmail("john@infomoto.com", "The Sales weekly report has been generated");
		

		verify(emailSenderMock, only()).sendEmail("john@infomoto.com", "The Sales weekly report has been generated");
	}
	
	
}