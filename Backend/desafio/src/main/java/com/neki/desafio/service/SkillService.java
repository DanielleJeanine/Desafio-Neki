package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Skill;
import repository.SkillRepository;

@Service
public class SkillService {
    @Autowired
	SkillRepository skillRepository;

	public Skill find(Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if (skill.isPresent()) {
			return new Skill();
		} else {
			return null; 
		}
	}

	public List<Skill> list() {
		return skillRepository.findAll();
	}

	public Skill add (Skill skill) {
		return skillRepository.save(skill);
	

	}

	public Skill update(Long id, Skill skill) {
		if (skillRepository.existsById(id)) {
			skill.setId(id);
			skill = skillRepository.save(skill);
			return new Skill();
		} else {
			return null;
		}
	}

	public void delete(Long id) {
		if (skillRepository.existsById(id)) {
			skillRepository.deleteById(id);
		}

	}
    
}
