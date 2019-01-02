package com.db;

import com.event.Event;
import com.event.EventType;
import com.model.Order;
import com.service.Notification;
import com.service.Operations;

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
		Event e = Event.of(EventType.ADD, o, null, null);
		_n.publish(e);

	}

	@Override
	public synchronized void update(int id, Order o) {
		_ops.update(id, o);
		Event e = Event.of(EventType.UPDATE, o, null, null);
		_n.publish(e);
	}

	@Override
	public synchronized void delete(int id) {
		Order o = _ops.get(id);
		_ops.delete(id);
		Event e = Event.of(EventType.DELETE, o, null, null);
		_n.publish(e);

	}

	@Override
	public Order get(int id) {
		Order o = _ops.get(id);
		Event e = Event.of(EventType.GET, o, null, null);
		_n.publish(e);
		return o;
	}
}
