package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    
}
