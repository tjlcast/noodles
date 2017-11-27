package com.tjlcast.service;

import akka.actor.UntypedActor;
import com.tjlcast.ActorSystemContext;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 */

public abstract class ContextAwareActor extends UntypedActor{
    ActorSystemContext systemContext ;

    public ContextAwareActor(ActorSystemContext systemContext) {
        super();
        this.systemContext = systemContext ;
    }
}
