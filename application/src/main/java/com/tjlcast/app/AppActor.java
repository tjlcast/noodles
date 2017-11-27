package com.tjlcast.app;

import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.ActorSystemContext;
import com.tjlcast.service.ContextAwareActor;
import com.tjlcast.service.ContextBasedCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 */

public class AppActor extends ContextAwareActor{

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final Map<String, ActorRef> tenantActors ;

    public AppActor(ActorSystemContext systemContext) {
        super(systemContext);
        this.tenantActors = new HashMap<String, ActorRef>() ;
    }

    public void onReceive(Object message) throws Exception {

    }

    public static class ActorCreator extends ContextBasedCreator<AppActor> {

        public ActorCreator(ActorSystemContext context) {
            super(context);
        }

        @Override
        public AppActor create() throws Exception {
            return new AppActor(context);
        }
    }
}
