CREATE TABLE skill 
( 
 id SERIAL PRIMARY KEY,  
 nome VARCHAR(50) NOT NULL,  
 level VARCHAR(20) NOT NULL,  
 descricao VARCHAR (250),  
 imagem_url VARCHAR(250) NOT NULL,  
 UNIQUE (nome)
);


CREATE TABLE users
( 
 id SERIAL PRIMARY KEY,  
 login VARCHAR(20) NOT NULL,  
 senha VARCHAR(20) NOT NULL,  
 UNIQUE (login)
);

CREATE TABLE users_skill 
( 
 id SERIAL PRIMARY KEY,  
 id_skill INT NOT NULL,  
 id_user INT NOT NULL,
 FOREIGN KEY (id_skill) REFERENCES skill(id),
 FOREIGN KEY (id_user) REFERENCES users(id)
);