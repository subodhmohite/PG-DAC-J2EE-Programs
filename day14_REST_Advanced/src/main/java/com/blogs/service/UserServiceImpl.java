package com.blogs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.InvalidCredentialsException;
import com.blogs.dto.AuthDTO;
import com.blogs.dto.UserRespDTO;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserRespDTO authenticateUser(AuthDTO dto) {
		User user=userRepository.findByEmailAndPassword(dto.getEmail(),dto.getPass())
		.orElseThrow(()->
		new InvalidCredentialsException("Invalid Email and Password Try again!!!"));

		return mapper.map(user, UserRespDTO.class);
	}

}
