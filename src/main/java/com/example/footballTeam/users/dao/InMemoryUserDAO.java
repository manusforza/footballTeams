package com.example.footballTeam.users.dao;

import com.example.footballTeam.users.model.User;
import com.example.footballTeam.users.repository.InMemoryDatabase;
import org.springframework.stereotype.Repository;

@Repository("firstUserDAO")
public class InMemoryUserDAO implements UserDAO {

    @Override
    public int addUser(User user) {
        return InMemoryDatabase.addUser(user);
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(int id) {
        return InMemoryDatabase.getUserById(id);
    }
}
