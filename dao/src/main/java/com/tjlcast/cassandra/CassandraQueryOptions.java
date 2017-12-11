package com.tjlcast.cassandra;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by tangjialiang on 2017/11/28.
 */

@Component
@Configuration
@Data
public class CassandraQueryOptions {

    private Integer defaultFetchSize ;
    private String readConsistencyLevel ;
    private String writeConsistencyLevel ;

    private QueryOptions opts ;

    private ConsistencyLevel defaultReadConsistencyLevel ;
    private ConsistencyLevel defaultWriteConsistencyLevel ;

    public void initOpt() {
        opts = new QueryOptions() ;
        opts.setFetchSize(defaultFetchSize) ;
    }

    protected ConsistencyLevel getDefaultReaderConsistencyLevel() {
        if (defaultReadConsistencyLevel == null) {
            defaultReadConsistencyLevel = ConsistencyLevel.valueOf(readConsistencyLevel.toUpperCase()) ;
        } else {
            defaultReadConsistencyLevel = ConsistencyLevel.ONE ;
        }
        return defaultReadConsistencyLevel ;
    }

    protected ConsistencyLevel getDefaultWriterConsistencyLevel() {
        if (defaultWriteConsistencyLevel == null) {
            if (writeConsistencyLevel != null) {
                defaultWriteConsistencyLevel = ConsistencyLevel.valueOf(writeConsistencyLevel) ;
            } else {
                defaultWriteConsistencyLevel = ConsistencyLevel.ONE ;
            }
        }
        return defaultWriteConsistencyLevel ;
    }
}
