package com.sanchez.cqrs.core.domain;

import com.sanchez.cqrs.core.events.BaseEvent;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateRoot {

    protected  String id;
    private int version = -1;

    private final List<BaseEvent> changes = new ArrayList<>();
    private final Logger logger = Logger.getLogger(AggregateRoot.class.getName());

    public AggregateRoot(String id) {
        this.id = id;
    }

    protected AggregateRoot() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<BaseEvent> getUncommitedChanges(){
        return this.changes;
    }

    public void markChangesAsCommitted(){
        this.changes.clear();
    }

    protected void applyChanges(BaseEvent baseEvent, Boolean isNewEvent){

        try {

            var method = getClass().getDeclaredMethod("apply", baseEvent.getClass());
            method.setAccessible(true);
            method.invoke(this, baseEvent);

        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, MessageFormat.format("El metodo apply no fue encontrado para {0}", baseEvent.getClass()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Errores aplicando el evento al aggregate root "+e.getMessage());
        }finally {
            if (isNewEvent) {
                changes.add(baseEvent);
            }
        }

    }

    public void raiseEvent(BaseEvent baseEvent){
        applyChanges(baseEvent, true);
    }

    public void replayEvents(Iterable<BaseEvent> baseEventIterable){
        baseEventIterable.forEach(baseEvent -> applyChanges(baseEvent, false));
    }
}
