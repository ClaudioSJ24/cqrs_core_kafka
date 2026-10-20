package com.sanchez.cqrs.core.messages;

public abstract class Message {

    private String id;

    public Message() {
    }

    public Message(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .toString();
    }
}
