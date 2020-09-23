package com.platform.core.dao;

import com.platform.core.metadata.User;

public interface UserDao {
    public void registerUser(int id);

    public User getUser();
}
