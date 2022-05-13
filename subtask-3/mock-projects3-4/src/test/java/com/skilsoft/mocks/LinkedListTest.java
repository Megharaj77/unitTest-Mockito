package com.skilsoft.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

	@Test
	public void testLinkedList() {
//		
//		LinkedList<String> linkedList = new LinkedList<>();
//		LinkedList<String> linkedListSpy = spy(linkedList);
//		
//		System.out.println("toString() on spy:" + linkedListSpy);
//		
//		System.out.println("getClass() on spy: "+ linkedListSpy.getClass());
//		
//		System.out.println("linkedListSpy instance of LinkedList: " + (linkedListSpy instanceof LinkedList));
	
	
	
//	
//		LinkedList<String> linkedList = new LinkedList<>();
//		LinkedList<String> linkedListSpy = spy(linkedList);
//		
//		linkedListSpy.add("Nora");
//		linkedListSpy.add("Fred");
//		linkedListSpy.add("Maureen");
//		
//		verify(linkedListSpy, times(3)).add(anyString());
//		
//		assertEquals(3, linkedListSpy.size());
	
		
		

		LinkedList<String> linkedList = new LinkedList<>();
		LinkedList<String> linkedListSpy = spy(linkedList);
		
		linkedListSpy.add("Nora");
		linkedListSpy.add("Fred");
		linkedListSpy.add("Maureen");
		
         System.out.println("Contents of linked list: " + linkedList);
         System.out.println("Contents of linked list spy: " + linkedListSpy);
         
		assertNotEquals(linkedList.size(), linkedListSpy.size());
	
	}
}
