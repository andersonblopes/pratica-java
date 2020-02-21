package com.digitalis.wsterceiro.rest.repository;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.digitalis.wsterceiro.rest.model.EventResult;
import com.digitalis.wsterceiro.rest.model.EventState;

@Service
public class EventResultRepository {

    public EventResult response()
    {
        EventResult eventResult = new EventResult();
        eventResult.setResultDate(new Date());
        try
        {
            eventResult.setBusinessResult("Processado com sucesso!");
            eventResult.setResultMessage("OK");
            eventResult.setState(EventState.SUCCESS);
        }
        catch (Exception e)
        {
            eventResult.setBusinessResult("Falha no processamento!");
            eventResult.setBusinessResult("NOK!");
            eventResult.setState(EventState.FAILED);
            eventResult.setDigEventException(e.getMessage());
        }
        return eventResult;
    }

}
