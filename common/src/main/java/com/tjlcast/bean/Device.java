package com.tjlcast.bean;


import lombok.Data;

/**
 * Created by tangjialiang on 2017/11/28.
 */

@Data
public class Device {
    private String deviceName;

    private String deviceId;    // device id
    private String tenantId;    // tenant id
    private String customerId;  // customer id

    private String manufacture; //厂商
    private String type;        //设备类型
    private String model;       //设备型号
}
