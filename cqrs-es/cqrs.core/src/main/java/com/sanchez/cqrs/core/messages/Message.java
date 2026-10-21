package com.sanchez.cqrs.core.messages;

public abstract class Message {

    private String id;

    public String getId() {
        return id;
    }

    public abstract static class Builder<T extends Message, B extends Builder<T, B>> {

        protected final T message;

        protected Builder(T message) {
            this.message = message;
        }

        protected abstract B self();

        public B id(String id) {
            ((Message) message).id = id;
            return self();
        }

        public T build() {
            return message;
        }
    }

}
