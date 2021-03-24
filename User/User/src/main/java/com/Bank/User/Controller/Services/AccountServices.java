package com.Bank.User.Controller.Services;


import com.Bank.User.Controller.entity.User;

public interface AccountServices {
	
	public User updateUser(User user);
	
	public User getUser(long accountNumber);
}
