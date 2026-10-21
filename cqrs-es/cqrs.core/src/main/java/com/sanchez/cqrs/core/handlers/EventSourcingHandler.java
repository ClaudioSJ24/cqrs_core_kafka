package com.sanchez.cqrs.core.handlers;

import com.sanchez.cqrs.core.domain.AggregateRoot;

public interface EventSourcingHandler<T> {

    void save(AggregateRoot aggregateRoot);
    T getById(String id);
}
