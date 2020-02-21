package com.digitalis.wsterceiro.rest.model;

import java.io.Serializable;
import java.util.Date;

public class EventResult implements Serializable {

    private static final long serialVersionUID = 1L;
    private String businessResult;
    private String digEventException;
    private Date resultDate;
    private String resultMessage;
    private EventState state;

    public String getBusinessResult()
    {
        return businessResult;
    }

    public String getDigEventException()
    {
        return digEventException;
    }

    public Date getResultDate()
    {
        return resultDate;
    }

    public String getResultMessage()
    {
        return resultMessage;
    }

    public EventState getState()
    {
        return state;
    }

    public void setBusinessResult(String businessResult)
    {
        this.businessResult = businessResult;
    }

    public void setDigEventException(String digEventException)
    {
        this.digEventException = digEventException;
    }

    public void setResultDate(Date resultDate)
    {
        this.resultDate = resultDate;
    }

    public void setResultMessage(String resultMessage)
    {
        this.resultMessage = resultMessage;
    }

    public void setState(EventState state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {
        return "EventResult [businessResult=" + getBusinessResult() + ", resultDate=" + getResultDate()
                + ", digEventException=" + getDigEventException() + ", resultMessage=" + getResultMessage() + ", state="
                + getState() + "]";
    }

}
