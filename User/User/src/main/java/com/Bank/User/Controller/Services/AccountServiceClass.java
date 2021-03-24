package com.Bank.User.Controller.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.User.Controller.Repo.RepoLayer;
import com.Bank.User.Controller.entity.User;

@Service
public class AccountServiceClass implements AccountServices {

	@Autowired
	private RepoLayer repoLayerVari;
	
	@Override
	public User updateUser(User user) {
		return  repoLayerVari.save(user);
	}

	@Override
	public User getUser(long accountNumber) {
		// TODO Auto-generated method stub
		return repoLayerVari.getOne(accountNumber);
	}

}
