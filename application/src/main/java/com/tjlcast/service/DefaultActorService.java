package com.tjlcast.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.tjlcast.ActorSystemContext;
import com.tjlcast.app.AppActor;
import com.tjlcast.session.SessionManagerActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 * 由Spring装载启动，之后开始对Actor世界（环境）进行配置:
 * 1、AppActor
 * 2、SessionManagerActor
 */

@Service
@Slf4j
public class DefaultActorService implements ActorService {

    private static final String ACTOR_SYSTEM_NAME = "data-access-system" ;
    public static final String APP_DISPATCHER_NAME = "app-dispatcher" ;
    public static final String CORE_DISPATCHER_NAME = "core-dispatcher" ;

    @Autowired
    private ActorSystemContext actorContext ;

    private ActorSystem system ;

    private ActorRef appActor ;

    private ActorRef sessionManagerActor ;

    @PostConstruct
    public void initActorSystem() {
        log.info("initializing Actor System.{}", actorContext);
        system = ActorSystem.create(ACTOR_SYSTEM_NAME, actorContext.getConfig()) ;

        // prepare for app actor.
        appActor = system.actorOf(Props.create(new AppActor.ActorCreator(actorContext)).withDispatcher(APP_DISPATCHER_NAME), "appActor") ;
        actorContext.setAppActor(appActor);

        // prepare for session actors.
        sessionManagerActor = system.actorOf(Props.create(new SessionManagerActor.ActorCreator(actorContext)).withDispatcher(CORE_DISPATCHER_NAME), "sessionManagerActor") ;
        actorContext.setSessionManagerActor(sessionManagerActor);
    }
}
