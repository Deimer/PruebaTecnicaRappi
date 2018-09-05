package com.villa.deimer.pruebatecnicarappi.events;

public class MessageBusCategory {

    private boolean active;
    private int option;

    public MessageBusCategory(boolean active, int option) {
        this.active = active;
        this.option = option;
    }

    public boolean isActive() {
        return active;
    }
    public int getOption() {
        return option;
    }

}
