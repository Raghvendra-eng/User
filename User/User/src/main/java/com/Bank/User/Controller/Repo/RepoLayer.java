package com.Bank.User.Controller.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.User.Controller.entity.User;

public interface RepoLayer extends JpaRepository<User, Long> {

}
