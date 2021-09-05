package com.wine.user;

import com.wine.wines.WineNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;
    @Autowired private CustomUserDetailsService service;

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        User userExists = repo.findByEmail(user.getEmail());
        if (userExists != null) {
             throw new IllegalStateException("Email already taken!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";

    }

    @GetMapping("/process_register")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @GetMapping("/login")
    public String log(){
        return "login";
    }

   @GetMapping("/logout")
    public String logout(){
        return "index";
    }
}
