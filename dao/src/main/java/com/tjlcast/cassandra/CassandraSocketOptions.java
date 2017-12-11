package com.tjlcast.cassandra;

import com.datastax.driver.core.SocketOptions;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by tangjialiang on 2017/11/28.
 */

@Component
@Configuration
@Data
public class CassandraSocketOptions {

    private int connectTimeoutMillis;

    private int readTimeoutMillis;

    private Boolean keepAlive;

    private Boolean reuseAddress;

    private Integer soLinger;

    private Boolean tcpNoDelay;

    private Integer receiveBufferSize;

    private Integer sendBufferSize;

    private SocketOptions opts;

    public void initOpts() {
        opts = new SocketOptions() ;
        opts.setConnectTimeoutMillis(connectTimeoutMillis) ;
        opts.setReadTimeoutMillis(readTimeoutMillis) ;

        if (keepAlive != null) {
            opts.setKeepAlive(keepAlive) ;
        }
        if (reuseAddress != null) {
            opts.setReuseAddress(reuseAddress) ;
        }
        if (soLinger != null) {
            opts.setSoLinger(soLinger) ;
        }
        if (tcpNoDelay != null) {
            opts.setTcpNoDelay(tcpNoDelay) ;
        }
        if (receiveBufferSize != null) {
            opts.setReceiveBufferSize(receiveBufferSize);
        }
        if (sendBufferSize != null) {
            opts.setSendBufferSize(sendBufferSize);
        }
    }
}
