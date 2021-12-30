package com.FTR.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FTR.User.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
