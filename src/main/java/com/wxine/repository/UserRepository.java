package com.wxine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wxine.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	public List<User> findByAccount(String account);
}
