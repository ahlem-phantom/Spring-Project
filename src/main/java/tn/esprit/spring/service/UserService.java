package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;

@Service
public interface UserService {
	List<User> retrieveAllUsers ();	
	User addUser (User u);
	void deleteUser (Long id);
	User updateUser (User u);	
	User retrieveUser (Long id);

}
