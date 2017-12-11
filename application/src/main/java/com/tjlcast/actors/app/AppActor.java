package com.tjlcast.actors.app;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.actors.ActorSystemContext;
import com.tjlcast.actors.service.ContextAwareActor;
import com.tjlcast.actors.service.ContextBasedCreator;
import com.tjlcast.actors.service.DefaultActorService;
import com.tjlcast.actors.tenant.TenantActor;

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

    private AppActor(ActorSystemContext systemContext) {
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
