package com.bci.test.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bci.test.client.entity.User;

@Repository
public interface UserRerpository extends JpaRepository<User, Integer>{

	@Query("select email from User u where u.email = :mail")
	public String validateMail(String mail);
}
