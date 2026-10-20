package com.sanchez.cqrs.core.commands;

import com.sanchez.cqrs.core.messages.Message;

public class BaseCommand extends Message {

    public BaseCommand(String id){
        super(id);
    }

}
