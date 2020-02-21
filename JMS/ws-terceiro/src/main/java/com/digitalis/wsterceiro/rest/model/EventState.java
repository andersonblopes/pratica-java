package com.digitalis.wsterceiro.rest.model;

public enum EventState {

    /**
     * Success event state.
     */
    SUCCESS("S"),
    /**
     * Pending event state.
     */
    PENDING("P"),
    /**
     * Failed event state.
     */
    FAILED("F"),
    /**
     * Failed event state.
     */
    EXPIRED("X"),
    /**
     * Failed event state.
     */
    IN_PROCESS("I");

    /**
     *
     */
    private String description;

    /**
     * @param description description
     */
    EventState(String description)
    {
        this.description = description;
    }

    /**
     * @return description
     */
    public String getDescription()
    {
        return description;
    }

}
