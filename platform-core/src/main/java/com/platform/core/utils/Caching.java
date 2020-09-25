package com.platform.core.utils;

import com.muks.redis.RedisManager;

public class Caching {
    RedisManager CacheManager = null;//new RedisManager().startServer()
    private static Caching Instance = null;

    public static Caching getInstance() {
        if (null == Instance)
            Instance = new Caching();

        return Instance;
    }

    public Caching init() {
        if (null == CacheManager)
            CacheManager = new RedisManager().startServer();

        return this;
    }

    public void kill() {
        CacheManager.stopServer();
    }

    public RedisManager getCacheManager() {
        return this.CacheManager;
    }
}
