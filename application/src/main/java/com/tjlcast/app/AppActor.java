package com.tjlcast.app;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.ActorSystemContext;
import com.tjlcast.service.ContextAwareActor;
import com.tjlcast.service.ContextBasedCreator;
import com.tjlcast.service.DefaultActorService;
import com.tjlcast.tenant.TenantActor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 * AppActor in the world of Actor
 */

public class AppActor extends ContextAwareActor{

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final Map<String, ActorRef> tenantActors ;

    public AppActor(ActorSystemContext systemContext) {
        super(systemContext);
        this.tenantActors = new HashMap<String, ActorRef>() ;
    }

    public void onReceive(Object message) throws Exception {
        // todo
    }

    private ActorRef getOrCreateTenantActor(final String tenantId) {
        return tenantActors.computeIfAbsent(tenantId, k -> context().actorOf(Props.create(new TenantActor.ActorCreator(systemContext, tenantId))
                .withDispatcher(DefaultActorService.CORE_DISPATCHER_NAME), tenantId.toString()));
    }

    // for creating the AppActor
    public static class ActorCreator extends ContextBasedCreator<AppActor> {
        /**
         * this class is the inner class of AppActor,
         * so could new an AppActor by this class.
         */

        public ActorCreator(ActorSystemContext context) {
            super(context);
        }

        @Override
        public AppActor create() throws Exception {
            return new AppActor(context);
        }
    }
}
