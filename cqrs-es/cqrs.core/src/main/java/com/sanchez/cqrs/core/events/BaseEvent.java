package com.sanchez.cqrs.core.events;

import com.sanchez.cqrs.core.messages.Message;



public abstract class BaseEvent extends Message {

    private int version;

    public int getVersion() {
        return version;
    }

    public abstract static class Builder<T extends BaseEvent, B extends Builder<T, B>>
            extends Message.Builder<T, B> {

        protected Builder(T event) {
            super(event);
        }

        public B version(int version) {
            ((BaseEvent) message).version = version;
            return self();
        }
    }


}
