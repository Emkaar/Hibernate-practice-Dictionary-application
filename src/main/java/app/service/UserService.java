package app.service;

import models.User;

import java.util.List;


public interface UserService {
    void save(User user);

    void delete(User user);

    List<User> getAll();

    User getById(Integer id);
}
