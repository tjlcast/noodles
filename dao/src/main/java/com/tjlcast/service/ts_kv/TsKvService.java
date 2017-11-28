package com.tjlcast.service.ts_kv;

import java.util.Collection;
import java.util.List;

/**
 * Created by tangjialiang on 2017/11/28.
 */
public interface TsKvService {
    List<String> findAll(String entityId, List<String> queries);

    List<String> findLatest(String entityId, Collection<String> keys);

    List<String> findAllLatest(String entityId);

    List<Void> save(String entityId, String tsKvEntry);

    List<Void> save(String entityId, List<String> tsKvEntry, long ttl);
}
