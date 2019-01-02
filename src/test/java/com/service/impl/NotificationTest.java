package com.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.event.Event;
import com.event.EventType;
import com.event.client.JNotifiable;
import com.service.Notification;

public class NotificationTest {

	Notification ns;
	

	@BeforeEach
	public void init() {
		ns = new NotificationServiceImpl();
	}

	@Test
	public void testEventValues() {
		
		JNotifiable j = mock(JNotifiable.class); 
		ns.register(j, EventType.ADD,EventType.DELETE,EventType.GET,EventType.UPDATE);
		
		Event e = Event.of(EventType.ADD, null, "111", "222");
		ns.publish(e);
		verify(j,times(1));
	}
}
