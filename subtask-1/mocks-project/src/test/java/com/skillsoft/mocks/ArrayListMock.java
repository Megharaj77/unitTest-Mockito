package com.skillsoft.mocks;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArrayListMock {

	
	@Test
	public void mockArrayList() {
		
		ArrayList someArrayList = mock(ArrayList.class);
		
		System.out.println("toString() of mock: " + someArrayList);
		System.out.println("getClass() of mock: " + someArrayList.getClass());
		System.out.println("getClass().getSuperClass() of mock: " + someArrayList.getClass().getSuperclass());
		
		System.out.println("someArrayList instance of ArrayList: " + (someArrayList instanceof ArrayList));
		System.out.println("someArrayList instance of List: " + (someArrayList instanceof List));
		System.out.println("someArrayList instance of Collection: " + (someArrayList instanceof Collection));
		System.out.println("someArrayList instance of Iterable: " + (someArrayList instanceof Iterable));
		System.out.println("someArrayList instance of Object: " + (someArrayList instanceof Object));
	}
}
