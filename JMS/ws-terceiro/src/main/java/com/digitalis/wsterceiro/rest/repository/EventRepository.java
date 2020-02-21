package com.digitalis.wsterceiro.rest.repository;

import com.digitalis.wsterceiro.rest.model.DifEvents;
import com.digitalis.wsterceiro.rest.model.Event;
import com.digitalis.wsterceiro.rest.model.EventState;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventRepository {

    public List<Event> findAll() {
        List<Event> events = new ArrayList<Event>();

        Event e1 = new Event();
        e1.setId(1L);
        e1.setApplicationId("SIGES");
        e1.setBusinessCategoryId("OK");
        e1.setBusinessId("CREATE_CANDIDATE");
        e1.setEventDate(new Timestamp(System.currentTimeMillis() - 500000000));
        e1.setState(EventState.PENDING.getDescription());
        e1.setPublisherId(DifEvents.SIGES_EVENT_PUBLISHER.getDescription());
        e1.setUserIdThatTriggeredEvent("5");

        Event e2 = new Event();
        e2.setId(2L);
        e2.setApplicationId("SIGES");
        e2.setBusinessCategoryId("TESTE");
        e2.setBusinessId("CREATE_CANDIDATE");
        e2.setEventDate(new Timestamp(System.currentTimeMillis() - 500000000));
        e2.setState(EventState.PENDING.getDescription());
        e2.setPublisherId(DifEvents.SIGES_EVENT_PUBLISHER.getDescription());
        e2.setUserIdThatTriggeredEvent("5");

        Event e3 = new Event();
        e3.setId(3L);
        e3.setApplicationId("SIGES");
        e3.setBusinessCategoryId("OK");
        e3.setBusinessId("CREATE_CANDIDATE");
        e3.setEventDate(new Timestamp(System.currentTimeMillis()));
        e3.setState(EventState.PENDING.getDescription());
        e3.setPublisherId(DifEvents.SIGES_EVENT_PUBLISHER.getDescription());
        e3.setUserIdThatTriggeredEvent("5");

        Event e4 = new Event();
        e4.setId(4L);
        e4.setApplicationId("SIGES");
        e4.setBusinessCategoryId("TESTE");
        e4.setBusinessId("CREATE_CANDIDATE");
        e4.setEventDate(new Timestamp(System.currentTimeMillis()));
        e4.setState(EventState.PENDING.getDescription());
        e4.setPublisherId(DifEvents.SIGES_EVENT_PUBLISHER.getDescription());
        e4.setUserIdThatTriggeredEvent("5");

        Event e5 = new Event();
        e5.setId(5L);
        e5.setApplicationId("SIGES");
        e5.setBusinessCategoryId("OK");
        e5.setBusinessId("CREATE_CANDIDATE");
        e5.setEventDate(new Timestamp(System.currentTimeMillis()));
        e5.setState(EventState.PENDING.getDescription());
        e5.setPublisherId(DifEvents.SIGES_EVENT_PUBLISHER.getDescription());
        e5.setUserIdThatTriggeredEvent("5");

        events = Arrays.asList(e1, e2, e3, e4, e5);

        return events;
    }
}
