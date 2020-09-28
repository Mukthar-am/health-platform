package com.platform.core;

import com.muks.redis.RedisManager;
import com.platform.core.impl.UserDaoImpl;
import com.platform.core.metadata.User;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestsUser {
    RedisManager CacheManager = null;//new RedisManager().startServer()
    private final String NameSpace = "muks";

    @BeforeTest
    public void initCache() {
        CacheManager = RedisManager.getInstance();
    }

    @AfterTest
    public void killCache() {
        CacheManager.stopServer();
    }

    @Test
    public void TestUserRegistration() {
        User user = new User(1);
        user.setName("Mukthar");
        user.setAge(38);
        user.setGender("M");

        User user2 = new User(2);
        user2.setName("Ahmed");
        user2.setAge(31);
        user2.setGender("M");


        try {
            /** user registration */
            UserDaoImpl userDaoImpl = new UserDaoImpl();
            userDaoImpl.registerUser(user);
            userDaoImpl.registerUser(user2);

            Assert.assertEquals(
                    CacheManager.getNameSpace(NameSpace).get(user.getId()).toString(),
                    "id=1,name=Mukthar,age=38,gender=M"
            );

            Assert.assertEquals(
                    CacheManager.getNameSpace(NameSpace).get(user2.getId()).toString(),
                    "id=2,name=Ahmed,age=31,gender=M"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test
    public void TestUserCacheQuery() {
        User user = new User(1);
        user.setName("Mukthar");
        user.setAge(38);
        user.setGender("M");

        User user2 = new User(2);
        user2.setName("Ahmed");
        user2.setAge(31);
        user2.setGender("M");

        /** user registration */
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.registerUser(user);
        userDaoImpl.registerUser(user2);


        try {
            User queriedUser1 = (User) CacheManager.queryNameSpace(NameSpace, user.getId());
            User queriedUser2 = (User) CacheManager.queryNameSpace(NameSpace, user2.getId());

            Assert.assertEquals(
                    queriedUser1.toString(),
                    "id=1,name=Mukthar,age=38,gender=M"
            );

            Assert.assertEquals(
                    queriedUser2.toString(),
                    "id=2,name=Ahmed,age=31,gender=M"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void TestUserChangingSchema() {
        User user = new User(1);
        user.setName("Mukthar");
        user.setAge(38);

        User user2 = new User(2);
        user2.setName("Ahmed");
        user2.setGender("M");
        user2.setAge(31);

        User user3 = new User(3);
        user3.setName("Ahmed");
        user3.setGender("M");
        user3.setAge(31);
        user3.setPhoneNumber("+919886653306");


        /** user registration */
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        userDaoImpl.registerUser(user);
        userDaoImpl.registerUser(user2);


        try {
            User queriedUser1 = (User) CacheManager.queryNameSpace(NameSpace, user.getId());
            User queriedUser2 = (User) CacheManager.queryNameSpace(NameSpace, user2.getId());
            User queriedUser3 = (User) CacheManager.queryNameSpace(NameSpace, user3.getId());

            Assert.assertEquals(
                    queriedUser1.toString(),
                    "id=1,name=Mukthar,age=38,gender=M,ph="
            );

            Assert.assertEquals(
                    queriedUser2.toString(),
                    "id=2,name=Ahmed,age=31,gender=M,ph="
            );

            Assert.assertEquals(
                    queriedUser3.toString(),
                    "id=2,name=Ahmed,age=31,gender=M,ph=+919886653306"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
