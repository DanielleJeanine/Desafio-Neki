package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Users;



public interface UserRepository extends JpaRepository<Users, Long> {

    public Optional<Users> findByLogin(String login);
    
}
