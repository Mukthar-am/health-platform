package com.muks.redis;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.io.IOException;

public class RedisManager {
    RedissonClient RedisClient = null;

    public RedisManager startServer() {
        if (RedisClient == null)
            RedisClient = RedisServer.getInstance().startServer().getRedisClient();

        return this;
    }

    public void stopServer() {
        RedisServer.getInstance().shutdown();
    }

    public RedissonClient getRedisClient() {
        return this.RedisClient;
    }

    public RMap<Object, Object> addMap(String name) {
        return RedisClient.getMap(name);
    }


    public static void main(String[] args) throws IOException {

        RedisManager redisManager = new RedisManager().startServer();

        RMap user = redisManager.addMap("user");
        user.put("muks", "78");

        System.out.println("user: " + user.get("muks"));


        redisManager.stopServer();


//
//        RMap map = redisClient.getMap("myMap");
//        map.put("a", 1);
//        map.put("b", 2);
//        map.put("c", 3334);
//
//        boolean contains = map.containsKey("a");
//        System.out.println("Contains \"a\" - " + contains);
//
//        Integer value = (Integer) map.get("c");
//        System.out.println("value=" + value);
//
//        Integer updatedValue = (Integer) map.addAndGet("a", 32);
//        System.out.println("updatedValue=" + updatedValue);
//
//
//        Set keys = new HashSet();
//        keys.add("a");
//        keys.add("b");
//        keys.add("c");
//        Map mapSlice = map.getAll(keys);
//        System.out.println("all keys: " + mapSlice.toString());

//        // use read* methods to fetch all objects
//        Set allKeys = map.readAllKeySet();
//        System.out.println("all keys: " + mapSlice.toString());
//
//        Collection allValues = map.readAllValues();
//        System.out.println("all keys: " + mapSlice.toString());
//
//        Set allEntries = map.readAllEntrySet();
//        System.out.println("allEntries: " + allEntries.toString());
//
//        // use fast* methods when previous value is not required
//        boolean isNewKey = map.fastPut("aa", 100);
//        System.out.println("isNewKey: " + isNewKey);
//
//        boolean isNewKeyPut = map.fastPutIfAbsent("d", 33);
//        System.out.println("isNewKeyPut: " + isNewKeyPut);
//
//        long removedAmount = map.fastRemove("b");
//        System.out.println("removedAmount: " + removedAmount);

//        redisClient.shutdown();
    }

}

