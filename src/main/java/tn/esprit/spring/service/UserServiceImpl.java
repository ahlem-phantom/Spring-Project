package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	public static Logger l =LogManager.getLogger(UserServiceImpl.class);
	
	
	public List<User> retrieveAllUsers(){
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return  list;
	}
	
	 
	@Override
	public User addUser(User u) {
		if(!userRepository.findById(u.getId()).isPresent()) {
			 userRepository.save(u);
			
		}
		else {
			System.out.println("user already exists");
		}
	     return u;
	}
	
	@Override
	public void deleteUser(Long id) {
		  userRepository.deleteById(id);
	}
	
	


	@Override
	public User updateUser(User u) {
    userRepository.save(u);
    return u;
	}


	@Override
	public User retrieveUser(Long id) {
		return userRepository.findById(id).get();  
	}

}
