package com.example.footballTeam.users.dao;

import com.example.footballTeam.users.model.User;

public interface UserDAO {
    public int addUser(User user);

    public int deleteUser(User user);

    User getUserById(int id);
}
