package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    User user1 = new User("Slava", "Vasin", "sdad@daas.com");
    User user2 = new User("Slava", "Vasin", "sdad@daas.com");


    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.show(id));
//        return "/edit";
//    }

    //    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
//        userService.update(id, user);
//        return "redirect:/";
//    }
    @GetMapping("/user-remove/{id}")
    public String remove(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

//    @GetMapping("/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") long id, Model model) {
//        model.addAttribute("update", userService.update();)
//        return "user-update";
//    }
//
//    @PostMapping("/")
//    public String updateUser(User user) {
//        userService.update(user);
//        return "redirect:/";
//    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.show(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/";
    }
}
