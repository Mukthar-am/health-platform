package com.muks.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisServer {
    private Config Config = new Config();
    private String RedisHost = "127.0.0.1";
    private int RedisPort = 6379;
    private boolean UseSingleServer = true;

    private static RedisServer Instance = null;
    private RedissonClient RedissonClient;

    private void RedisServer() {}

    public static RedisServer getInstance() {
        if (Instance == null)
            Instance = new RedisServer();

        return Instance;
    }


    public RedisServer startServer() {
        if (Instance.UseSingleServer)
            Instance.Config.useSingleServer();

        String instanceAddress = "redis://" + Instance.RedisHost + ":" + Instance.RedisPort;
        Instance.Config.useSingleServer().setAddress(instanceAddress);
        /** INSTANCE.CONFIG.useClusterServers().addNodeAddress(); // for redis cluster */

        Instance.RedissonClient = Redisson.create(Instance.Config);

        return Instance;
    }


    public void shutdown() {
        Instance.RedissonClient.shutdown();
    }


    public RedissonClient getRedisClient() {
        return this.RedissonClient;
    }
}
