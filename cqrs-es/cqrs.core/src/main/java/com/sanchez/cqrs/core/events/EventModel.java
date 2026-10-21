package com.sanchez.cqrs.core.events;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

//add builder, data
@Document(collation = "eventStore")
public class EventModel {

    @Id
    private String id;
    private Date timeStamp;
    private String aggregateIdentifier;
    private String aggregateType;
    private int version;
    private String eventType;
    private BaseEvent baseEvent;

    private EventModel() {
    }

    public String getId() { return id; }
    public Date getTimeStamp() { return timeStamp; }
    public String getAggregateIdentifier() { return aggregateIdentifier; }
    public String getAggregateType() { return aggregateType; }
    public int getVersion() { return version; }
    public String getEventType() { return eventType; }
    public BaseEvent getBaseEvent() { return baseEvent; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final EventModel eventModel = new EventModel();

        private Builder() {
        }

        public Builder id(String id) {
            eventModel.id = id;
            return this;
        }

        public Builder timeStamp(Date timeStamp) {
            eventModel.timeStamp = timeStamp;
            return this;
        }

        public Builder aggregateIdentifier(String aggregateIdentifier) {
            eventModel.aggregateIdentifier = aggregateIdentifier;
            return this;
        }

        public Builder aggregateType(String aggregateType) {
            eventModel.aggregateType = aggregateType;
            return this;
        }

        public Builder version(int version) {
            eventModel.version = version;
            return this;
        }

        public Builder eventType(String eventType) {
            eventModel.eventType = eventType;
            return this;
        }

        public Builder baseEvent(BaseEvent baseEvent) {
            eventModel.baseEvent = baseEvent;
            return this;
        }

        public EventModel build() {
            return eventModel;
        }
    }




}
