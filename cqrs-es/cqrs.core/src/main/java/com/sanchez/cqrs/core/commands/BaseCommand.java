package com.sanchez.cqrs.core.commands;

import com.sanchez.cqrs.core.messages.Message;

public class BaseCommand extends Message {

    public abstract static class Builder<T extends BaseCommand, B extends Builder<T, B>>
            extends Message.Builder<T, B> {

        protected Builder(T command) {
            super(command);
        }
    }

}
