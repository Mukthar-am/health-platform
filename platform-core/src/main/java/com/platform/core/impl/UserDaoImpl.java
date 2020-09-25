package com.platform.core.impl;

import com.muks.redis.RedisManager;
import com.platform.core.dao.UserDao;
import com.platform.core.metadata.User;

public class UserDaoImpl implements UserDao {
    private static final String NameSpace = "users";

    @Override
    public void registerUser(RedisManager cacheManagerInstance, User user) {
        cacheManagerInstance.getNameSpace(user.getNameSpace()).put(user.getId(), user);
    }

    @Override
    public User getUserById(RedisManager cacheManagerInstance, int userId) {
        return (User) cacheManagerInstance.getNameSpace(NameSpace).get(userId);
    }
}
