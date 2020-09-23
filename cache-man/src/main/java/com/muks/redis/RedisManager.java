package com.muks.redis;

public class RedisManager {
    private final static Redis INSTANCE = Redis.getInstance();

    private RedisManager() {}

    public static Redis getInstance() {
        return INSTANCE;
    }
}

