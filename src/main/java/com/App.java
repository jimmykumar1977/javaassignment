package com;

import java.time.LocalDate;

import com.db.ObjectDatabase;
import com.event.AddEvent;
import com.event.UpdateEvent;
import com.event.client.JNotifiable;
import com.model.Order;
import com.service.Notification;
import com.service.impl.DBOperations;
import com.service.impl.NotificationServiceV2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Notification n = new NotificationServiceV2();
        JNotifiable j = new JNotifiable();
        n.register(j, AddEvent.class,UpdateEvent.class);
        
        ObjectDatabase db = new ObjectDatabase(new DBOperations(),n);
        db.add(new Order(12,LocalDate.of(2018, 10, 10),2,3));
        Order d = db.get(12);
        d.setOrderStatus(1);
        d.setRegionId(4);
        db.update(12,d);
    }
}
