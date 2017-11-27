package com.tjlcast.service;

import akka.japi.Creator;
import com.tjlcast.ActorSystemContext;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 *  在Actor环境中启动具体Actor的启动类，
 *  封装在具体Actor的内部类中作为启动类。
 */

public abstract class ContextBasedCreator<T> implements Creator<T> {

    protected final ActorSystemContext context ;

    public ContextBasedCreator(ActorSystemContext context) {
        super();
        this.context = context ;
    }
}
