package com.tjlcast.device;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.ActorSystemContext;
import com.tjlcast.service.ContextAwareActor;
import com.tjlcast.service.ContextBasedCreator;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class DeviceActor extends ContextAwareActor{

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final String tenantId ;
    private final String deviceId ;

    private DeviceActor(ActorSystemContext context, String tenantId, String deviceId) {
        super(context);
        this.tenantId = tenantId ;
        this.deviceId = deviceId ;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        // todo
    }

    public static class ActorCreator extends ContextBasedCreator<DeviceActor> {
        private static final long serialVersionUID = 1L ;

        private final String tenantId ;
        private final String deviceId ;

        public ActorCreator(ActorSystemContext context, String tenantId, String deviceId) {
            super(context);
            this.tenantId = tenantId ;
            this.deviceId = deviceId ;
        }

        @Override
        public DeviceActor create() throws Exception {
            return new DeviceActor(context, tenantId, deviceId) ;
        }
    }
}
