package com.devi.springboot.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.devi.springboot.model.User;



@Service("userService")
@Repository
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private List<User> users;

	public List<User> findAllUsers() {
		
		users= populateDummyUsers();
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private List<User> populateDummyUsers(){
		/*List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;*/
		return this.entityManager.createQuery("SELECT n FROM User n", User.class)
				.getResultList();
	}

}
