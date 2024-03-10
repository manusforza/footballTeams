package com.example.footballTeam.users.repository;

import com.example.footballTeam.users.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    static Map<Integer, User> users = new HashMap<>();
    static int lastIndex = 0;
    public static int addUser(User user) {
        user.setId(++lastIndex);
        users.put(user.getId(), user);
        return 1;
    }

    public static User getUserById (int id) {
        return users.get(id);
    }
}
