package com.tjlcast.actors.shared;

import akka.actor.ActorContext;
import akka.event.LoggingAdapter;
import com.tjlcast.actors.ActorSystemContext;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/29.
 */
public abstract class ComponentMsgProcessor<T> extends AbstractContextAwareMsgProcessor {

    protected final UUID tenantId;
    protected final T entityId;

    protected ComponentMsgProcessor(ActorSystemContext systemContext, LoggingAdapter logger, UUID tenantId, T id) {
        super(systemContext, logger);
        this.tenantId = tenantId;
        this.entityId = id;
    }

    public abstract void start() throws Exception;

    public abstract void stop() throws Exception;

    public abstract void onCreated(ActorContext context) throws Exception;

    public abstract void onUpdate(ActorContext context) throws Exception;

    public abstract void onActivate(ActorContext context) throws Exception;

    public abstract void onSuspend(ActorContext context) throws Exception;

    public abstract void onStop(ActorContext context) throws Exception;

//    public abstract void onClusterEventMsg(ClusterEventMsg msg) throws Exception;

//    public void scheduleStatsPersistTick(ActorContext context, long statsPersistFrequency) {
//        schedulePeriodicMsgWithDelay(context, new StatsPersistTick(), statsPersistFrequency, statsPersistFrequency);
//    }

}
