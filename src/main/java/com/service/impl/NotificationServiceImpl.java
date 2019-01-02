package com.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.event.Event;
import com.event.EventType;
import com.service.Notifiable;
import com.service.Notification;

public class NotificationServiceImpl implements Notification {

private Map<EventType,Notifiable> _instance = new HashMap<>();
	
    @Override
	public void register(Notifiable type,EventType...evt) {
		for(EventType e : evt) {
			_instance.put(e, type);
		}
	}
	
	
	@Override
	public void publish(Event evt) {
		Set<EventType> not = _instance.keySet();
		for(EventType et:not) {
			if (et == evt.getEvtType()) {
				_instance.get(et).alert(evt);
			}
		}
		
	}

}
