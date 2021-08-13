package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import web.service.UserService;

import java.security.Principal;

@Controller
@EnableWebMvc
@RequestMapping
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String printUsers(Model model, Principal principal) {
        model.addAttribute("user" , userService.findByUsername(principal.getName()));
        return "views/show";
    }

}
