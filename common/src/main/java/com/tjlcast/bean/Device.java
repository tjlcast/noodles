package com.tjlcast.bean;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by tangjialiang on 2017/11/28.
 */

public class Device {
    @Getter @Setter private String deviceName;

    @Getter @Setter private String deviceId;    // device id
    @Getter @Setter private String tenantId;    // tenant id
    @Getter @Setter private String customerId;  // customer id

    @Getter @Setter private String manufacture; //厂商
    @Getter @Setter private String type;        //设备类型
    @Getter @Setter private String model;       //设备型号
}
