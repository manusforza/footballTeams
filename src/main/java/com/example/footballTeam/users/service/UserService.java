package com.example.footballTeam.users.service;

import com.example.footballTeam.users.dao.UserDAO;
import com.example.footballTeam.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserDAO userDAO;
    @Autowired
    public UserService(@Qualifier("firstUserDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String addUser(User user) {
        int result = userDAO.addUser(user);
        if (result == 1) {
            return "Utente salvato correttamente";
        } else {
            return "Errore nel salvataggio dell'utente";
        }
    }

    public User getUser(int id) {
        return UserDAO.getUserById(id);
    }
}
