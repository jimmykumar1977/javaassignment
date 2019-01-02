package com.event;

public class Event {

	private EventType evtType;
	
	private Object source;
	
	private Object oldValue;
	
	private Object newValue;
	
	public EventType getEvtType() {
		return evtType;
	}

	public Object getOldValue() {
		return oldValue;
	}

	public Object getNewValue() {
		return newValue;
	}

	public Event(EventType evtType, Object source, Object oldValue, Object newValue) {
		super();
		this.evtType = evtType;
		this.source = source;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

	public static Event of(EventType evtType, Object source, Object oldValue, Object newValue) {
		Event e = new Event(evtType,source,oldValue,newValue);
		return e;
	}

	public Object getSource() {
		return source;
	}

}
