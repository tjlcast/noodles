package com.tjlcast.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.tjlcast.ActorSystemContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by tangjialiang on 2017/11/27.
 *
 * 定义service的actor默认类
 */

@Service
@Slf4j
public class DefaultActorService implements ActorService {
    private static final String ACTOR_SYSTEM_NAME = "data-access-system" ;

    @Autowired
    private ActorSystemContext actorContext ;

    private ActorSystem system ;

    private ActorRef appActor ;

    private ActorRef sessionManagerActor ;

    @PostConstruct
    public void initActorSystem() {
        log.info("initializing Actor System.{}", actorContext);
        system = ActorSystem.create(ACTOR_SYSTEM_NAME, actorContext.getConfig()) ;
    }
}
