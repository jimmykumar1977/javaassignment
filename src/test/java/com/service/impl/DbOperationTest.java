package com.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.model.Order;
import com.service.Operations;

public class DbOperationTest {
	Operations db ;
	
	@BeforeEach
	public void init() {
		 db = new DBOperations();
	}
	
	
	@Test
	public void testDBAdd() {
		db.add(new Order(1,LocalDate.now(),2,3));
		Order ord = db.get(1);
		assertEquals(ord.getOrderStatus(), 3);
	}
	
	@Test
	public void testDBUpdate() {
		db.add(new Order(1,LocalDate.now(),2,3));
		Order ord = db.get(1);
		ord.setOrderStatus(4);
		db.update(1,ord);
		ord = db.get(1);
		assertEquals(ord.getOrderStatus(), 4);
	}
	
	@Test
	public void testDBRemove() {
		db.add(new Order(1,LocalDate.now(),2,3));
		Order ord = db.get(1);
		db.delete(1);
		ord = db.get(1);
		assertNull(ord, "is null");
	}
}
