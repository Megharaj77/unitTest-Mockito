package com.skillsoft.mocks.mocks_project1_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class ComparatorMock {

	@Test
	public void mockComparator() {
		
		Comparator<String> comparatorMock = mock(Comparator.class);
		
//		System.out.println("toString() of comparator mock: " + comparatorMock);
//		System.out.println("getClass() of comparator mock: " + comparatorMock.getClass());
//		System.out.println(" comparator mock instance of comparator: " + (comparatorMock instanceof ComparatorMock));
		
		
		
		when(comparatorMock.compare("Alice", "Bob")).thenReturn(1);
		when(comparatorMock.compare("Bob", "Charles")).thenReturn(1);
		when(comparatorMock.compare("Alice", "Charles")).thenReturn(1);
		
		when(comparatorMock.compare("Bob", "Alice")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Bob")).thenReturn(-1);
		when(comparatorMock.compare("Charles", "Alice")).thenReturn(-1);
		
		when(comparatorMock.compare("Alice", "Alice")).thenReturn(0);
		when(comparatorMock.compare("Bob", "Bob")).thenReturn(0);
		when(comparatorMock.compare("Charles", "Charles")).thenReturn(0);
		
		
		
		assertTrue(comparatorMock.compare("Alice", "Charles")>0);
		assertTrue(comparatorMock.compare("Charles", "Bob")<0);
		assertEquals(0,comparatorMock.compare("Bob", "Bob"));


	}
}
