package app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/main")
public class MainController {
//    private UserRepository userRepository;
//
//    @PostMapping
//    public @ResponseBody String addNewUser (@RequestParam String name
//            , @RequestParam String email, Map<String, Object> model){
//        User n = new User(name, email);
//        userRepository.save(n);
//
//        Iterable<User> users = userRepository.getAll();
//        model.put("users", users);
//
//        return "main";
//    }
//
//    @GetMapping
//    public String  main() {
//        return "main";
//    }
////    @GetMapping
////    public String  main(Map<String, Object> model) {
////        // This returns a JSON or XML with the users
////        Iterable<User> users = userRepository.findAll();
////        model.put("users", users);
////        return "main";
////    }

}

