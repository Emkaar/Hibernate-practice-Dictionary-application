package app;

import app.repo.RepositoryI;
import app.repo.UserRepositoryImpl;
import app.service.UserService;
import app.service.UserServiceImpl;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositoryI userRepo = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepo);
        userService.save(new User("Boris", "Boris", "Boris@mail.ru", "english"));
        List<User> userList = userService.getAll();
        for (User user : userList){
            System.out.println(user.getLogin());
        }


    }
}
