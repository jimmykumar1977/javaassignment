package com.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.event.AddEvent;
import com.event.Event;
import com.event.EventType;
import com.event.client.JNotifiable;
import com.service.Notification;

public class NotificationTest {

	Notification ns;
	

	@BeforeEach
	public void init() {
		ns = new NotificationServiceV2();
	}

	@Test
	public void testEventValues() {
		
		JNotifiable j = mock(JNotifiable.class); 
		ns.register(j, AddEvent.class);
		
		Event ae = new AddEvent(EventType.ADD,null);
		ns.publish(ae);
		verify(j,times(1));
	}
}
