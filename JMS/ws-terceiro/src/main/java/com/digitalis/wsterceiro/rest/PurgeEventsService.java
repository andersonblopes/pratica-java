package com.digitalis.wsterceiro.rest;

import com.digitalis.wsterceiro.rest.model.Event;

import java.util.Calendar;
import java.util.Date;

public class PurgeEventsService {


    /**
     * @param e Event
     *
     * @return boolean
     */
    public boolean IsAfter(Event e, Long days)
    {
        Calendar today = Calendar.getInstance();
        today.setTimeInMillis(new Date().getTime());
        Calendar eventDate = Calendar.getInstance();
        eventDate.setTimeInMillis(e.getEventDate().getTime());
        eventDate.add(Calendar.DAY_OF_MONTH, days.intValue());
        return eventDate.before(today);
    }
}
