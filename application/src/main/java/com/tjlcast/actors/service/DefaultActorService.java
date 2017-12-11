package com.tjlcast.actors.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;
import com.tjlcast.actors.ActorSystemContext;
import com.tjlcast.actors.app.AppActor;
import com.tjlcast.actors.session.SessionManagerActor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import scala.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 * the default world of actor.
 *
 * 由Spring装载启动，之后开始对Actor世界（环境）进行配置:
 * 1、AppActor
 * 2、SessionManagerActor
 * 完成后放入ActorSystemContext.
 */

@Service
@Slf4j
public class DefaultActorService implements ActorService {

    private static final String ACTOR_SYSTEM_NAME = "data-access-system" ;
    public static final String APP_DISPATCHER_NAME = "app-dispatcher" ;
    public static final String CORE_DISPATCHER_NAME = "core-dispatcher" ;
    public static final String SESSION_DISPATCHER_NAME = "session-dispatcher";

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

    @PreDestroy
    public void stopActorSystem() {
        Future<Terminated> status = system.terminate();
        try {
            Terminated result = Await.result(status, Duration.Inf());
        } catch (Exception e) {
            log.error("Fail to terminate actor system.", e) ;
        }
    }
}
