package controller;

import java.util.List;
import java.util.Optional;

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

import model.Users;
import service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "*")
public class UserController {
    
    @Autowired
	UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> find (@PathVariable Long id){
		if (userService.find(id) == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userService.find(id));
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> list() {
		return ResponseEntity.ok(userService.list());
	}
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Users add (@RequestBody Users user) {
		return userService.add(user);
	}
	
	@PutMapping("{/id}")
	public ResponseEntity<Users> update (@PathVariable Long id, @RequestBody Users user){
		if (userService.update(id, user) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userService.update(id, user));
		}
	}
	
	@DeleteMapping("{/id}")
	public void delete (@PathVariable Long id) {
		userService.delete(id);
	}
}
