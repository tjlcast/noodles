package com.tjlcast.actors.shared;

import akka.event.LoggingAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tjlcast.actors.ActorSystemContext;

/**
 * Created by tangjialiang on 2017/11/29.
 */
public abstract class AbstractContextAwareMsgProcessor {

    protected final ActorSystemContext systemContext;
    protected final LoggingAdapter logger;
    protected final ObjectMapper mapper = new ObjectMapper();

    protected AbstractContextAwareMsgProcessor(ActorSystemContext systemContext, LoggingAdapter logger) {
        super();
        this.systemContext = systemContext;
        this.logger = logger;
    }

    protected
}
