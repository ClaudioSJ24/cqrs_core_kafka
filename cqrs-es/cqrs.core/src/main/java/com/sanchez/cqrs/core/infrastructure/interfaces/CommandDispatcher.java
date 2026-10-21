package com.sanchez.cqrs.core.infrastructure.interfaces;

import com.sanchez.cqrs.core.commands.BaseCommand;
import com.sanchez.cqrs.core.commands.interfaces.CommandHandlerMethod;

public interface CommandDispatcher {

    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> commandHandlerMethod);
    void send(BaseCommand baseCommand);
}
