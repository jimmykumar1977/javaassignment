package com.event;

public class Event {

	private EventType type;
	
	private String propertyName;
	
	private Object source;
	
	private Object oldValue;
	
	private Object newValue;
	
	public Object getOldValue() {
		return oldValue;
	}

	public Object getNewValue() {
		return newValue;
	}

	public Event(EventType evtType, Object source,String property, Object oldValue, Object newValue) {
		super();
		this.type = evtType;
		this.source = source;
		this.propertyName = property;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	
	public Event(EventType evtType, Object source,Object oldValue, Object newValue) {
		super();
		this.type = evtType;
		this.source = source;
		this.propertyName = null;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public Event(EventType evtType, Object source) {
		super();
		this.type = evtType;
		this.source = source;
	}


	public static Event addEvent(Object source) {
		Event e = new AddEvent(EventType.ADD,source);
		return e;
	}
	
	public static Event deleteEvent(Object source) {
		Event e = new DeleteEvent(EventType.DELETE,source);
		return e;
	}
	
	public static Event getEvent(Object source) {
		Event e = new GetEvent(EventType.GET,source);
		return e;
	}
	
	public static Event updateEvent(Object source,String property,Object oldValue,Object newValue) {
		Event e = new UpdateEvent(EventType.UPDATE,source,property,oldValue,newValue);
		return e;
	}

	public Object getSource() {
		return source;
	}

	public EventType getType() {
		return type;
	}

	public String getPropertyName() {
		return propertyName;
	}

}
