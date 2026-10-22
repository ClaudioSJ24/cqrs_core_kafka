package com.sanchez.cqrs.core.producer.interfaces;

import com.sanchez.cqrs.core.events.BaseEvent;

public interface EventProducer {

    void produce(String topic, BaseEvent baseEvent);
}
