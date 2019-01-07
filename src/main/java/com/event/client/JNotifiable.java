package com.event.client;

import com.event.AddEvent;
import com.event.UpdateEvent;
import com.service.Notifiable;

public class JNotifiable  implements Notifiable {

	
	public void alert(AddEvent evt) {
		System.out.println("event received :"+evt.getType() + " object created =  "+evt.getSource());
	}
	
	public void alert(UpdateEvent evt) {
		System.out.println("Update event  received :"+evt.getType() +" property "+evt.getPropertyName() +" old value "+evt.getOldValue()+ ": new value "+evt.getNewValue());
	}

}
