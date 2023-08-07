package model;


import java.util.Collection;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users", schema = "public")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "id_user")
    private List<UserSkill> userSkill;

    public Users(Long id, String login, String senha, List<UserSkill> userSkill) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.userSkill = userSkill;
	}

    public Users() {
        
    }

       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<UserSkill> getUserSkill() {
        return userSkill;
    }

    public void setUsuarioSkill(List<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Users other = (Users) obj;
        return Objects.equals(id, other.id);
    }

}
