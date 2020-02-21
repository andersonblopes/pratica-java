package com.digitalis.wsterceiro.rest.model;

public enum DifEvents {

    /**
     *
     */
    SIGES_EVENT_PUBLISHER("SIGESEventPublisherImpl"),

    /**
     *
     */
    DIF_EVENT_PUBLISHER("DIFEventPublisherImpl"),

    /**
     *
     */
    WS_EVENT_SUBSCRIBER("WSEventSubscriber"),
    /**
     *
     */
    MB_EVENT_SUBSCRIBER("MBEventSubscriber");

    /**
     *
     */
    private String description;

    /**
     * @param description description
     */
    DifEvents(String description) {
        this.description = description;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
