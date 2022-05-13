package com.skilsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

public class ComparatorTest {

	   
			@Spy
			Comparator<String> comparatorSpy = new Comparator<String>() {
				
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			};
			
			AutoCloseable closeable;
			
			@BeforeEach
			public void setupTest() {
				closeable = openMocks(this);
			}
			
			@AfterEach
			public void tearDownTest() throws Exception {
				closeable.close();
			}
			
			@Test
			public void comparatorSpy() {
				
				assertTrue(comparatorSpy.compare("Alice", "Bob")<0);
				assertTrue(comparatorSpy.compare("Charles", "Bob")>0);
				
				verify(comparatorSpy, atLeastOnce()).compare(anyString(),anyString());
				
				when(comparatorSpy.compare(anyString(), anyString())).thenReturn(0);
				
				assertEquals(0,comparatorSpy.compare("Alice", "Bob"));
				assertEquals(0,comparatorSpy.compare("Charles", "Bob"));
			}
}
