package com.event.client;

import com.event.Event;
import com.service.Notifiable;

public class JNotifiable implements Notifiable {

	@Override
	public void alert(Event evt) {
		System.out.println("event received :"+evt.getEvtType() + " old value "+evt.getOldValue()+ ": new value "+evt.getNewValue());
	}

}
