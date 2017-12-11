package com.tjlcast.actors.service;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.actors.ActorSystemContext;
import com.tjlcast.actors.shared.ComponentMsgProcessor;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/29.
 */
public class ComponentActor<T extends UUID, P extends ComponentMsgProcessor<T>> extends ContextAwareActor {

    protected final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private long lastPersistedErrorTs = 0L ;
    protected final UUID tenantId;
    protected final T id;
    protected P processor;
    private long messagesProcessed;
    private long errorsOccurred;

    public ComponentActor(ActorSystemContext systemContext, UUID tenantId, T id) {
        super(systemContext);
        this.tenantId = tenantId;
        this.id = id;
    }

    protected void setProcessor(P processor) {
        this.processor = processor;
    }

    @Override
    public void preStart() {
        try {
            processor.start();
//            logLifecycleEvent(ComponentLifecycleEvent.STARTED);
//            if (systemContext.isStatisticsEnabled()) {
//                scheduleStatsPersistTick();
//            }
        } catch (Exception e) {
            logger.warning("[{}][{}] Failed to start {} processor: {}", tenantId, id, id.getEntityType(), e);
//            logAndPersist("OnStart", e, true);
//            logLifecycleEvent(ComponentLifecycleEvent.STARTED, e);
        }
    }

    @Override
    public void postStop() {
        try {
            processor.stop();
//            logLifecycleEvent(ComponentLifecycleEvent.STOPPED);
        } catch (Exception e) {
            logger.warning("[{}][{}] Failed to stop {} processor: {}", tenantId, id, id.getEntityType(), e.getMessage());
//            logAndPersist("OnStop", e, true);
//            logLifecycleEvent(ComponentLifecycleEvent.STOPPED, e);
        }
    }

    protected void onComponentLifecycleMsg(ComponentLifecycleMsg msg) {
        try {
            switch (msg.getEvent()) {
                case CREATED:
                    processor.onCreated(context());
                    break;
                case UPDATED:
                    processor.onUpdate(context());
                    break;
                case ACTIVATED:
                    processor.onActivate(context());
                    break;
                case SUSPENDED:
                    processor.onSuspend(context());
                    break;
                case DELETED:
                    processor.onStop(context());
            }
            //logLifecycleEvent(msg.getEvent());
        } catch (Exception e) {
            //logAndPersist("onLifecycleMsg", e, true);
            //logLifecycleEvent(msg.getEvent(), e);
        }
    }
}
