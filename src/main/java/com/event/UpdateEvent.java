package com.event;

public class UpdateEvent extends Event {

	public UpdateEvent(EventType evtType, Object source, Object oldValue, Object newValue) {
		super(evtType, source, oldValue, newValue);
	}

	public UpdateEvent(EventType evtType, Object source, String property, Object oldValue, Object newValue) {
		super(evtType, source, property, oldValue, newValue);
	}

	public UpdateEvent(EventType evtType, Object source) {
		super(evtType, source);
	}

	
}
