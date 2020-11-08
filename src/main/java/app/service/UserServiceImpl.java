package app.service;

import models.User;
import app.repo.RepositoryI;



import java.util.List;


public class UserServiceImpl implements UserService {
    RepositoryI userRepo;

    public UserServiceImpl(RepositoryI userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.getAll();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(User user) {
        userRepo.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) userRepo.getById(id);
    }
}
