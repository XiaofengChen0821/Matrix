package com.laioffer.matrix;

public class Event {
    /**
     * All data for a event.
     */
    private String title;
    private String address;
    private String description;

    /**
     * Constructor
     */
    public Event(String title, String address, String description) {
        this.title = title;
        this.address = address;
        this.description = description;
    }

    /**
     * Getters for private attributes of Event class.
     */

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
}
