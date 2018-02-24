package com.wv.mfaraji.SecureWebApp;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wv.mfaraji.SecureWebApp.User.User;
import com.wv.mfaraji.SecureWebApp.User.UserRepository;

@Controller
public class ResourceController {
	@Autowired
	//private DataSource dataSource;
	private UserRepository userRepository;
	
    @RequestMapping("/resources")
    public String greeting(Model model) {
    	List<User> users = new ArrayList<User>();    	
		userRepository.findAll().forEach(u -> users.add(u));		
		model.addAttribute("users", users);
        return "resources";
    }
}
