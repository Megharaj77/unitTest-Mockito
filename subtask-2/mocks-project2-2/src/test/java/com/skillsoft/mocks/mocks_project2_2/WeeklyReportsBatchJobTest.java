package com.skillsoft.mocks.mocks_project2_2;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.MockitoAnnotations.openMocks;


//public class WeeklyReportsBatchJobTest {
//
//	@Mock
//	private EmailSender emailSenderMock;
//	
//	private AutoCloseable closeable;
//	
//	@BeforeEach
//	public void setupMocks() {
//		closeable = openMocks(this);
//	}
//	
//	@AfterEach
//	public void releaseMocks() throws Exception{
//		closeable.close();
//	}
//	
//	@Test
//	public void testGenerateWeeklyReport_singleRecipient() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//
//		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
//		assertTrue(batchJob.generateWeeklyReport("Sales", "john@infomoto.com"));
//	}
//	
//	@Test
//	public void testGenerateWeeklyRport_multipleRecipients() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//		
//		when(emailSenderMock.sendEmailToMultipleRecipients(new String[] {"jhon@infomoto.com, julie@infomoto.com"}, 
//				               "The Revenues weekly report has been generated")).thenReturn(true);
//		
//		assertTrue(batchJob.generateWeeklyReport("Revenues", new String[] {"jhon@infomoto.com, julie@infomoto.com"}));
//	}
//	
//	@Test
//	public void sendWeeklyReport_withAttachment() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//		
//		when(emailSenderMock.sendEmailWithAttachment("jhon@infomoto.com", 
//				    "The Profits weekly report has been generated",
//				    "Sales have been going up".getBytes())).thenReturn(true);
//		
//		assertTrue(batchJob.sendWeeklyReport("Profits", "jhon@infomoto.com"));
//	}
//}






//@ExtendWith(MockitoExtension.class)
//public class WeeklyReportsBatchJobTest {
//
//	@Mock
//	private EmailSender emailSenderMock;
//	
//	
//	@Test
//	public void testGenerateWeeklyReport_singleRecipient() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//
//		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
//		assertTrue(batchJob.generateWeeklyReport("Sales", "john@infomoto.com"));
//	}
//	
//	@Test
//	public void testGenerateWeeklyRport_multipleRecipients() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//		
//		when(emailSenderMock.sendEmailToMultipleRecipients(new String[] {"jhon@infomoto.com, julie@infomoto.com"}, 
//				               "The Revenues weekly report has been generated")).thenReturn(true);
//		
//		assertTrue(batchJob.generateWeeklyReport("Revenues", new String[] {"jhon@infomoto.com, julie@infomoto.com"}));
//	}
//	
//	@Test
//	public void sendWeeklyReport_withAttachment() {
//		WeeklyReportsBatchJob batchJob = new WeeklyReportsBatchJob(emailSenderMock);
//		
//		when(emailSenderMock.sendEmailWithAttachment("jhon@infomoto.com", 
//				    "The Profits weekly report has been generated",
//				    "Sales have been going up".getBytes())).thenReturn(true);
//		
//		assertTrue(batchJob.sendWeeklyReport("Profits", "jhon@infomoto.com"));
//	}
//}




/*injectMock*/


@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobTest {

	@Mock
	private EmailSender emailSenderMock;
	
	@InjectMocks
	WeeklyReportsBatchJob batchJob;
	
	@Test
	public void testGenerateWeeklyReport_singleRecipient() {

		when(emailSenderMock.sendEmail("john@infomoto.com", "The Sales weekly report has been generated")).thenReturn(true);
		assertTrue(batchJob.generateWeeklyReport("Sales", "john@infomoto.com"));
	}
	
	@Test
	public void testGenerateWeeklyRport_multipleRecipients() {
		
		when(emailSenderMock.sendEmailToMultipleRecipients(new String[] {"jhon@infomoto.com, julie@infomoto.com"}, 
				               "The Revenues weekly report has been generated")).thenReturn(true);
		
		assertTrue(batchJob.generateWeeklyReport("Revenues", new String[] {"jhon@infomoto.com, julie@infomoto.com"}));
	}
	
	@Test
	public void sendWeeklyReport_withAttachment() {
		
		when(emailSenderMock.sendEmailWithAttachment("jhon@infomoto.com", 
				    "The Profits weekly report has been generated",
				    "Sales have been going up".getBytes())).thenReturn(true);
		
		assertTrue(batchJob.sendWeeklyReport("Profits", "jhon@infomoto.com"));
	}
}

