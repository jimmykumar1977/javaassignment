package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.Order;
import com.service.Operations;

public class DBOperations implements Operations {

	final private List<Order> db;

	@Override
	public void add(Order o) {
		db.add(o);
	}

	public DBOperations() {
		super();
		this.db = new ArrayList<>();
	}

	@Override
	public void update(int id, Order o) {
		Optional<Order> ord = db.stream().filter(oo -> oo.getOrderId() == id).findFirst();
		if (ord.isPresent()) {
			Order d = ord.get();
			d = o;
		}
	}

	@Override
	public void delete(int id) {
		Optional<Order> ord = db.stream().filter(oo -> oo.getOrderId() == id).findFirst();
		if (ord.isPresent()) {
			Order d = ord.get();
			db.remove(d);
		}
	}

	@Override
	public Order get(int id) {
		Optional<Order> ord = db.stream().filter(oo -> oo.getOrderId() == id).findFirst();
		if (ord.isPresent()) {
			Order d = ord.get();
			return d;
		}
		return null;
	}

}
