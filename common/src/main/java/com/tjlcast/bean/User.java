package com.tjlcast.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public class User {
    @Getter @Setter private UUID id;
    @Getter @Setter private String tenantId;
    @Getter @Setter private String name;

    @Getter @Setter private String authority;

    @Getter @Setter private String email;
}
