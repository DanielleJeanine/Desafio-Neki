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

import model.UserSkill;
import service.UserSkillService;

@RestController
@RequestMapping("/userSkill")
@CrossOrigin(value = "*")
public class UserSkillController {
    
    @Autowired
	UserSkillService userSkillService;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserSkill> find (@PathVariable Long id){
		if (userSkillService.find(id) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userSkillService.find(id));
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserSkill>> list(){
		return ResponseEntity.ok(userSkillService.list());
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public UserSkill add (@RequestBody UserSkill userSkill) {
		return userSkillService.add(userSkill);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<UserSkill> update (@PathVariable Long id, @RequestBody UserSkill userSkill){
		if (userSkillService.update(id, userSkill) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userSkillService.update(id, userSkill));
		}
	}
	
	@DeleteMapping("{/id}")
	public void delete (@PathVariable Long id) {
		userSkillService.delete(id);
	}
}
