package com.okan.developer.springTodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.okan.developer.springTodo.models.Users;
import com.okan.developer.springTodo.services.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UsersController {
	
	private UsersService usersService;
	
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("registerRequest", new Users());
		return "register_page";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest", new Users());
		return "login_page";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Users users) {
		System.out.println("register request: " + users);
		Users registerUser = usersService.registerUsers(users.getUserName(), users.getPassword(), users.getEmail());
		return registerUser == null ? "error_page" :"redirect:/login_page";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Users users, Model model) {
		System.out.println("login request: " + users);
		Users authenticated = usersService.authenticate(users.getUserName(), users.getPassword());
		if(authenticated != null) {
			model.addAttribute("userLogin", authenticated.getUserName());
			return "todo";
		}else {
			return "error_page";
		}
	}
	@GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Oturumu geçersiz kıl
        }

        // Diğer çıkış işlemleri (örneğin, cookie temizleme vb.) burada yapılabilir.

        return "redirect:/login?logout"; // Çıkış yapıldıktan sonra login sayfasına yönlendir
    }

}
