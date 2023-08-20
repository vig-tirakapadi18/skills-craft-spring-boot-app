package com.skillsCraft.services;

import com.skillsCraft.entities.Users;

public interface UsersService {
	String addUser(Users user);
	Users findUserByEmail(String email);
	boolean checkEmail(String email);
	String saveUsers(Users user);
}
