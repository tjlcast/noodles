package com.tjlcast.actors.plugin;

import java.io.Serializable;

/**
 * Created by tangjialiang on 2017/11/29.
 */
public enum ComponentLifecycleEvent implements Serializable {
    CREATED, STARTED, ACTIVATED, SUSPENDED, UPDATED, STOPPED, DELETED
}