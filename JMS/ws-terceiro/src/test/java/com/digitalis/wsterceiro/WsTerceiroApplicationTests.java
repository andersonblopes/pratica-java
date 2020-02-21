package com.digitalis.wsterceiro;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.digitalis.wsterceiro.rest.PurgeEventsService;
import com.digitalis.wsterceiro.rest.model.Event;
import com.digitalis.wsterceiro.rest.repository.EventRepository;

@SpringBootTest
class WsTerceiroApplicationTests {

    @Test
    void contextLoads()
    {
        EventRepository eventRepository = new EventRepository();
        PurgeEventsService purgeEventsService = new PurgeEventsService();
        List<Event> events = eventRepository.findAll();
        Long numberOfDaysToPurge = 10L;
        Long numberOfDaysToExpire = 1L;
        int eventsBeforeNumberOfDaysToPurge = 0;
        int eventsBeforeNumberOfDaysToExpire = 0;
        for (Event event: events)
        {
            if (purgeEventsService.IsAfter(event, numberOfDaysToPurge))
            {
                eventsBeforeNumberOfDaysToPurge++;
            }
            if (purgeEventsService.IsAfter(event, numberOfDaysToExpire))
            {
                eventsBeforeNumberOfDaysToExpire++;
            }
            /*
             * System.out.println("Verify numberOfDaysToPurge: " + event.getEventDate() + " IsBefore: " +
             * purgeEventsService.IsAfter(event, numberOfDaysToPurge));
             * System.out.println("Verify numberOfDaysToExpire: " + event.getEventDate() + " IsBefore: " +
             * purgeEventsService.IsAfter(event, numberOfDaysToExpire));
             */
        }
        org.junit.Assert.assertEquals(0, eventsBeforeNumberOfDaysToPurge);
        org.junit.Assert.assertEquals(2, eventsBeforeNumberOfDaysToExpire);
    }

}
