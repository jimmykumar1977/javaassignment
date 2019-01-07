package com.db;

import java.util.List;

import com.event.Event;
import com.event.EventType;
import com.model.Order;
import com.service.Notification;
import com.service.Operations;
import com.util.ClassUtils;

public class ObjectDatabase implements Operations {

	private Operations _ops;

	private Notification _n;

	public ObjectDatabase(Operations _ops, Notification _n) {
		super();
		this._ops = _ops;
		this._n = _n;
	}

	@Override
	public synchronized void add(Order o) {
		_ops.add(o);
		Event e = Event.addEvent(o);
		_n.publish(e);
		
	}

	@Override
	public synchronized void update(int id, Order o) {
		Order og = _ops.get(id);
		_ops.update(id, o);
		List<Event> ets = ClassUtils.valuesChange(og, o);
		for(Event evt: ets) {
		_n.publish(evt);	 
		}
	}

	@Override
	public synchronized void delete(int id) {
		Order o = _ops.get(id);
		_ops.delete(id);
		Event e = Event.deleteEvent(o);
		_n.publish(e);

	}

	@Override
	public Order get(int id) {
		Order o = _ops.get(id);
		Event e = Event.getEvent(o);
		_n.publish(e);
		return o;
	}
}
