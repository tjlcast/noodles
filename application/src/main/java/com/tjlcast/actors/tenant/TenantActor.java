package com.tjlcast.actors.tenant;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.actors.ActorSystemContext;
import com.tjlcast.actors.device.DeviceActor;
import com.tjlcast.actors.service.ContextAwareActor;
import com.tjlcast.actors.service.ContextBasedCreator;
import com.tjlcast.actors.service.DefaultActorService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjialiang on 2017/11/28.
 *
 */
public class TenantActor extends ContextAwareActor{

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final String tenantId ;
    private final Map<String, ActorRef> deviceActors ;

    private TenantActor(ActorSystemContext context, String tenantId) {
        super(context) ;
        this.tenantId = tenantId ;
        deviceActors = new HashMap<String, ActorRef>() ;
    }

    private ActorRef getOrCreateDeviceActor(final String deviceId) {
        return deviceActors.computeIfAbsent(deviceId, k -> context().actorOf(Props.create(new DeviceActor.ActorCreator(systemContext, tenantId, deviceId))
                .withDispatcher(DefaultActorService.CORE_DISPATCHER_NAME), deviceId.toString()));
    }

    @Override
    public void onReceive(Object message) throws Exception {
        // todo
    }

    public static class ActorCreator extends ContextBasedCreator<TenantActor> {
        private static final long serialVersionUID = 1L ;

        private final String tenantId ;

        public ActorCreator(ActorSystemContext context, String tenantId) {
            super(context);
            this.tenantId = tenantId ;
        }

        @Override
        public TenantActor create() throws  Exception {
            return new TenantActor(context, tenantId) ;
        }
    }
}
