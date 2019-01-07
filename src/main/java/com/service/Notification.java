package com.service;

import com.event.Event;
import com.event.EventType;

public interface Notification {

	void register(Notifiable type, Class... evt);

	void publish(Event evt);

}
