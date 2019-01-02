package com.service;

import com.model.Order;

public interface Operations {

	void add(Order o);
	
	void update(int id,Order o);
	
	void delete(int id);
	
	Order get(int id);
}
