package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Users;
import repository.UserRepository;

@Service
public class UserService {
    @Autowired
	UserRepository userRepository;
	
	public Optional<Users> find (Long id) {
		return userRepository.findById(id);
	}
	
	public List<Users> list () {
		return userRepository.findAll();
	}
	
	public Users add (Users user) {
		user = userRepository.save(user);
		return new Users();
		
	}
	
	public Users update (Long id, Users user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			user = userRepository.save(user);
			return new Users();
		} else {
			return null;
		}
	}
	
	public void delete (Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
	}
    
}
