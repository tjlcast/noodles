package com.tjlcast.session;

import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.tjlcast.ActorSystemContext;
import com.tjlcast.service.ContextAwareActor;
import com.tjlcast.service.ContextBasedCreator;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class SessionActor extends ContextAwareActor {

    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this) ;

    private final String sessionId ;

    private SessionActor(ActorSystemContext systemContext, String sessionId) {
        super(systemContext);
        this.sessionId = sessionId ;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        // todo
    }

    public static class ActorCreator extends ContextBasedCreator<SessionActor> {
        private static final long serialVersionUID = 1L ;

        private final String sessionId ;

        public ActorCreator(ActorSystemContext context, String sessionId) {
            super(context);
            this.sessionId = sessionId ;
        }

        @Override
        public SessionActor create() throws Exception {
            return new SessionActor(context, sessionId) ;
        }
    }
}
