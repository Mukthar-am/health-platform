package com.platform.services.cache;

import com.muks.redis.Redis;
import com.muks.redis.RedisManager;

public class CacheManager {

    public static Redis getCacheInstance() {
         return RedisManager.getInstance();
    }
}
