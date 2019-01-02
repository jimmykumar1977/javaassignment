package com.db;

import com.model.Order;
import com.service.Notification;
import com.service.Operations;

public class ObjectDatabase implements Operations{

	private Operations _ops;
	
	private Notification _n;

	public ObjectDatabase( Operations _ops, Notification _n) {
		super();
		this._ops = _ops;
		this._n = _n;
	}

	@Override
	public synchronized void add(Order o) {
	  _ops.add(o);
		
	}

	@Override
	public synchronized void update(int id, Order o) {
		_ops.update(id, o);
	}

	@Override
	public synchronized void delete(int id) {
	_ops.delete(id);
		
	}

	@Override
	public Order get(int id) {
		return _ops.get(id);
	}
}
