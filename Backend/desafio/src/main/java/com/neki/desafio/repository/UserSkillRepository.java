package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.UserSkill;

public interface UserSkillRepository extends  JpaRepository<UserSkill,Long> {
    
}
