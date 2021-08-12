package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import java.util.HashSet;
import java.util.Set;

@Controller
@EnableWebMvc
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "views/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "views/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "views/new";
    }

    @PostMapping
    public String createUser
            (@ModelAttribute("user") User user, @RequestParam(required = false) String adminRole) {
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getRoleById(2L));
        if (adminRole != null && adminRole.equals(roleService.getRoleById(1L).getRole())) {
            userRoles.add(roleService.getRoleById(1L));
        }
        user.setRoles(userRoles);
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(@ModelAttribute("user") User user) {
        return "views/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
