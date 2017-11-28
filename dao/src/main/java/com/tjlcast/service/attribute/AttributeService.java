package com.tjlcast.service.attribute;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by tangjialiang on 2017/11/28.
 */

public interface AttributeService {
    Optional<String> find(String entityId, String scope, String attributeKey);

    List<String> find(String entityId, String scope, Collection<String> attributeKeys);

    List<String> findAll(String entityId, String scope);

    List<Void> save(String entityId, String scope, List<String> attributes);

    List<Void> removeAll(String entityId, String scope, List<String> attributeKeys);
}
