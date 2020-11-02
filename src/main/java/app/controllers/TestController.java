package app.controllers;

import app.models.User;
import app.service.UserService;
import app.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {

    private UserServiceImpl userService;
    @Autowired
    public TestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/userslist")
    public String getUsersListPage(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("usersList", users);
        return "/userslist";
    }
    @GetMapping(path = "/add-new-user")
    public String menuPage(){
        return "menu";
    }
    @PostMapping(path = "/add-new-user")
    public String signUp(@RequestParam(value = "login") String login,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "nativeLang") String nativeLang){
        User user = new User(login, password, email, nativeLang);
        userService.addNewUser(user);
        return "redirect:/userslist";
    }

}
