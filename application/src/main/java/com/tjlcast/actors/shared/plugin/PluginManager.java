package com.tjlcast.actors.shared.plugin;

import akka.actor.ActorContext;
import akka.actor.ActorRef;
import com.tjlcast.actors.ActorSystemContext;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/29.
 */
public abstract class PluginManager {
    protected final ActorSystemContext systemContext ;
    protected final Map<UUID, ActorRef> pluginActors ; // <== Map<PluginId, ActorRef>

    public PluginManager(ActorSystemContext systemContext) {
        this.systemContext = systemContext ;
        this.pluginActors = new HashMap<>() ;
    }

    public void init(ActorContext context) {
        // todo
    }

    //abstract FetchFunction<?> getFetchPluginsFunction() ;

    abstract UUID getTenantId() ; // TenantId <== UUID

    abstract String getDispatcherName() ;

    public ActorRef getOfCreatePluginActor(ActorContext context, UUID pluginId) { // PluginId ==> UUID
//            return pluginActors.computeIfAbsent(pluginId, pId ->
//            context.actorOf(Props.create())) ;
        return null ;
    }


}
