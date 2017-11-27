package com.tjlcast.session;

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
 *  SessionManagerActor in the world of actor.
 */

public class SessionManagerActor extends ContextAwareActor{

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this) ;

    private Map<String, ActorRef> sessionActors ;

    public SessionManagerActor(ActorSystemContext context) {
        super(context);
        sessionActors = new HashMap<String, ActorRef>() ;
    }

    public void onReceive(Object message) throws Exception {

    }

    // for creating the sessionManagerActor
    public static class ActorCreator extends ContextBasedCreator<SessionManagerActor> {

        public ActorCreator(ActorSystemContext context) {
            super(context);
        }

        @Override
        public SessionManagerActor create() throws Exception {
            return new SessionManagerActor(context) ;
        }
    }
}
