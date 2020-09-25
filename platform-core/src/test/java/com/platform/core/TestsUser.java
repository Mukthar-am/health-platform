package com.platform.core;

import com.muks.redis.RedisManager;

import com.platform.core.metadata.User;
import org.redisson.api.RMap;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestsUser {
    RedisManager CacheManager = null;//new RedisManager().startServer()



    @BeforeTest
    public void initCache() {
        CacheManager = new RedisManager().startServer();
    }

    public void killCache() {
        CacheManager.stopServer();
    }

    @Test
    public void TestUserRegistration() {
        User user = new User();
        user.setName("Mukthar");
        user.setAge(38);
        user.setGender("M");
        user.setId(1);

        User user2 = new User();
        user2.setName("Ahmed");
        user2.setAge(31);
        user2.setGender("M");
        user2.setId(2);

        String nameSpace = "muks";
        RMap<Object, Object> userNameSpace = CacheManager.createNameSpace(nameSpace);
        userNameSpace.put(user.getId(), user);
        userNameSpace.put(user2.getId(), user2);

        try {
            User queriedUser1 = (User) CacheManager.queryNameSpace(nameSpace, user.getId());
            User queriedUser2 = (User) CacheManager.queryNameSpace(nameSpace, user2.getId());

            Assert.assertEquals(queriedUser1.toString(), "(id: 1, name: Mukthar, age: 38, gender: M)");
            Assert.assertEquals(queriedUser2.toString(), "(id: 2, name: Ahmed, age: 31, gender: M)");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
