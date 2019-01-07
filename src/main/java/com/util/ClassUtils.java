package com.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.event.Event;
import com.event.EventType;
import com.event.UpdateEvent;
import com.model.Order;

public class ClassUtils {
	private static List<String> methodNames = new ArrayList<>();
	static {
		Method[] mArray = Order.class.getMethods();
		for (Method m : mArray) {
			if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
				methodNames.add(m.getName());
			}
		}
	}

	public static List<Event> valuesChange(Order o1, Order o2) {
		List<Event> changeMethodNames = new ArrayList<>();
		for (String s : methodNames) {
			try {
				Method md = Order.class.getMethod(s);
				try {
					Object v1 = md.invoke(o1);
					Object v2 = md.invoke(o2);
					if (!v1.equals(v2)) {
					//	changeMethodNames.add(s.replace("get", ""));
						Event e = new UpdateEvent(EventType.UPDATE,o2,s.replace("get", ""),v1,v2);
						changeMethodNames.add(e);
					} 
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return changeMethodNames;
	}
	
	public static Order clone(Order o) {
		Order od = new Order(o.getOrderId(),o.getOrderDate(),o.getRegionId(),o.getOrderStatus());
		return od;
	}
}
