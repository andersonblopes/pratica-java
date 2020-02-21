package com.digitalis.wsterceiro.rest.exception;

/**
 * The type Event exception.
 */
public class DigEventException extends RuntimeException {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -252299248221026808L;

    /**
     * @param reason
     *            reason
     */
    public DigEventException(String reason)
    {
        super(reason);
    }

    /**
     * @param reason
     *            reason
     * @param exception
     *            exception
     */
    public DigEventException(String reason, Exception exception)
    {
        super(reason, exception);
    }
}
