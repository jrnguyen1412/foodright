package vn.neways.foodright.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
    public String login() {
        return "/login";
    }
	
	@GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
	
	@GetMapping("/logoutSuccessful")
    public String logout() {
        return "/logoutSuccessful";
    }
	
}
