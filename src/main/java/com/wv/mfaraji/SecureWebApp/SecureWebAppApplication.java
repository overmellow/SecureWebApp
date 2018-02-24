package com.wv.mfaraji.SecureWebApp;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wv.mfaraji.SecureWebApp.User.Role;
import com.wv.mfaraji.SecureWebApp.User.RoleRepository;
import com.wv.mfaraji.SecureWebApp.User.User;
import com.wv.mfaraji.SecureWebApp.User.UserRepository;

@SpringBootApplication
public class SecureWebAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
//	@Autowired
//	private AuthorityRepository authorityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecureWebAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setEmail("mori@mail.com");
		user1.setUsername("mori");
		user1.setPassword(bCryptPasswordEncoder.encode("2000"));

		
		User user2 = new User();
		user2.setEmail("john@mail.com");
		user2.setUsername("john");
		user2.setPassword(bCryptPasswordEncoder.encode("1000"));
				
		Role role1 = new Role();
		role1.setRole("USER");
		
		Role role2 = new Role();
		role2.setRole("ADMIN");
		
		
		
		user1.setRoles(new HashSet<Role>(Arrays.asList(role1)));
		user2.setRoles(new HashSet<Role>(Arrays.asList(role1, role2)));

		role1.setUsers(new HashSet<User>(Arrays.asList(user1)));
//		role2.setUsers(new HashSet<User>(Arrays.asList(user1, user2)));
//				
		roleRepository.save(role1);
		roleRepository.save(role2);
		
		userRepository.save(user1);
		userRepository.save(user2);
		

		
	}
}
