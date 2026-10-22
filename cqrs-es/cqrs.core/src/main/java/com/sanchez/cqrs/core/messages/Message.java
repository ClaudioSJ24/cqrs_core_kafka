package com.sanchez.cqrs.core.messages;

public abstract class Message {
    private String id;

    protected Message() {
    }

    protected Message(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract static class Builder<T extends Message, B extends Builder<T, B>> {

        protected final T message;

        protected Builder(T message) {
            this.message = message;
        }

        protected abstract B self();

        public B id(String id) {
            message.setId(id);
            return self();
        }

        public T build() {
            return message;
        }
    }

}
