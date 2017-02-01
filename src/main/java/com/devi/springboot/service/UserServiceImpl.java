package com.devi.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devi.springboot.model.User;
import com.devi.springboot.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.findOne(id);
	}


	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user){
		saveUser(user);
	}

	public void deleteUserById(Long id){
		userRepository.delete(id);
	}

	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName()) != null;
	}
}
