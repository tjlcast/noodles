package com.tjlcast.service.device_credential;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public interface DeviceCredentialsService {
    String findDeviceCredentialsByDeviceId(String deviceId);

    String findDeviceCredentialsByCredentialsId(String credentialsId);

    String updateDeviceCredentials(String deviceCredentials);

    String createDeviceCredentials(String deviceCredentials);

    void deleteDeviceCredentials(String deviceCredentials);
}
