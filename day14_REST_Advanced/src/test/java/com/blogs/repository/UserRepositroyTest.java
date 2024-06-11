package com.blogs.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.blogs.entities.User;

@DataJpaTest//annotation to tell spring boot test framework to enable 
//Data JPA layer (i.e.service| controller|modemapper ...beans will not be activated
@AutoConfigureTestDatabase(replace=Replace.NONE)
//tells spring boot fmwk not to replace org Data source  
class UserRepositroyTest {
	@Autowired
	private UserRepository userRepository;

	
	
	@Test//JUnit anno to indicate  a test method 
	void testfindByEmailAndPassword() {
		Optional<User> optional= userRepository.findByEmailAndPassword("a3@gmail.com", "4234");
		assertEquals(3l,optional.get().getId());

	}

}
