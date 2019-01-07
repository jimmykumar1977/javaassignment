package com.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.event.Event;
import com.service.Notifiable;
import com.service.Notification;

public class NotificationServiceV2 implements Notification {

	private Map<String,List<Notifiable>> _instance = new HashMap<>();
	
	
	@Override
	public void publish(Event evt) {
		if (_instance.containsKey(evt.getClass().getName())) {
			List<Notifiable> ln = _instance.get(evt.getClass().getName());
			for(Notifiable nn : ln) {
				Method[] mm = nn.getClass().getMethods();
				for(Method m : mm) {
					Class[] cc = m.getParameterTypes();
					if (cc.length ==1) {
						if (cc[0].getName().equals(evt.getClass().getName())){
							try {
								m.invoke(nn,evt);
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
			}
			
		}
		
		
	}

	@Override
	public void register(Notifiable type, Class... evt) {
		for(Class e: evt) {
			if (_instance.containsKey(e.getName())) {
				List<Notifiable> ln = _instance.get(e.getName());
				ln.add(type);
			} else {
				List<Notifiable> ln = new ArrayList<>();
				ln.add(type);
				_instance.put(e.getName(), ln);
			}
		}
		
	}

}
