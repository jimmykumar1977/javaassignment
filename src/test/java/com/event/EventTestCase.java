package com.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventTestCase {

	Event e ;
	
	@BeforeEach
	public void init() {
		e = Event.updateEvent(null,"", "111", "222");
	}
	
	@Test
	public void testEventValues() {
		assertEquals("222", e.getNewValue());
	}
}
