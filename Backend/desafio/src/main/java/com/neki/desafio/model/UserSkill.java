package model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_skill",  schema = "public")
public class UserSkill {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users user_id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_skill")
	private Skill skill_id;

	public UserSkill(Long id, Users user_id, Skill skill_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.skill_id = skill_id;
	}

	public UserSkill() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public Skill getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Skill skill_id) {
		this.skill_id = skill_id;
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
		UserSkill other = (UserSkill) obj;
		return Objects.equals(id, other.id);
	}
    
}
