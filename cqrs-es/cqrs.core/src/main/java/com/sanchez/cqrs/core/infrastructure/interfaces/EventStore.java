package com.sanchez.cqrs.core.infrastructure.interfaces;

import com.sanchez.cqrs.core.events.BaseEvent;

import java.util.List;

public interface EventStore {

    void saveEvents(String aggregateId, Iterable<BaseEvent> baseEventIterable, int expectedVersion);
    List<BaseEvent> getEvent(String aggregateId);
}
