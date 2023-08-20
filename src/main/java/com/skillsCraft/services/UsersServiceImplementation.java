package com.skillsCraft.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.skillsCraft.entities.Users;
import com.skillsCraft.repositories.UsersRepository;

@Service
public class UsersServiceImplementation 
						implements UsersService{
	
	@Autowired
	UsersRepository uRepo;
	
	public String addUser(Users user) {
		uRepo.save(user);
		return "User Added Successfully!";
	}

	public Users findUserByEmail(String email) {
		return uRepo.findByEmail(email);
		
	}
	
	public boolean checkEmail(String email) {
		return uRepo.existsByEmail(email);
	}

	public String saveUsers(Users user) {
		uRepo.save(user);
		return "User Updated!";
	}
}
