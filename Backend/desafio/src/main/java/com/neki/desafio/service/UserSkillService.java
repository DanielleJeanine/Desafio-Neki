package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.UserSkill;
import repository.UserSkillRepository;

@Service
public class UserSkillService {
    @Autowired
	UserSkillRepository userSkillRepository;
	
	public UserSkill find (Long id) {
		Optional<UserSkill> userSkill = userSkillRepository.findById(id);
		if(userSkill.isPresent()) {
			return new UserSkill();
		} else {
			return null;
		}
	}
	
	public List<UserSkill> list(){
		return userSkillRepository.findAll();
	}
	
	public UserSkill add (UserSkill userSkill) {
		userSkill = userSkillRepository.save(userSkill);
		return userSkill;
	}
	
	public UserSkill update (Long id, UserSkill userSkill) {
		if (userSkillRepository.existsById(id)) {
			userSkill.setId(id);
			userSkill = userSkillRepository.save(userSkill);
			return new UserSkill();
		} else {
			return null;
		}
	}
	
	public void delete (Long id) {
		if (userSkillRepository.existsById(id)) {
			userSkillRepository.deleteById(id);
		}
	}
}
