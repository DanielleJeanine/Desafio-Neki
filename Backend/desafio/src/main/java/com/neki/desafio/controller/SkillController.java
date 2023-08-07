package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import model.Skill;
import service.SkillService;

@RestController
@RequestMapping("/skill")
@CrossOrigin(value = "*")
public class SkillController {
    @Autowired
	SkillService skillService;

	@GetMapping("/{id}")
	public ResponseEntity<Skill> find (@PathVariable Long id) {
		if (skillService.find(id) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(skillService.find(id));
		}
	}

	@GetMapping
	public ResponseEntity<List<Skill>> list() {
		return ResponseEntity.ok(skillService.list());

	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Skill add (@RequestBody Skill skill) {
		return skillService.add(skill);
	}

	@PutMapping("{/id}")
	public ResponseEntity<Skill> update (@PathVariable Long id, @RequestBody Skill skill) {
		if (skillService.update (id, skill) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(skillService.update(id, skill));
		}
	}
	
	@DeleteMapping("{/id}")
	public void delete (@PathVariable Long id){
		skillService.delete(id);
	}
}
