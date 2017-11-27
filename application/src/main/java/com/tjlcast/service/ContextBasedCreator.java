package com.tjlcast.service;

import akka.japi.Creator;
import com.tjlcast.ActorSystemContext;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 */

public abstract class ContextBasedCreator<T> implements Creator<T> {

    protected final ActorSystemContext context ;

    public ContextBasedCreator(ActorSystemContext context) {
        super();
        this.context = context ;
    }
}
