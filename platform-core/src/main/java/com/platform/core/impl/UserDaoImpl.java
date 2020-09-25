package com.platform.core.impl;

import com.muks.redis.RedisManager;
import com.platform.core.dao.UserDao;
import com.platform.core.metadata.User;

public class UserDaoImpl implements UserDao {
    private static final String NameSpace = "users";
    RedisManager CacheManager = null;//new RedisManager().startServer()


//    @BeforeTest
//    public void initCache() {
//        CacheManager = new RedisManager().startServer();
//    }
//
//    public void killCache() {
//        CacheManager.stopServer();
//    }

    @Override
    public void registerUser(User user) {
        RedisManager.getInstance().getNameSpace(user.getNameSpace()).put(user.getId(), user);
//                cacheManagerInstance.getNameSpace(user.getNameSpace()).put(user.getId(), user);
    }

    @Override
    public User getUserById(RedisManager cacheManagerInstance, int userId) {
        return (User) cacheManagerInstance.getNameSpace(NameSpace).get(userId);
    }
}
