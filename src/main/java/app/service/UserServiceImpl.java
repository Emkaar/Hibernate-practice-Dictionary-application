package app.service;

import app.models.User;
import app.repo.RepositoryI;
import app.repo.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl{
    RepositoryI userRepo = new UserRepositoryImpl();

    @Autowired
    public UserServiceImpl(@Qualifier("userRepositoryImpl") RepositoryI userRepo) {
        this.userRepo = userRepo;
    }

    public void addNewUser(User user){
            userRepo.save(user);
    }

    public boolean checkUser(User user){
        List<User> checkedList = userRepo.getListWithParam("login", user.getLogin());
        if(checkedList.size() == 0){
            return false;
        }
        User checkedUser = checkedList.get(0);
        return checkedUser.getPassword().equals(user.getPassword());
    }

    public List<User> getAllUsers(){
        return userRepo.getAll();
    }
}
