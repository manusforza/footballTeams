package com.example.footballTeam.users.dao;

import com.example.footballTeam.users.model.User;

public interface UserDAO {
    public int addUser(User user);

    public static User getUserById(int id) {
    }

    User getUserById(int id);
}
