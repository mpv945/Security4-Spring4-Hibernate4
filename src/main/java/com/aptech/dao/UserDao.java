package com.aptech.dao;

import com.aptech.model.User;

public interface UserDao {
	User findByUsername(String username);
}
