package com.sanchez.cqrs.core.events;

import com.sanchez.cqrs.core.messages.Message;

public abstract class BaseEvent extends Message {

    private int version;

    public BaseEvent(int version) {
        this.version = version;
    }

    public BaseEvent(String id, int version) {
        super(id);
        this.version = version;
    }



    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
