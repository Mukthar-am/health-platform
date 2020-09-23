package com.muks.redis;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Redis {
    private Config CONFIG = null;
    private static Redis instance = null;

    private String REDIS_HOST = "127.0.0.1";
    private int REDIS_PORT = 6379;

    private RMap<Integer, String> USERS;
    private RMap<Integer, String> METRICES;

    /**
     * ToDo: use setter and getters, later
     */
    public RedissonClient REDISSION_CLIENT = null;

    private Redis() {
    }

    public static Redis getInstance() {
        if (instance == null)
            instance = new Redis();

        instance.CONFIG = new Config();
        instance.CONFIG
                .useSingleServer()
                .setAddress("redis://" +
                        instance.REDIS_HOST +
                        ":" +
                        instance.REDIS_PORT);

        instance.REDISSION_CLIENT = Redisson.create(instance.CONFIG);

        instance.USERS = instance.REDISSION_CLIENT.getMap("users");
        instance.METRICES = instance.REDISSION_CLIENT.getMap("metrices");

        return instance;
    }

    public RedissonClient getRedissionClient() {
        return this.REDISSION_CLIENT;
    }

    public RMap<Integer, String> getUsers() {
        return this.USERS;
    }

    public RMap<Integer, String> getMetrices() {
        return this.METRICES;
    }

}