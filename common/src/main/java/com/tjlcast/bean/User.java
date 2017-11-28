package com.tjlcast.bean;

import lombok.Data;

import java.util.UUID;

/**
 * Created by tangjialiang on 2017/11/28.
 */
@Data
public class User {
    private UUID id;
    private String tenantId;
    private String name;

    private String authority;

    private String email;
}
