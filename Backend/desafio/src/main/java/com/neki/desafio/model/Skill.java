package model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill", schema = "public")
public class Skill {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "level")
	private Float level;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "imagem_url")
	private String imagem_url;

	@OneToMany(mappedBy = "id_skill")
	private List<UserSkill> userSkill;

public Skill( Long id, String nome, Float level, String descricao, String imagem_url, List<UserSkill> userSkill) {
	super();
	this.id = id;
	this.nome = nome;
	this.level = level;
	this.descricao = descricao;
	this.imagem_url = imagem_url;
	this.userSkill = userSkill;

}


public Skill() {
}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Float getLevel() {
	return level;
}

public void setVersion(Float level) {
	this.level = level;
}

public String getDescricao() {
	return descricao;
}

public void setDescription(String descricao) {
	this.descricao = descricao;
}

public String getImagem_url() {
	return imagem_url;
}

public void setImagem_url(String imagem_url) {
	this.imagem_url = imagem_url;
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
	Skill other = (Skill) obj;
	return Objects.equals(id, other.id);
}

    
}
