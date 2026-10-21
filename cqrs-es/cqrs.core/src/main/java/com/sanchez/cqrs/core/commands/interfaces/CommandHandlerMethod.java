package com.sanchez.cqrs.core.commands.interfaces;

import com.sanchez.cqrs.core.commands.BaseCommand;

@FunctionalInterface
public interface CommandHandlerMethod<T extends BaseCommand>{

    void handle(BaseCommand baseCommand);

}
