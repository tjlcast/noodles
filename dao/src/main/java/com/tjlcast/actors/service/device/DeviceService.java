package com.tjlcast.actors.service.device;

import com.tjlcast.bean.Device;

import java.util.List;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public interface DeviceService {
    Device findDeviceById(String deviceId);

    Device saveDevice(Device device);

    Device assignDeviceToUser(String deviceId, String userId);

    Device unassignDeviceFromCustomer(String deviceId);

    void deleteDevice(String deviceId);

    List<Device> findDevicesByTenantId(String tenantId);

    List<Device> findDevicesByTenantIdAndUserId(String tenantId, String userId);
}
