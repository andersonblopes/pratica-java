package com.digitalis.wsterceiro.rest.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class Event {

    private Long id;

    private String applicationId;

    private String businessCategoryId;

    private String businessId;

    private Timestamp eventDate;

    private String state;

    private String publisherId;

    private String userIdThatTriggeredEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getBusinessCategoryId() {
        return businessCategoryId;
    }

    public void setBusinessCategoryId(String businessCategoryId) {
        this.businessCategoryId = businessCategoryId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Timestamp getEventDate() {
        return eventDate;
    }

    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getUserIdThatTriggeredEvent() {
        return userIdThatTriggeredEvent;
    }

    public void setUserIdThatTriggeredEvent(String userIdThatTriggeredEvent) {
        this.userIdThatTriggeredEvent = userIdThatTriggeredEvent;
    }
}
