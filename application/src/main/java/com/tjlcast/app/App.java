package com.tjlcast.app;

import com.tjlcast.ActorSystemContext;
import com.tjlcast.service.ContextAwareActor;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 */

public class App extends ContextAwareActor{
    public App(ActorSystemContext systemContext) {
        super(systemContext);
    }

    public void onReceive(Object message) throws Exception {

    }
}
